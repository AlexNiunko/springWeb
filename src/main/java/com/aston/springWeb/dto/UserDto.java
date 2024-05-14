package com.aston.springWeb.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class UserDto {
    private final long id;
    private final String login;
    private final String password;
    private final String name;
    private final String surname;
    private final int usersRole;
    private final List<ProductDto> purchases;
    private final List<SaleDto> orders;

    public UserDto(long id, String login, String password, String name,String surname, int usersRole, List<ProductDto> purchases, List<SaleDto> orders) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.usersRole = usersRole;
        this.purchases = purchases;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return new String(login.getBytes());
    }

    public String getPassword() {
        return new String(password.getBytes());
    }

    public String getName() {
        return new String(name.getBytes());
    }

    public String getSurname() {
        return new String(surname.getBytes());
    }

    public int getUsersRole() {
        return usersRole;
    }

    public List<ProductDto> getPurchases() {
        return new ArrayList<>(purchases);
    }

    public List<SaleDto> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDto)) return false;
        return getId() == userDto.getId() && getUsersRole() == userDto.getUsersRole() && getLogin().equals(userDto.getLogin()) && getPassword().equals(userDto.getPassword()) && getName().equals(userDto.getName()) && getSurname().equals(userDto.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getName(), getSurname(), getUsersRole());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", usersRole=").append(usersRole);
        sb.append('}');
        return sb.toString();
    }
}
