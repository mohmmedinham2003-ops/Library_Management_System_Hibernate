package service;

import controllers.returnBooks.ReturnBookPageController;
import javafx.collections.ObservableList;
import model.ReturnBookDTO;

public interface ReturnBookService {
    public boolean returnBooks(ReturnBookDTO returnBookDTO);

    public ObservableList<Integer> getAllBooks() ;

    public ObservableList<Integer> loadMembers();

    public void loadBorrowList(int book_id, ReturnBookPageController returnBookPageController);
}
