package com.aston.springWeb.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products",schema = "tool_box")
public class Product {
    @Id
    @Column(name="id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name="product_price")
    private double productPrice;
    @Column(name="amount_of_product")
    private int amount;
    @OneToOne
    @JoinColumn(name="id_product",nullable = true)
    private ProductDescription description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="sales",schema="tool_box",
            joinColumns = @JoinColumn(name= "prod_id",referencedColumnName = "id_product"),
            inverseJoinColumns = @JoinColumn(name="buyer_id",referencedColumnName = "user_id")
    )
    private List<User> buyers;
    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Sale> sales;

    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    public List<User> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<User> buyers) {
        this.buyers = buyers;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId() == product.getId() && Double.compare(product.getProductPrice(), getProductPrice()) == 0 && getAmount() == product.getAmount() && getProductName().equals(product.getProductName()) && getDescription().equals(product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductPrice(), getAmount(), getDescription());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productPrice=").append(productPrice);
        sb.append(", amount=").append(amount);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }
}
