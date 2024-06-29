package com.example.crud.domain.product;

import jakarta.persistence.*;
import java.util.Objects;

@Table(name="product")
@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;

    // Construtor padrão
    public Product() {
    }

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }

    // Construtor com todos os parâmetros
    public Product(String id, String name, Integer price_in_cents) {
        this.id = id;
        this.name = name;
        this.price_in_cents = price_in_cents;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice_in_cents() {
        return price_in_cents;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice_in_cents(Integer price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    // equals e hashCode usando o campo 'id'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
