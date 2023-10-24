/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author U764901
 */
public class CartProductList {
    private List<CartProduct> CartProducts;

    public CartProductList() {
        CartProducts = new ArrayList<>();
    }
    protected boolean contains(CartProduct cartProduct){
        return CartProducts.stream().anyMatch(cp -> cp.equals(cartProduct));
    }
    
    
     public String toString(){
        StringBuilder sb = new StringBuilder();
        
        CartProducts.stream().forEach(cp -> sb.append(cp.toString() + "\n"));
        
        return sb.toString();
    }
    
}
