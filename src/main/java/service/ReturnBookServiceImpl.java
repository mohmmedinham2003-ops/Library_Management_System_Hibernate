package service;

import controllers.returnBooks.ReturnBookPageController;
import entity.ReturnBookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ReturnBookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ReturnBookRepository;

import java.sql.*;

public class ReturnBookServiceImpl {

    ReturnBookRepository returnBookRepository = new ReturnBookRepository();

    public boolean returnBooks(ReturnBookDTO returnBookDTO) {
        return returnBookRepository.returnBook(returnBookDTO);


    }

    public ObservableList<Integer> getAllBooks() {
        return  returnBookRepository.getAllBook();

    }

    public ObservableList<Integer> loadMembers() {
        return returnBookRepository.loadMember();
    }

    public void loadBorrowList(int book_id, ReturnBookPageController returnBookPageController){

        returnBookRepository.loadBorrowLists(book_id,returnBookPageController);

    }

}
