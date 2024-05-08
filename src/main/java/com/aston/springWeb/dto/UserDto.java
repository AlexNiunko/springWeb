package com.aston.springWeb.dto;

import java.util.List;

public class UserDto {
    private long idUser;
    private String login;
//    private String password;
//    private String name;
//    private String surname;
//    private int isAdmin;
//    private List<ProductDto> purchases;


    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
