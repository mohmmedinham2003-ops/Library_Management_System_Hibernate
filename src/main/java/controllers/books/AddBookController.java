package controllers.books;

import controllers.db.DBConnection;
import entity.BookEntity;
import model.BookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookController {


    public boolean addBook(BookDTO bookDTO) {
        Session sessionFactory = DBConnection.getSessionFactory();

        try {
            Transaction transaction = sessionFactory.beginTransaction();
            BookEntity bookEntity = new BookEntity();

            bookEntity.setBookTitle(bookDTO.getBookTitle());
            bookEntity.setAuthor(bookDTO.getAuthor());
            bookEntity.setCategory(bookDTO.getCategory());
            bookEntity.setPublishedyear(bookDTO.getPublishedyear());
            bookEntity.setQuantity(bookDTO.getQuantity());

            sessionFactory.persist(bookEntity);

            transaction.commit();

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
