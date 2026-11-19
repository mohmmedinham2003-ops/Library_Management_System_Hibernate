package repository;

import controllers.db.HibernateUtil;
import entity.IssueBookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.IssueBookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBooksRepository {
    Session session = HibernateUtil.getSession();

    public ObservableList<Integer> loadMember() {
        ObservableList<Integer> members = FXCollections.observableArrayList();

        String SQL = "SELECT member_id FROM members";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //members.add(resultSet.getInt("member_id"));
                members.add(resultSet.getInt("member_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;
    }

    public ObservableList<Integer> loadBook() {
        ObservableList<Integer> books = FXCollections.observableArrayList();

        String SQL = "SELECT book_id FROM books";

        Session session = HibernateUtil.getInstance().getSession();
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

    public boolean issueBook(IssueBookDTO issueBookDTO) {
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
