package com.aston.springWeb.dto;

import java.time.LocalDate;
import java.util.Objects;

public final class ProductDescriptionDto {
    private final long id;
    private final long productId;
    private final String countryOfOrigin;
    private final String type;
    private final String brand;
    private final LocalDate issueDate;

    public ProductDescriptionDto(long id,long productId, String countryOfOrigin, String type, String brand, LocalDate issueDate) {
        this.id = id;
        this.productId=productId;
        this.countryOfOrigin = countryOfOrigin;
        this.type = type;
        this.brand = brand;
        this.issueDate = issueDate;
    }

    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public String getCountryOfOrigin() {
        return new String(countryOfOrigin.getBytes()) ;
    }

    public String getType() {
        return new String(type.getBytes());
    }

    public String getBrand() {
        return new String(brand.getBytes());
    }

    public LocalDate getIssueDate() {
        return LocalDate.parse(issueDate.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDescriptionDto that)) return false;
        return getId() == that.getId() && getCountryOfOrigin().equals(that.getCountryOfOrigin()) && getType().equals(that.getType()) && getBrand().equals(that.getBrand()) && getIssueDate().equals(that.getIssueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountryOfOrigin(), getType(), getBrand(), getIssueDate());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDescriptionDto{");
        sb.append("id=").append(id);
        sb.append(", countryOfOrigin='").append(countryOfOrigin).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", issueDate=").append(issueDate);
        sb.append('}');
        return sb.toString();
    }
}
