package com.gzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.Book;
import com.gzz.service.BookService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/books")
@Api(value = "人员管理", description = "人员管理", tags = { "2.0" })
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.save(book);
	}

	@GetMapping
	public List<Book> findByName(String name) {
		return bookService.findByName(name);
	}

	@DeleteMapping("/{book_no}")
	public void deleteByName(@PathVariable("book_no") String bookNo) {
		bookService.deleteByBookNo(bookNo);
	}

	@GetMapping("/query")
	public Page<Book> findBook(@RequestParam("content") String content) {
		return bookService.searchBook(content);
	}
}
