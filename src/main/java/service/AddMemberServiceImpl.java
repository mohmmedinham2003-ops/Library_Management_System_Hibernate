package service;

import entity.MemberEntity;
import model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.AddMemberRepository;


public class AddMemberServiceImpl implements AddMemberService {
    AddMemberRepository addMemberRepository = new AddMemberRepository();

    public boolean addMember(MemberDTO memberDTO) {
        return addMemberRepository.addMembers(memberDTO);

    }


}

