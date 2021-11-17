package com.jjh.service;

import com.jjh.books.Book;
import com.jjh.books.BookException;
import com.jjh.books.Bookshop;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600) // see https://www.baeldung.com/spring-cors
@RestController
@RequestMapping("bookshop")
public class BookshopController {

    private Bookshop bookshop = new Bookshop();

    @GetMapping("{title}")
    public List<Book> getBook(@PathVariable String title) throws SQLException {
        System.out.println("BookshopController.getBook(" + title + ")");
        return this.bookshop.getBookByTitle(title);
    }

    @GetMapping("list")
    public List<Book> getAllBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getBooks();
    }

    @GetMapping("genre/Drama")
    public List<Book> getAllDramaBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Drama");
    }
    @GetMapping("genre/Food")
    public List<Book> getAllFoodBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Food");
    }
    @GetMapping("genre/Children")
    public List<Book> getAllChildrenBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Children");
    }
    @GetMapping("genre/Romance")
    public List<Book> getAllRomanceBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Romance");
    }
    @GetMapping("genre/Technical")
    public List<Book> getAllTechnicalBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Technical");
    }
    @GetMapping("genre/Christmas")
    public List<Book> getAllChristmasBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Christmas");
    }
    @GetMapping("genre/Historical")
    public List<Book> getAllHistoricalBooks() throws SQLException {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getCatagoryBooks("Historical");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody Book book) throws SQLException {
        System.out.println("BookshopController.addBook(" + book + ")");
        this.bookshop.saveBook(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Book book) {
        System.out.println("BookshopController.updateBook(" + book + ")");
        //this.bookshop.updateBook(book);
    }

    @DeleteMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String title) throws SQLException {
        System.out.println("BookshopController.deleteBook(" + title + ")");
        bookshop.deleteBookByTitle(title);
    }

    @ExceptionHandler(BookException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
    public void updateFailure() { }

}
