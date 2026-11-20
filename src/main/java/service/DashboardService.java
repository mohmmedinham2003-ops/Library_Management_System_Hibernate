package service;

import javafx.collections.ObservableList;

import java.util.Map;

public interface DashboardService {
    public ObservableList<Map<String, String>> loadDetails();

    public int loadMemberCount();

    public int LoadBookCount();

    public int LoadIssuedBookCount();

    public int LoadReturnedCount();
}
