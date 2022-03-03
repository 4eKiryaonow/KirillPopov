package com.epam.tc.hw5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserTable {

    private Set<User> table = new HashSet<>();

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
