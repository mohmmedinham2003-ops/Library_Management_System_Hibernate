package service;

import controllers.db.DBConnection;
import controllers.returnBooks.ReturnBookPageController;
import entity.ReturnBookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ReturnBookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;

public class ReturnBookServiceImpl {

    Session sessionFactory = DBConnection.getSessionFactory();

    public boolean returnBooks(ReturnBookDTO returnBookDTO) {

        Transaction transaction = sessionFactory.beginTransaction();

        try {
            ReturnBookEntity returnBookEntity = new ReturnBookEntity();
            returnBookEntity.setCmbBookId(returnBookDTO.getCmbBookId());
            returnBookEntity.setCmbMemberId(returnBookDTO.getCmbMemberId());
            returnBookEntity.setPhoneNumber(returnBookDTO.getPhoneNumber());
            returnBookEntity.setAddress(returnBookDTO.getAddress());
            returnBookEntity.setBorrowedDate(returnBookDTO.getBorrowedDate());
            returnBookEntity.setDueDate(returnBookDTO.getDueDate());
            returnBookEntity.setReturnedDate(returnBookDTO.getReturnedDate());

            transaction.commit();

            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public ObservableList<Integer> getAllBooks() {
        ObservableList<Integer> getBooks = FXCollections.observableArrayList();
        String SQL = "SELECT book_id FROM issue_book";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                getBooks.add(resultSet.getInt("book_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getBooks;

    }

    public ObservableList<Integer> loadMembers() {
        ObservableList<Integer> members = FXCollections.observableArrayList();
        String SQL = "SELECT member_id FROM issue_book";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                members.add(resultSet.getInt("member_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;

    }

    public void loadBorrowList(int book_id, ReturnBookPageController returnBookPageController){
        String SQL = """
                SELECT 
                    m.member_id,
                    m.phone_number,
                    m.address,
                    i.issue_date,
                    i.due_date
                    FROM issue_book i
                    JOIN members m ON i.member_id = m.member_id
                    WHERE i.book_id = ?
                      
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1,book_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            returnBookPageController.fillBorrowingDetails(
                    resultSet.getInt("member_id"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getDate("issue_date").toLocalDate(),
                    resultSet.getDate("due_date").toLocalDate()

            );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
