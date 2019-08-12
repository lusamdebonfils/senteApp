package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    private Long memberId;
    private Long memberNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    private String contactNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private  Record record;


    public Member() {
    }

    public Member(Long memberId, Long memberNumber, String firstName, String middleName, String lastName, Address address, String contactNumber, Role role) {
        this.memberId = memberId;
        this.memberNumber = memberNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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
                ", role=" + role +
                '}';
    }
}
