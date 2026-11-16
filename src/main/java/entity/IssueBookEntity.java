package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "issue_book")
public class IssueBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;
    private Integer cmbMemberId;
    private Integer cmbBookId;
    private LocalDate dtpIssueDate;
    private LocalDate dtpDueDate;

    public IssueBookEntity() {
    }

    @Override
    public String toString() {
        return "IssueBookEntity{" +
                "issueId=" + issueId +
                ", cmbMemberId=" + cmbMemberId +
                ", cmbBookId=" + cmbBookId +
                ", dtpIssueDate=" + dtpIssueDate +
                ", dtpDueDate=" + dtpDueDate +
                '}';
    }

    public IssueBookEntity(Integer issueId, Integer cmbMemberId, Integer cmbBookId, LocalDate dtpIssueDate, LocalDate dtpDueDate) {
        this.issueId = issueId;
        this.cmbMemberId = cmbMemberId;
        this.cmbBookId = cmbBookId;
        this.dtpIssueDate = dtpIssueDate;
        this.dtpDueDate = dtpDueDate;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Integer getCmbMemberId() {
        return cmbMemberId;
    }

    public void setCmbMemberId(Integer cmbMemberId) {
        this.cmbMemberId = cmbMemberId;
    }

    public Integer getCmbBookId() {
        return cmbBookId;
    }

    public void setCmbBookId(Integer cmbBookId) {
        this.cmbBookId = cmbBookId;
    }

    public LocalDate getDtpIssueDate() {
        return dtpIssueDate;
    }

    public void setDtpIssueDate(LocalDate dtpIssueDate) {
        this.dtpIssueDate = dtpIssueDate;
    }

    public LocalDate getDtpDueDate() {
        return dtpDueDate;
    }

    public void setDtpDueDate(LocalDate dtpDueDate) {
        this.dtpDueDate = dtpDueDate;
    }
}
