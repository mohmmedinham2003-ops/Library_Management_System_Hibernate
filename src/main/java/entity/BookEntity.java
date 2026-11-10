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

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId='" + bookId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", Category='" + Category + '\'' +
                ", publishedyear=" + publishedyear +
                ", quantity=" + quantity +
                '}';
    }

    public BookEntity() {
    }

    public BookEntity(String bookId, String bookTitle, String author, String category, int publishedyear, int quantity) {

        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        Category = category;
        this.publishedyear = publishedyear;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getPublishedyear() {
        return publishedyear;
    }

    public void setPublishedyear(int publishedyear) {
        this.publishedyear = publishedyear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
