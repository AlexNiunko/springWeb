package com.aston.springWeb.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sales" ,schema = "tool_box")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")

    private long id;
    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Product purchase;
    @ManyToOne
    @JoinColumn(name="buyer_id")
    private User buyer;

    @Column(name = "date_of_sale")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfSale;
    @Column(name = "amount_of_sale")
    private int amountSale;

    public Sale() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getPurchase() {
        return purchase;
    }

    public void setPurchase(Product purchase) {
        this.purchase = purchase;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public int getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(int amountSale) {
        this.amountSale = amountSale;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sale{");
        sb.append("id=").append(id);
        sb.append(", dateOfSale=").append(dateOfSale);
        sb.append(", amountSale=").append(amountSale);
        sb.append('}');
        return sb.toString();
    }
}
