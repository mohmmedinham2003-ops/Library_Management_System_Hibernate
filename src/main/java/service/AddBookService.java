package service;

import controllers.db.DBConnection;
import entity.BookEntity;
import model.BookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.AddBookRepository;

public class AddBookService {

    AddBookRepository addBookRepository = new AddBookRepository();
    public boolean addBook(BookDTO bookDTO) {
        return addBookRepository.addBooks(bookDTO);

    }
}
