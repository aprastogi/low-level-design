package com.apoorv;

public class FlatDiscountPercentageCouponDecorator extends CouponDecorator{

    public FlatDiscountPercentageCouponDecorator(Product product, double discountPercentage) {
        super(product, discountPercentage);
    }

    @Override
    double getPrice() {
        double originalPrice = product.getPrice();
        originalPrice =  originalPrice - (originalPrice * discountPercentage)/100;
        return originalPrice;
    }
}
