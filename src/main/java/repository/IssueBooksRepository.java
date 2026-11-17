package repository;

import controllers.db.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

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
}
