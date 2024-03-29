package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
