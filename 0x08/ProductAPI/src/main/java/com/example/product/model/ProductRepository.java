package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(long id) {

        return list.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .get();
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {

        int index = list.stream()
                .filter(p -> p.getId() == s.getId())
                .findFirst()
                .map(list::indexOf)
                .get();

        list.set(index, s);
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }

}
