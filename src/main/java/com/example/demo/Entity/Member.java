package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    @NotBlank
    private String name;
    @Email
    @Column(unique = true)
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 10,max = 10)
    private String mobileNo;
    @NotBlank
    private String city;
    @NotBlank
    private String password;
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> bookings;


    public Member(String name, String email, String mobileNo, String city, String password) {
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.city = city;
        this.password = password;
    }

    public Member(int memberId,String name, String email, String mobileNo, String city, String password) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.city = city;
        this.password = password;
    }

    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
