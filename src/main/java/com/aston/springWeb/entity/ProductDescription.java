package com.aston.springWeb.entity;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="product_descriptions", schema = "tool_box")
public class ProductDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_description")
    private long id;
    @Column(name="product_id")
    @NotNull
    private long productId;
    @Column(name="country_of_origin")
    private String countryOfOrigin;
    @Column(name="type_of_product")
    @NotNull
    private String type;
    @Column(name="brand_of_product")
    private String brand;
    @Column(name="issue_date")
    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate issueDate;

    public ProductDescription() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDescription that)) return false;
        return getId() == that.getId() && getProductId() == that.getProductId() && getCountryOfOrigin().equals(that.getCountryOfOrigin()) && getType().equals(that.getType()) && getBrand().equals(that.getBrand()) && getIssueDate().equals(that.getIssueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductId(), getCountryOfOrigin(), getType(), getBrand(), getIssueDate());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDescription{");
        sb.append("id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", countryOfOrigin='").append(countryOfOrigin).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", issueDate=").append(issueDate);
        sb.append('}');
        return sb.toString();
    }
}
