package br.com.concrete.challenge.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String user_name;
    @NotNull
    private String user_email;
    private String user_token;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //@JsonManagedReference
    //private List<Phone> user_phones = new ArrayList<Phone>();

    @OneToMany
    @JoinTable(
            name = "user_phones",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone> phones;

    public List<Phone> getPhones() { return phones; }
    public void setPhones(List<Phone> phones) { this.phones = phones; }


    //public List<Phone> getUser_phones() { return user_phones; }
    //public void setUser_phones(List<Phone> user_phones) { this.user_phones = user_phones; }

    private Date user_created;
    private Date user_modified;
    private Date user_lastLogin;

    public User() {}

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

    public String getUser_token() { return user_token; }
    public void setUser_token(String user_token) { this.user_token = user_token; }

    public Date getUser_lastLogin() { return user_lastLogin; }
    public void setUser_lastLogin(Date user_lastLogin) { this.user_lastLogin = user_lastLogin; }

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
