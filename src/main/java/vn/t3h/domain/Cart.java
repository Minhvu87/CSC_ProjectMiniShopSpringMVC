package vn.t3h.domain;

public class Cart {

	private String id;
	private Long memberId;
	private int productId;
	private String title;
	private String imageUrl;
	private int price;
	private short quantity;

	public Cart() {
	}

	public Cart(String id, int productId, String title, String imageUrl, int price, short quantity) {
		this.id = id;
		this.productId = productId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

}
