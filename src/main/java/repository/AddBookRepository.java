package repository;

import controllers.db.HibernateUtil;
import entity.BookEntity;
import model.BookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddBookRepository {
    Session session = HibernateUtil.getInstance().getSession();

    public boolean addBooks(BookDTO bookDTO) {

        try {
            Transaction transaction = session.beginTransaction();
            BookEntity bookEntity = new BookEntity();

            bookEntity.setBookTitle(bookDTO.getBookTitle());
            bookEntity.setAuthor(bookDTO.getAuthor());
            bookEntity.setCategory(bookDTO.getCategory());
            bookEntity.setPublishedyear(bookDTO.getPublishedyear());
            bookEntity.setQuantity(bookDTO.getQuantity());

            session.persist(bookEntity);

            transaction.commit();

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
