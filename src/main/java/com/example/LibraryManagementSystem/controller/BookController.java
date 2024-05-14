package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book addBook (@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable Long id){
        Book dataBook = bookService.getBookById(id);
        if (dataBook == null){
            return ResponseEntity.notFound().build();
        }
        dataBook.setTitle(book.getTitle());
        dataBook.setAuthor(book.getAuthor());
        dataBook.setPublicationYear(book.getPublicationYear());
        dataBook.setIsbn(book.getIsbn());
        Book updatedBook = bookService.updateBook(dataBook);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if (book == null)
            return ResponseEntity.notFound().build();
        bookService.deleteBook(book);
        return ResponseEntity.ok().build();
    }


}
