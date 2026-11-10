package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class MemberEntity {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;


}
