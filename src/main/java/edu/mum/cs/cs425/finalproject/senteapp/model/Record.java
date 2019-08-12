package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;
    private Long recordNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Loan> loanList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Saving> savingList;

    public Record() {
    }

    public Record(Long recordNumber) {
        this.recordNumber = recordNumber;
        this.loanList = new ArrayList<>();
        this.savingList = new ArrayList<>();
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(Long recordNumber) {
        this.recordNumber = recordNumber;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<Saving> getSavingList() {
        return savingList;
    }

    public void setSavingList(List<Saving> savingList) {
        this.savingList = savingList;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", recordNumber=" + recordNumber +
                ", loanList=" + loanList +
                ", savingList=" + savingList +
                '}';
    }
}
