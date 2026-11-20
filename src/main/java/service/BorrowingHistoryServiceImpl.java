package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.BorrowingHistoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BorrowingHistoryServiceImpl implements BorrowingHistoryService {
    BorrowingHistoryRepository borrowingHistoryRepository = new BorrowingHistoryRepository();

    public ObservableList<Map<String,String>> getHistoryTable() {
        return borrowingHistoryRepository.getHistoryTbl();
    }
}
