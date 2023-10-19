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
    /**
     * default constructor with initialized list 
     */
    public Products(){
        productList = new LinkedList<>();
    }
    /**
     * constructor receiving list of products
     * @param myShoppingList 
     */
    public Products(List myShoppingList){
        this.productList = myShoppingList;
    }
    /**
     * getter method for product list
     * @return 
     */
    public List<Product> getProductList(){
        return productList;
    }
    /**
     * adding given product to list of products
     * @param product
     * @return 
     */
    public boolean addToList(Product product){
        productList.add(product);
        return true;
    }
    /**
     * removing a product from list products
     * @param product
     * @return 
     */
    public boolean removeFromList(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }
    /**
     * check if the given product id is in list
     * @param productId
     * @return boolean
     */
    public boolean contains(int productId){
        
        for(Product p: productList){
            if(productId == p.getProductId()){
                return true;
            }
        }
       return false;
    }
    /**
     * filtering my the list with given product type
     * @param type
     * @return filtered list
     */
    public List<Product> filterMyList(ProductType type){    
        return productList.stream().filter(p -> type == p.getProductType()).collect(Collectors.toList());
    }
    /**
     * calculate taxes of all products
     * @return string value to print
     */
    public String printTaxes(){
        sumOfTaxes = 0.0;
        productList.forEach(p -> sumOfTaxes += p.getTax());
        return String.format("Sales Taxes %.2f",sumOfTaxes);
    }
    /**
     * calculate total price of all products
     * @return String value to print
     */
    public String printTotal(){
        totalPrice = 0.0;
        productList.forEach(p -> totalPrice += p.getPriceAndTax());
        return String.format("Total %.2f",  totalPrice);
    }
    /**
     * generating all products list string value
     * @return String of all products
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        productList.stream().forEach(p -> sb.append(p.toString()+"\n"));
        return sb.toString();
    }
}
