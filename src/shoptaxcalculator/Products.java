/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author U764901
 */
public class Products {
    
    private List<Product> productList;
    double sumOfTaxes = 0.0;
    double totalPrice = 0.0;
    
    public Products(){
        productList = new LinkedList<>();
    }
    public Products(List myShoppingList){
        this.productList = myShoppingList;
    }
    public List<Product> getProductList(){
        return productList;
    }
    public boolean addToList(Product product){
        productList.add(product);
        return true;
    }
    public boolean removeFromList(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }
    public boolean contains(int productId){
        
        for(Product p: productList){
            if(productId == p.getProductId()){
                return true;
            }
        }
       return false;
    }
    public List<Product> filterMyList(ProductType type){    
        return productList.stream().filter(p -> type == p.getProductType()).collect(Collectors.toList());
    }
    public String printTaxes(){
        sumOfTaxes = 0.0;
        productList.forEach(p -> sumOfTaxes += p.getTax());
        return String.format("Sales Taxes %.2f",sumOfTaxes);
    }
    public String printTotal(){
        totalPrice = 0.0;
        productList.forEach(p -> totalPrice += p.getPriceAndTax());
        return String.format("Total %.2f",  totalPrice);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        productList.stream().forEach(p -> sb.append(p.toString()+"\n"));
        return sb.toString();
    }
}
