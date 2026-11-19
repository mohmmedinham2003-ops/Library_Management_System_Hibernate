package service;

import controllers.updateMembers.ViewAndUpdateMemberPageController;
import javafx.collections.ObservableList;
import model.ViewAndUpdateMembersDTO;

import java.util.Map;

public interface ViewAndUpdateService {
    public ObservableList<Integer> loadMembers();

    public boolean updateMember(ViewAndUpdateMembersDTO viewAndUpdateMembersDTO);

    public ObservableList<Map<String, String>> getAllMembers();

    public void loadUpdateList(int member_id, ViewAndUpdateMemberPageController viewAndUpdateMemberPageController);
}
