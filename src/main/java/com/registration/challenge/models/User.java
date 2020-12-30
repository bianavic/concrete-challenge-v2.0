package com.registration.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @JsonProperty("user-name")
    private String name;
    @NotBlank @JsonProperty("user-email")
    private String email;

    // @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //List<Phone> phones;
    private Set<Phone> phone;

    private LocalDateTime created;
    private LocalDateTime modified;
    private Date lastLogin;

    public User(String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
    }

    public User() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Set<Phone> getPhone() { return phone; }
    public void setPhone(Set<Phone> phone) { this.phone = phone; }
}
