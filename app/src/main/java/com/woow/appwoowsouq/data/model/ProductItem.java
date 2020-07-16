package com.woow.appwoowsouq.data.model;

public class ProductItem {
    int product_image;
    String name;
    String details;
    float rate;
    int price;

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductItem(int product_image, String name, String details, float rate, int price) {
        this.product_image = product_image;
        this.name = name;
        this.details = details;
        this.rate = rate;
        this.price = price;
    }
}
