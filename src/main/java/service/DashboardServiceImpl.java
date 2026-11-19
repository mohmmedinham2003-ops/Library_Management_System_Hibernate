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
        return dashBoardRepository.loadMembersCount();
    }

    public int LoadBookCount() {
        return  dashBoardRepository.loadBooksCount();
    }

    public int LoadIssuedBookCount() {
        return dashBoardRepository.loadIssuedBookCount();
    }

    public int LoadReturnedCount() {
        return dashBoardRepository.loadReturnedCount();
    }


}

