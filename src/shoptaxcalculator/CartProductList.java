/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author U764901
 */
public class CartProductList {

    private List<CartProduct> cartProducts;

    public CartProductList() {
        cartProducts = new LinkedList<>();
    }

    protected boolean contains(CartProduct cartProduct) {
        return cartProducts.stream().anyMatch(cp -> cp.equals(cartProduct.getProduct()));
    }

    protected void addToCart(CartProduct cartProduct) {
        if(cartProduct == null){
            return;
        }
        if (!contains(cartProduct)) {
            cartProducts.add(cartProduct);
        }
        else{
            for(CartProduct cp:cartProducts){
                if(cp.equals(cartProduct.getProduct())){
                    cp.setAmount(cp.getAmount() + 1);
                }
            }
        }
    }
    protected boolean removeFromCart(int productId){
       
        for(CartProduct cp: this.cartProducts){
            if(cp.equals(findInCart(productId).getProduct())){
                System.out.println("removing the product");
                return this.cartProducts.remove(cp);
            }
        }
        return false;
    }
    
    protected CartProduct findInCart(int productId){
        return cartProducts.stream().filter(cp -> cp.getProduct().getProductId() == productId).findFirst().get();
    }
    public String showCart(){
        StringBuilder sb = new StringBuilder();

        cartProducts.stream().forEach(cp -> sb.append(cp.showCart()).append("\n"));

        return sb.toString();
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();

        cartProducts.stream().forEach(cp -> sb.append(cp.toString()).append("\n"));

        return sb.toString();
    }

}
