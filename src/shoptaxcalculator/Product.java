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

    private static int nameSpace = 0;// to be used after name based on longest name
    private static int priceSpace = 0; // space to be used after price based on longest price
    private static int startOfId = 1000;// start of id for products

    Product(String productName, double price, ProductType productType, boolean imported) {
        this.productId = startOfId++;
        this.productName = productName;
        this.imported = imported;
        this.productType = productType; 
        this.price = price;
        calculateTax();
        
        //calculating number of spaces after name
        if (productName.length() > nameSpace) {
            nameSpace = productName.length();
        }
        //calculating number of spaces after price
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
    /**
     * calculating the space after name and price
     * @param space
     * @param deduction
     * @return string of spaces
     */
    private String freeSpace(int space, int deduction) {
        String s = "";
        for (int i = 0; i <= space - deduction; i++) {
            s += " ";
        }
        return s;
    }
    /**
     * calculating tax of the product
     */
    public void calculateTax() {

        if (!taxException()) {
            tax = price * 10 / 100;
        }
        if (imported) {
            tax += price * 5 / 100;
        }

        tax = Math.ceil(tax * 20) / 20;

    }
    /**
     * check for BOOK, FOOD and MEDICAL types for tax exception
     * @return boolean
     */
    private boolean taxException() {
        return productType == ProductType.BOOK || productType == ProductType.FOOD || productType == ProductType.MEDICAL;
    }
    /**
     * making string format of product
     * @return string the product details
     */
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
