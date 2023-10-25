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

    private List<CartProduct> cartProducts;

    public CartProductList() {
        cartProducts = new ArrayList<>();
    }

    protected boolean contains(CartProduct cartProduct) {
        return cartProducts.stream().anyMatch(cp -> cp.equals(cartProduct));
    }

    protected void addToCart(CartProduct cartProduct) {
        if(cartProduct == null){
            return;
        }
        if (!contains(cartProduct)) {
            cartProducts.add(cartProduct);
        }
        else{
            cartProduct.setAmount(cartProduct.getAmount()+1);
        }
    }
    protected void removeFromCart(int productId){    
        cartProducts.remove(cartProducts.stream().filter(cp -> cp.getProduct().getProductId() == productId).findFirst().get());
    }
    
    protected CartProduct findInCart(int productId){
        return cartProducts.stream().filter(cp -> cp.getProduct().getProductId() == productId).findFirst().get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        cartProducts.stream().forEach(cp -> sb.append(cp.toString() + "\n"));

        return sb.toString();
    }

}
