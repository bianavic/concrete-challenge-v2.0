package com.registration.challenge.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Phone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ddd;
    private String number;

    // @JsonBackReference
    @ManyToOne
    User user;

    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) { this.number = number; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
