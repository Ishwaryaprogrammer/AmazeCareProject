package com.util;

import com.enums.SortDirection;
import com.enums.ProductSortField;
import com.model.Product;
import com.service.ProductService;

import java.util.List;

public class ProductUtil {
    public static void main(String[] args) {
        ProductService productService=new ProductService();
        System.out.println("-------------products------------");
        List<Product> list=productService.sampleProducts();
        list.forEach(System.out::println);
        System.out.println("\n--------------sorted based on id(default sort)-------------");
        List<Product> list1=productService.sortProducts(list);
        list1.forEach(System.out::println);
        System.out.println("\n--------------sorted based on price custom asc-------------");
        List<Product> list2=productService.sortProductsCustom(list, ProductSortField.PRICE,SortDirection.ASC);
        list2.forEach(System.out::println);
        System.out.println("\n--------------sorted based on price custom desc-------------");
        List<Product> list3=productService.sortProductsCustom(list, ProductSortField.PRICE,SortDirection.DESC);
        list3.forEach(System.out::println);
        System.out.println("\n--------------sorted based on dateOfPublish custom asc-------------");
        List<Product> list4=productService.sortProductsCustom(list, ProductSortField.DATE_OF_PUBLISH,SortDirection.ASC);
        list4.forEach(System.out::println);
        System.out.println("\n--------------sorted based on dateOfPublish custom asc-------------");
        List<Product> list5=productService.sortProductsCustom(list, ProductSortField.DATE_OF_PUBLISH,SortDirection.DESC);
        list5.forEach(System.out::println);

    }
}
