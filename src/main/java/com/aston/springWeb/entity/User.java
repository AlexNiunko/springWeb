package com.aston.springWeb.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users",schema = "tool_box")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="users_role")
    private int usersRole;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sales", schema="tool_box",
            joinColumns = @JoinColumn(name="buyer_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name= "prod_id",referencedColumnName = "id_product")
    )
    private List<Product> purchases;
    @OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Sale>orders;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(int usersRole) {
        this.usersRole = usersRole;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    public List<Sale> getOrders() {
        return orders;
    }

    public void setOrders(List<Sale> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && getUsersRole() == user.getUsersRole() && getLogin().equals(user.getLogin()) && getPassword().equals(user.getPassword()) && getName().equals(user.getName()) && getSurname().equals(user.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getName(), getSurname(), getUsersRole());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
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
