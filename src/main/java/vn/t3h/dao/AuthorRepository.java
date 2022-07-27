package vn.t3h.dao;

import java.util.List;

import vn.t3h.domain.Author;
import vn.t3h.mapper.AuthorMapper;

public class AuthorRepository extends Repository {

	public List<Author> getAuthors() {
		return jdbc.query("SELECT * FROM Author", new AuthorMapper());
	}

	public int add(Author obj) {
		return jdbc.update("INSERT INTO Author (AuthorName) VALUES(?)", obj.getName());
	}

	public int edit(Author obj) {
		return jdbc.update("UPDATE Author SET AuthorName = ? WHERE AuthorId = ?", obj.getName(), obj.getId());
	}

	public Author getAuthor(int id) {
		return jdbc.queryForObject("SELECT * FROM Author WHERE AuthorId = ?", new AuthorMapper(), id);
	}

	public int delete(int id) {
		return jdbc.update("DELETE FROM Author WHERE AuthorId = ?", id);
	}
	
	
    public int delete(List<Integer> list) {
    	for(Integer id : list) {
    		jdbc.update("DELETE FROM Author WHERE AuthorId = ?",id);
    	}
    	return 1;
    }
}
