package com.model;

import java.time.LocalDate;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private int price;
    private LocalDate dateOfPublish;

    public Product(int id, String name, int price, LocalDate dateOfPublish) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateOfPublish = dateOfPublish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(LocalDate dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateOfPublish=" + dateOfPublish +
                '}';
    }

    @Override
    public int compareTo(Product o) {
//        if(this.id>o.id) return 1;
//        if(this.id<o.id) return -1;
//        return 0;

        return this.id-o.id;
    }
}
