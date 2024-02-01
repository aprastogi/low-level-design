package com.apoorv;

public class PlayStation extends Product{

    private final double price;

    PlayStation(String name, double price, ProductType productType) {
        super(name, productType);
        this.price = price;
    }

    @Override
    double getPrice() {
        return price;
    }
}
