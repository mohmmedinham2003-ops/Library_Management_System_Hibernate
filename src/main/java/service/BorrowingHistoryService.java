package service;

import javafx.collections.ObservableList;

import java.util.Map;

public interface BorrowingHistoryService {
    public ObservableList<Map<String,String>> getHistoryTable();
}
