package com.epam.tc.hw5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserTable {

    private List<User> table = new ArrayList<>();

    public void addUser(User user) {

        table.add(user);

    }

    public void addAllUsers(Collection<User> users) {

        this.table.addAll(users);
    }

    @Override
    public String toString() {
        return table.toString();
    }
}
