/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.math.BigDecimal;

/**
 *
 * @author U764901
 */
public class Product {

    private int productId;
    private boolean imported;
    private String productName;
    private ProductType productType;
    private Double price;
    private double tax;

    private static int nameSpace = 0;
    private static int priceSpace = 0;
    private static int startOfId = 1000;

    Product(String productName, double price, ProductType productType, boolean imported) {
        this.productId = startOfId++;
        this.productName = productName;
        this.imported = imported;
        this.productType = productType; 
        this.price = price;
        calculateTax();
        
        if (productName.length() > nameSpace) {
            nameSpace = productName.length();
        }
        if (String.valueOf(price).length() > priceSpace) {
            priceSpace = String.valueOf(price).length();
        }
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }
    public double getPriceAndTax(){
        return this.price + this.tax;
    }
    public double getTax() {
        return tax;
    }

    public boolean isImported() {
        return imported;
    }

    public ProductType getProductType() {
        return productType;
    }

    public static void setSpace(int space) {
        Product.nameSpace = space;
    }

    private String freeSpace(int space, int deduction) {
        String s = "";
        for (int i = 0; i <= space - deduction; i++) {
            s += " ";
        }
        return s;
    }

    public void calculateTax() {

        if (!taxException()) {
            tax = price * 10 / 100;
        }
        if (imported) {
            tax += price * 5 / 100;
        }

        tax = Math.ceil(tax * 20) / 20;

    }

    private boolean taxException() {
        return productType == ProductType.BOOK || productType == ProductType.FOOD || productType == ProductType.MEDICAL;
    }

    public String toString() {
        String importedP = "";
        if (imported) {
            importedP = "imported";
        }
        return "" + productId + ", " + importedP + " " + productName + "" + freeSpace(imported ? 0 : "imported".length(), 0) + ""
                + freeSpace(nameSpace, productName.length()) + ", " + String.format("%.2f", getPriceAndTax()) + ","
                + freeSpace(priceSpace, String.valueOf(price).length()) + "" + productType;
    }
}
