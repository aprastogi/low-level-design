package com.apoorv;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> productList;

    public ShoppingCart(){
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        Product productWithDiscount = new ProductTypeDiscountPercentageCouponDecorator(new FlatDiscountPercentageCouponDecorator(product, 5),  product.getProductType(),10);
        productList.add(productWithDiscount);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product product : productList){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
