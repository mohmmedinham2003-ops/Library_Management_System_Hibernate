package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    private String bookId;
    private String bookTitle;
    private String author;
    private String Category;
    private int publishedyear;
    private int quantity;



}
