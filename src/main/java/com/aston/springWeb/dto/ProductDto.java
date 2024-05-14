package com.aston.springWeb.dto;

import com.aston.springWeb.entity.ProductDescription;
import com.aston.springWeb.entity.Sale;
import com.aston.springWeb.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ProductDto {
    private final long id;
    private final String productName;
    private final double productPrice;
    private final int amount;
    private final ProductDescriptionDto description;
    private final List<UserDto> buyers;
    private final List<SaleDto>sales;

    public ProductDto(long id, String productName, double productPrice, int amount, ProductDescriptionDto description,List<UserDto>buyers,List<SaleDto>sales) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.amount = amount;
        this.description = description;
        this.buyers=buyers;
        this.sales=sales;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return new String(productName.getBytes());
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getAmount() {
        return amount;
    }

    public ProductDescriptionDto getDescription() {
        return new ProductDescriptionDto(
                description.getId(),
                description.getProductId(),
                description.getCountryOfOrigin(),
                description.getType(),
                description.getBrand(),
                description.getIssueDate());
    }

    public List<UserDto> getBuyers() {
        return new ArrayList<>(buyers);
    }

    public List<SaleDto> getSales() {
        return new ArrayList<>(sales);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto that)) return false;
        return getId() == that.getId() && Double.compare(that.getProductPrice(), getProductPrice()) == 0 && getAmount() == that.getAmount() && getProductName().equals(that.getProductName()) && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductPrice(), getAmount(), getDescription());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDto{");
        sb.append("id=").append(id);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productPrice=").append(productPrice);
        sb.append(", amount=").append(amount);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }
}
