package com.mightyjava.resource.impl;

import com.mightyjava.domain.Book;
import com.mightyjava.resource.Resource;
import com.mightyjava.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookResourceImpl implements Resource<Book> {

	private static Logger log = LoggerFactory.getLogger(BookResourceImpl.class);

	@Autowired
	private BookService bookService;

	@Override
	public ResponseEntity<Collection<Book>> findAll() {
		log.info("BookResourceImpl - findAll");
		return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> findById(Long id) {
		log.info("BookResourceImpl - findById");
		return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> save(Book book) {
		log.info("BookResourceImpl - save");
		return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Book> update(Book book) {
		log.info("BookResourceImpl - update");
		return new ResponseEntity<>(bookService.update(book), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> deleteById(Long id) {
		log.info("BookResourceImpl - deleteById");
		return new ResponseEntity<>(bookService.deleteById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> invalid() {
		log.info("BookResourceImpl - invalid");
		return new ResponseEntity<>("{'message: 'something is missing, please check everything before sending!!!'}", HttpStatus.OK);
	}

}
