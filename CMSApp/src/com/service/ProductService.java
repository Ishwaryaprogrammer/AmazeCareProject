package com.service;

import com.enums.SortDirection;
import com.enums.ProductSortField;
import com.model.Product;
import com.util.ProductSortUtility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductService {


    public List<Product> sampleProducts() {
        List<Product> products=new ArrayList<>();
        products.add(new Product(3, "Laptop", 999, LocalDate.of(2025, 1, 10)));
        products.add(new Product(6, "Phone", 499, LocalDate.of(2026, 3, 15)));
        products.add(new Product(2, "Tablet", 299, LocalDate.of(2024, 8, 22)));
        products.add(new Product(8, "Smartwatch", 199, LocalDate.of(2025, 6, 1)));
        products.add(new Product(13, "Monitor", 349, LocalDate.of(2023, 11, 14)));
        products.add(new Product(7, "Headphones", 149, LocalDate.of(2026, 2, 28)));
        products.add(new Product(5, "Keyboard", 89, LocalDate.of(2024, 1, 5)));
        products.add(new Product(90, "Mouse", 49, LocalDate.of(2024, 1, 5))); // Same date as Keyboard
        products.add(new Product(88, "Gaming Console", 499, LocalDate.of(2025, 11, 20)));
        return products;
    }

    public List<Product> sortProducts(List<Product> list) {
        return list
                .stream()
                .sorted()
                .toList();

    }

    public List<Product> sortProductsCustom(List<Product> list, ProductSortField productSortField, SortDirection sortDirection) {
        if(productSortField.equals(ProductSortField.PRICE)){
            if(sortDirection.equals(SortDirection.ASC)){
                return list.
                        stream()
                        //.sorted(new ProductSortUtility())
                        .sorted((Product p1,Product p2)->p1.getPrice()- p2.getPrice())
                        // .sorted(Comparator.comparingInt(Product::getPrice))
                        .toList();
            }
            if(sortDirection.equals(SortDirection.DESC)) {
                return list.
                        stream()
                        .sorted((p1,p2)->p2.getPrice()- p1.getPrice())
                        .toList();
            }
        }
        if(productSortField.equals(ProductSortField.DATE_OF_PUBLISH)){
            if(sortDirection.equals(SortDirection.ASC)){
                return list.
                        stream()
                        .sorted((p1,p2)->p1.getDateOfPublish().compareTo(p2.getDateOfPublish()))
                       // .sorted(Comparator.comparing(Product::getDateOfPublish))
                        .toList();
            }
            if(sortDirection.equals(SortDirection.DESC)) {
                return list.
                        stream()
                        .sorted((p1,p2)->p2.getDateOfPublish().compareTo(p1.getDateOfPublish()))
                        .toList();
            }
        }
        return list;
    }
}
