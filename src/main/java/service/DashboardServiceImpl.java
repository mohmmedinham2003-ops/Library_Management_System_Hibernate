package service;

import controllers.db.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import repository.DashBoardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DashboardServiceImpl {

    DashBoardRepository dashBoardRepository = new DashBoardRepository();




    public ObservableList<Map<String, String>> loadDetails() {

        return dashBoardRepository.loaddetail();


    }


    public int loadMemberCount() {


        String SQL = "SELECT COUNT(*) AS totalMembers FROM members";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
            return resultSet.getInt("totalMembers");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return 0;

    }

    public int LoadBookCount() {


        String SQL = "SELECT COUNT(*) AS totalBooks FROM books";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("totalBooks");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int LoadIssuedBookCount() {
        String SQL = "SELECT COUNT(*) AS totalIssuedBooks FROM issue_book";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return resultSet.getInt("totalIssuedBooks");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int LoadReturnedCount() {

        String SQL = "SELECT COUNT(*) AS totalReturnedBooks FROM returned_books";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("totalReturnedBooks");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }


}

