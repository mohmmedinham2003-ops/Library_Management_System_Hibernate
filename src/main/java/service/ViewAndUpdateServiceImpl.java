package service;

import controllers.updateMembers.ViewAndUpdateMemberPageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ViewAndUpdateMembersDTO;
import repository.ViewAndUpdateRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ViewAndUpdateServiceImpl implements ViewAndUpdateService {
    ViewAndUpdateRepository viewAndUpdateRepository = new ViewAndUpdateRepository();

    public ObservableList<Integer> loadMembers() {
        return viewAndUpdateRepository.loadMember();
    }

    public boolean updateMember(ViewAndUpdateMembersDTO viewAndUpdateMembersDTO) {
        return  viewAndUpdateRepository.updateMembers(viewAndUpdateMembersDTO);
    }

    public ObservableList<Map<String, String>> getAllMembers(){
        return viewAndUpdateRepository.getAllMemmber();
    }

    public void loadUpdateList(int member_id, ViewAndUpdateMemberPageController viewAndUpdateMemberPageController){
        viewAndUpdateRepository.loadUpdateLists(member_id,viewAndUpdateMemberPageController);
    }

}
