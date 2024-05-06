package com.aston.springWeb.model;

import java.util.List;

public class User {
    private long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int usersRole;

    private List<Product> purchases;

}
