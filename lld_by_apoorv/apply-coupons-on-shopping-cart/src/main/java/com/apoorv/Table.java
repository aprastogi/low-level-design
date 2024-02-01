package com.apoorv;

public class Table extends Product{

    private final double price;

    Table(String name, double price, ProductType productType) {
        super(name, productType);
        this.price = price;
    }

    @Override
    double getPrice() {
        return price;
    }
}
