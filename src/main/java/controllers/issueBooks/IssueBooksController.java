package controllers.issueBooks;

import controllers.db.DBConnection;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.IssueBookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.time.LocalDate;

public class IssueBooksController {


    public ObservableList<Integer> loadMembers() {
        ObservableList<Integer> members = FXCollections.observableArrayList();

        String SQL = "SELECT member_id FROM members";

        Connection connection = DBConnection.getInstance().getConnection();

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

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
