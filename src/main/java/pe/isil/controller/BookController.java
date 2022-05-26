package pe.isil.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Book;
import pe.isil.service.BookService;
import pe.isil.service.BookServiceImpl;

import java.util.Optional;

@Controller
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "books";
    }


    @GetMapping("/books/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "books-add";
    }


    @PostMapping("/books/save")
    public String saveBook(Book book) {

        bookService.save(book);

        return "redirect:/books";
    }

    @GetMapping("/books/edit/{isbn}")
    public String BookEdit(@PathVariable String isbn, Model model){

        Optional<Book> book = bookService.getById(isbn);

        model.addAttribute("book", book);
        return "books-edit";
    }

    @PostMapping("/books/update")
    public String BookUpdate(Book Book){

        bookService.update(Book);

        return "redirect:/books";
    }

    @GetMapping("/books/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn){

        Book book = bookService.getById(isbn).stream().findFirst().orElse(null);

        bookService.delete(book);

        return "redirect:/books";
    }
}
