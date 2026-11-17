package repository;

import controllers.db.HibernateUtil;
import entity.MemberEntity;
import model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddMemberRepository {
    Session session = HibernateUtil.getSession();

    public boolean addMembers(MemberDTO memberDTO) {

        try {
            Transaction transaction = session.beginTransaction();
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
