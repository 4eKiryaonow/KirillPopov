package com.epam.tc.hw7.pageobject.entities;

public class CredentialData {

    public static User ROMAN = new User().set(u -> {
        u.setLogin("Roman");
        u.setPassword("Jdi1234");
        u.setUsername("ROMAN IOVLEV");
    });
}
