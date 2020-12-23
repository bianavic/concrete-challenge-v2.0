package com.registration.challenge.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String user_name;
    private String user_email;

    @OneToMany
    @JoinTable(
            name = "users_phones",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone> phone;

    private Date user_created;
    private Date user_modified;
    private Date user_lastLogin;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public Date getUser_created() {
        return user_created;
    }

    public void setUser_created(Date user_created) {
        this.user_created = user_created;
    }

    public Date getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(Date user_modified) {
        this.user_modified = user_modified;
    }

    public Date getUser_lastLogin() {
        return user_lastLogin;
    }

    public void setUser_lastLogin(Date user_lastLogin) {
        this.user_lastLogin = user_lastLogin;
    }
}
