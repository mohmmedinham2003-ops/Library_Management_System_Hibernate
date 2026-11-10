package entity;

import java.time.LocalDate;

public class ReturnBookEntity {
    private Integer cmbBookId;
    private Integer cmbMemberId;
    private String phoneNumber;
    private String address;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
}
