package service;

import controllers.db.HibernateUtil;
import entity.IssueBookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.IssueBookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IssueBooksRepository;

import java.sql.*;

public class IssueBooksServiceImpl implements IssueBookService{
    IssueBooksRepository issueBooksRepository = new IssueBooksRepository();

    public ObservableList<Integer> loadMembers() {
         return   issueBooksRepository.loadMember();
    }

    public ObservableList<Integer> loadBooks() {
        return issueBooksRepository.loadBook();
    }

    public boolean issuebooks(IssueBookDTO issueBookDTO) {
        return issueBooksRepository.issueBook(issueBookDTO);
    }
}
