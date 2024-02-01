package com.apoorv;

public abstract class CouponDecorator extends Product {

    Product product;
    double discountPercentage;

    public CouponDecorator(Product product, double discountPercentage){
        this.product = product;
        this.discountPercentage = discountPercentage;
    }
}
