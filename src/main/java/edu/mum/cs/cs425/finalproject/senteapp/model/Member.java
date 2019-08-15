package edu.mum.cs.cs425.finalproject.senteapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private Long memberNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;
    private String contactNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recordId")
    private  Record record;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateJoined;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    private String email;


    public Member() {
    }

    public Member(Long memberNumber, String firstName, String middleName, String lastName, Address address, String contactNumber, Record record, LocalDate dateJoined, Account account, String email) {
        this.memberNumber = memberNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.record = record;
        this.dateJoined = dateJoined;
        this.account = account;
        this.email = email;
        this.user = new User();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Long memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//    @Override
//    public String toString() {
//        return memberNumber + " - " + firstName + " " + middleName + " " + lastName;
//    }


    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberNumber=" + memberNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", contactNumber='" + contactNumber + '\'' +
                ", record=" + record +
                ", dateJoined=" + dateJoined +
                ", account=" + account +
                ", user=" + user +
                ", email='" + email + '\'' +
                '}';
    }
}
