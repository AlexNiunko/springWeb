package com.aston.springWeb.dto;

import com.aston.springWeb.entity.Product;
import com.aston.springWeb.entity.User;

import java.time.LocalDate;
import java.util.Objects;

public final class SaleDto {
    private final long id;
    private final ProductDto purchase;
    private final UserDto buyer;
    private final LocalDate dateOfSale;
    private final int amountSale;

    public SaleDto(long id, ProductDto purchase, UserDto buyer, LocalDate dateOfSale, int amountSale) {
        this.id = id;
        this.purchase = purchase;
        this.buyer = buyer;
        this.dateOfSale = dateOfSale;
        this.amountSale = amountSale;
    }

    public long getId() {
        return id;
    }

    public ProductDto getPurchase() {
        return new ProductDto(
                purchase.getId(),
                purchase.getProductName(),
                purchase.getProductPrice(),
                purchase.getAmount(),
                purchase.getDescription(),
                purchase.getBuyers(),
                purchase.getSales()
        );
    }

    public UserDto getBuyer() {
        return new UserDto(
                buyer.getId(),
                buyer.getLogin(),
                buyer.getPassword(),
                buyer.getName(),
                buyer.getSurname(),
                buyer.getUsersRole(),
                buyer.getPurchases(),
                buyer.getOrders()
        );
    }

    public LocalDate getDateOfSale() {
        return LocalDate.parse(dateOfSale.toString());
    }

    public int getAmountSale() {
        return amountSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleDto saleDto)) return false;
        return getId() == saleDto.getId() && getAmountSale() == saleDto.getAmountSale() && getPurchase().equals(saleDto.getPurchase()) && getBuyer().equals(saleDto.getBuyer()) && getDateOfSale().equals(saleDto.getDateOfSale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPurchase(), getBuyer(), getDateOfSale(), getAmountSale());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SaleDto{");
        sb.append("id=").append(id);
        sb.append(", purchase=").append(purchase);
        sb.append(", buyer=").append(buyer);
        sb.append(", dateOfSale=").append(dateOfSale);
        sb.append(", amountSale=").append(amountSale);
        sb.append('}');
        return sb.toString();
    }
}
