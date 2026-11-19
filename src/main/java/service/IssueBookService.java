package service;

import javafx.collections.ObservableList;
import model.IssueBookDTO;

public interface IssueBookService {
    public ObservableList<Integer> loadMembers();

    public ObservableList<Integer> loadBooks();

    public boolean issuebooks(IssueBookDTO issueBookDTO);
}
