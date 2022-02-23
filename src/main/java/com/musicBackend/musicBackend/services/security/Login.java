package com.musicBackend.musicBackend.services.security;

import javax.persistence.*;

@Entity
@Table
public class Login {
    @Id
    @SequenceGenerator(
            name = "login_sequence",
            sequenceName = "login_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login_sequence"
    )

    private Long id;
    private String loginUsername;
    private String userPassword;

    public Login(String loginUsername, String userPassword) {
        this.loginUsername = loginUsername;
        this.userPassword = userPassword;
    }

    public Login(Long id, String loginUsername, String userPassword) {
        this.id = id;
        this.loginUsername = loginUsername;
        this.userPassword = userPassword;
    }

    public Login(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", loginUsername='" + loginUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
