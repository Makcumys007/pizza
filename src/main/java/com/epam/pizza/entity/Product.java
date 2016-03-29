package com.epam.pizza.entity;

import org.joda.money.Money;

public class Product extends BaseEntity {
    private String title;
    private String description;
    private Money price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        isNull(title);
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isNull(description);
        this.description = description;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        isNull(price);
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product title=" + title +
                ", description=" + description +
                ", price=" + price.getAmount().toString()
                ;
    }
}
