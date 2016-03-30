package com.epam.pizza.entity;

import org.joda.money.Money;

public class Product extends BaseEntity {
    private String title;
    private String description;
    private Money price;
    private Type type;
    private String img;

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

    public String getPrice0() {
        return price.getAmount().toString();
    }

    public void setPrice(Money price) {
        isNull(price);
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public static enum  Type {
        PIZZA, SUSHI, DRINK;
    }

}
