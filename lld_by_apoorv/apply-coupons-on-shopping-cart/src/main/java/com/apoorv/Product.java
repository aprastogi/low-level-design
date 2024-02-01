package com.apoorv;

public abstract class Product {
    private String name;
    private ProductType productType;

    Product(){

    }

    Product(String name, ProductType productType){
        this.name = name;
        this.productType = productType;
    }

    public String getName(){
        return name;
    }

    public ProductType getProductType(){
        return productType;
    }

    abstract double getPrice();
}
