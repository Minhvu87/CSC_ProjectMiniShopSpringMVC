package vn.t3h.dao;

import java.util.List;

import vn.t3h.domain.Invoice;
import vn.t3h.domain.InvoiceDetail;
import vn.t3h.mapper.InvoiceDetailMapper;
import vn.t3h.mapper.InvoiceMapper;



public class InvoiceRepository extends Repository {

	public int add(Invoice obj) {
		return jdbc.update("CALL AddInvoice(?, ?, ?, ?, ?)", obj.getId(), obj.getMemberId(), obj.getEmail(),
				obj.getTel(), obj.getAddress());
	}
	
	public List<Invoice> getInvoices() {
		return jdbc.query("SELECT InvoiceId, MemberId, Tel, Address, Email, Invoice.StatusId,StatusName, AddedDate FROM Invoice INNER JOIN Status ON Invoice.StatusId = Status.StatusId", new InvoiceMapper());
	}
	
	public Invoice getInvoice(String id) {
		Invoice invoice = jdbc.queryForObject("SELECT InvoiceId, MemberId, Tel, Address, Email, Invoice.StatusId,StatusName, AddedDate FROM Invoice INNER JOIN Status ON Invoice.StatusId = Status.StatusId WHERE InvoiceId = ?", new InvoiceMapper(), id);
		invoice.setDetails(getInvoiceDetails(id));
		
		return invoice;
	}
	
	public List<InvoiceDetail> getInvoiceDetails(String id){
		return jdbc.query("SELECT * FROM InvoiceDetail INNER JOIN Product ON InvoiceDetail.ProductId = Product.ProductId WHERE InvoiceId = ?", new InvoiceDetailMapper(), id);
	}
}
