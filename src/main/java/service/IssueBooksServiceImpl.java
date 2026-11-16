package service;

import controllers.db.DBConnection;
import entity.IssueBookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.IssueBookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IssueBooksRepository;

import java.sql.*;

public class IssueBooksServiceImpl {
    IssueBooksRepository issueBooksRepository = new IssueBooksRepository();


    public ObservableList<Integer> loadMembers() {
         return   issueBooksRepository.loadMember();


    }

    public ObservableList<Integer> loadBooks() {
        ObservableList<Integer> books = FXCollections.observableArrayList();

        String SQL = "SELECT book_id FROM books";

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(resultSet.getInt("book_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;

    }

    public boolean issuebooks(IssueBookDTO issueBookDTO) {
        Session sessionFactory = DBConnection.getSessionFactory();
        try {
            Transaction transaction = sessionFactory.beginTransaction();

            IssueBookEntity issueBookEntity = new IssueBookEntity();
            issueBookEntity.setCmbMemberId(issueBookDTO.getCmbMemberId());
            issueBookEntity.setCmbBookId(issueBookDTO.getCmbBookId());
            issueBookEntity.setDtpIssueDate(issueBookDTO.getDtpIssueDate());
            issueBookEntity.setDtpDueDate(issueBookDTO.getDtpDueDate());

            transaction.commit();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
