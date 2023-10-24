/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.util.Objects;

/**
 *
 * @author U764901
 */
public class CartProduct {
    private Product product;
    private int amount;

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    @Override
    public boolean equals(Object obj){
        return this.product.equal(obj);
    }

    public String toString(){
        return "> " + amount + " " + product.isImported() + " " + product.getProductName() + " " +
                (product.getPrice() + product.getTax()); 
    }
}
