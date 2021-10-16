package fi.kulmala.Bookstore.web;

import fi.kulmala.Bookstore.domain.Book;
import fi.kulmala.Bookstore.domain.BookRepository;
import fi.kulmala.Bookstore.domain.Category;
import fi.kulmala.Bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository repository2;

	public void doSomething() {
		List<Book> books = repository.findByTitle("*");
	}

	// Useless?
	public void doAnotherThing() {
		List<Category> categories = repository2.findByName("*");
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		// category(s)
		model.addAttribute("categories", repository2.findAll());
		return "addbook";
	}

	@PostMapping(value = "/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", repository2.findAll());
		return "editbook";
	}

}
