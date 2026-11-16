package controllers.members;

import controllers.db.DBConnection;
import entity.MemberEntity;
import model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AddMemberController {

    public boolean addMember(MemberDTO memberDTO) {
        Session sessionFactory = DBConnection.getSessionFactory();
        try {
            Transaction transaction = sessionFactory.beginTransaction();
            MemberEntity memberEntity = new MemberEntity();

            memberEntity.setFullName(memberDTO.getFullName());
            memberEntity.setEmail(memberDTO.getEmail());
            memberEntity.setPhoneNumber(memberDTO.getPhoneNumber());
            memberEntity.setAddress(memberDTO.getAddress());

            transaction.commit();

            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

