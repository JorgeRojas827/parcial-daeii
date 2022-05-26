package pe.isil.service;

import pe.isil.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(Book book);
    void update(Book book);
    void delete(Book book);
    List<Book> getAll();
    Optional<Book> getById(String isbn);
}
