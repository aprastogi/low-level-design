package com.apoorv;

import java.util.HashSet;
import java.util.Set;

public class ProductTypeDiscountPercentageCouponDecorator extends CouponDecorator{

    private final ProductType productType;

    static Set<ProductType> eligibleProductTypes = new HashSet<>();

    static {
        eligibleProductTypes.add(ProductType.DECORATIVE_GOODS);
        eligibleProductTypes.add(ProductType.FURNITURE_GOODS);
    }

    public ProductTypeDiscountPercentageCouponDecorator(Product product, ProductType productType, double discountPercentage) {
        super(product, discountPercentage);
        this.productType = productType;
    }

    @Override
    double getPrice() {
        double originalPrice = product.getPrice();
        if(eligibleProductTypes.contains(productType)){
            originalPrice = originalPrice - (originalPrice * discountPercentage)/100;
        }
        return originalPrice;
    }
}
