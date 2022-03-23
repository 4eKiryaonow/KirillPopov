package com.epam.tc.hw7.pageobject.entities;

import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {

    private String login;
    private String password;
    private String username;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
