package vn.t3h.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.t3h.dao.AuthorRepository;
import vn.t3h.domain.Author;

@RestController
public class AuthorApiController {

	AuthorRepository repository = new AuthorRepository();

	@GetMapping("/api/author")
	public List<Author> index() {
		return repository.getAuthors();
	}

	@GetMapping("api/author/{id}")
	public Author detail(@PathVariable("id") int id) {
		return repository.getAuthor(id);
	}

	@PostMapping("api/author")
	public int post(Author obj) {
		return repository.add(obj);
	}

	@PutMapping("api/author")
	public int edit(Author obj) {
		return repository.edit(obj);
	}

	@DeleteMapping("api/author")
	public int delete(int id) {
		return repository.delete(id);
	}
}
