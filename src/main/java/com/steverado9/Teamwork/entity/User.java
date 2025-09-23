package com.steverado9.Teamwork.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //field name

    @Column(name = "first_name", nullable = false)
    private String firstName; //field name

    @Column(name = "last_name", nullable = false)
    private String lastName; //field name

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "job_role", nullable = false)
    private String jobRole;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "address", nullable = false)
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    //default constructor
    public User() {}

    //parameter constructor
    public User(String firstName, String lastName, String email, String password, String gender,
                String jobRole, String department, String address, String created_at) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.jobRole = jobRole;
        this.department = department;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}
