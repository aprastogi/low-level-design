package com.apoorv;

public class Amazon {

    public static void main(String[] args) {
        Product playStation = new PlayStation("ps5", 50000, ProductType.ELECTRONIC_GOODS);
        Product table = new Table("table", 10000, ProductType.FURNITURE_GOODS);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(playStation);
        shoppingCart.addProduct(table);

        System.out.println("Total Price is :: " + shoppingCart.getTotalPrice());
    }
}
