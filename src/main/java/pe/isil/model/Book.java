package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column
    private String isbn;
    @Column
    private String publisherName;
    @Column
    private String authorName;
    @Column(name = "year_book")
    private Integer year;
    @Column
    private String title;
    @Column(name = "price_book")
    private Double price;
}
