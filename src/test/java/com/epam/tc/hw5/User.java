package com.epam.tc.hw5;

import java.util.Objects;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class User {

    private String number;
    private String userName;
    private String description;

    public User(String number, String user, String description) {
        this.number = number;
        this.userName = user;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return number + " " + userName + " " + description;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return new EqualsBuilder()
            .append(number, user.number)
            .append(userName, user.userName)
            .append(description, user.description)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(number)
            .append(userName)
            .append(description)
            .toHashCode();
    }
}
