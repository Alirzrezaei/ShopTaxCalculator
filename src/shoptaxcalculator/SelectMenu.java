/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.awt.JobAttributes;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 *
 * @author U764901
 */
public class SelectMenu {

    private Products products;
    private Products filteredProducts;
    private Products myCart;
    private CartProductList myShoppingCart ;

    public SelectMenu() {
        products = products();
        filteredProducts = new Products();
        myCart = new Products();
        myShoppingCart = new CartProductList();
    }
    
    
    /**
     * showing the first menu selection to users
     */
    public void firstMenuSelection() {
        System.out.println("****************************************************************");
        System.out.println("Press 0 to exit");
        System.out.println("Press 1 to see prodcut menu");
        System.out.println("Press 2 to filter frist menu");
        System.out.println("Press 3 to show my cart");
        System.out.println("Press Product id to add to your cart");
        System.out.println("****************************************************************");

        productSelection();
    }
    /*
    Show the products to user to select between them
    */
    private void productSelection() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (sc.hasNextInt()) {
                int selection = sc.nextInt();

                switch (selection) {
                    case 0:
                        System.out.println("Exing the Shop");
                        System.exit(1);
                    case 1:
                        System.out.println("****************************************************************");
                        System.out.println("Press Product id to add to your cart");
                        System.out.println("****************************************************************");
                        productMenu(this.products);
                        break;
                    case 2:
                        System.out.println("****************************************************************");
                        System.out.println("Press Product id to add to your cart");
                        System.out.println("****************************************************************");
                        filterProducts();
                        productMenu(filteredProducts);
                        break;
                    case 3:
                        System.out.println("****************************************************************");
                        System.out.println("Your confirmed cart is:");
                        System.out.println("****************************************************************");
                        productMenu(myCart);
                        System.out.println(myCart.printTaxes());
                        System.out.println(myCart.printTotal());
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Wrong Selection");
                        break;
                }
                System.out.println("Press 0 to back first menu");
                while (true) {

                    if (sc.hasNextInt()) {
                        int userInput = sc.nextInt();
                        if (products.contains(userInput)) {
                            System.out.println("adding to product " + userInput + " to cart");
                            myCart.addToList(products.getProductList().stream().filter(p -> p.getProductId() == userInput).findFirst().get());
                        }else{
                            System.out.println("selected product " + userInput + " is not the product list");
                        }
                        if (userInput == 0) {
                            firstMenuSelection();
                            break;
                        }
                    } else {
                        break;
                    }

                }

            } else {
                System.out.println("Please enter a number!");
                firstMenuSelection();
            }
        }

    }
    /**
     * initialization of the products 
     * @return product objects contains all products
     */
    private Products products() {
        Products products = new Products();

        products.addToList(new Product("Samsung Galaxy S 23", 1299.99, ProductType.ELECTRONICS, true));
        products.addToList(new Product("IPhone 13 Pro Max", 1399.99, ProductType.ELECTRONICS, true));
        products.addToList(new Product("Becoming, Michelle Obama", 12.49, ProductType.BOOK, false));
        products.addToList(new Product("Clean Code, Robert c Martin", 45.99, ProductType.BOOK, false));
        products.addToList(new Product("Citrizin", 13.80, ProductType.MEDICAL, false));
        products.addToList(new Product("Paracetamol", 9.75, ProductType.MEDICAL, false));
        products.addToList(new Product("Bed 200 x 180", 250.0, ProductType.BEDROOM, true));
        products.addToList(new Product("LG Side by Side", 1198.98, ProductType.ELECTRONICS, true));
        products.addToList(new Product("Pizza Tuna", 6.99, ProductType.FOOD, false));
        products.addToList(new Product("Wooden Dinning Table", 14.99, ProductType.DINNING, false));
        products.addToList(new Product("Adidas Shirt", 47.50, ProductType.TEXTILE, true));
        products.addToList(new Product("Adidas Pants", 27.99, ProductType.TEXTILE, true));
        products.addToList(new Product("Milk", 1.99, ProductType.FOOD, false));
        products.addToList(new Product("Siemens Washing Machine", 498.98, ProductType.ELECTRONICS, false));
        products.addToList(new Product("Bathroom matts", 18.99, ProductType.BATHROOM, false));
        products.addToList(new Product("Continuous Delivery in Java", 78.98, ProductType.BOOK, false));
        products.addToList(new Product("Samsung Galaxy Watch 2", 349.99, ProductType.ELECTRONICS, true));
        products.addToList(new Product("Chocolate", 0.85, ProductType.FOOD, false));
        products.addToList(new Product("Rice", 10, ProductType.BEDROOM, true));
        products.addToList(new Product("Carpet", 339.99, ProductType.BEDROOM, true));
        products.addToList(new Product("box of Chocolate", 11.25, ProductType.FOOD, true));

        return products;
    }
    /**
     * this method is printing all products for user
     * @param products 
     */
    private void productMenu(Products products) {

        if (products.getProductList() != null && !products.getProductList().isEmpty()) {
            System.out.println(products.toString());
        } else {
            System.out.println("No products");
        }

    }
    /**
     * the products will be filtered here based on the type
     */
    private void filterProducts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************************");
        System.out.println("Filter with below types of 0 to back first menu");
        System.out.println("BOOK, MEDICAL, FOOD, ELECTRONICS(, BATHROOM, "
                + "DINNING, BEDROOM, TEXTILE");
        System.out.println("****************************************************************");

        String type = sc.next();
        if (checkIfTypeCorrect(type.toLowerCase())) {
            List<Product> filtered = products.filterMyList(getProductType(type.toLowerCase()));
            filteredProducts = new Products(filtered);
        }else{
            if(type.equals("0")){
                firstMenuSelection();
            }
            System.out.println("This type does not exist");
            filterProducts();
        }

    }
    /**
     * check if the given type is between product types
     * @param type
     * @return 
     */
    private boolean checkIfTypeCorrect(String type) {
        for (ProductType productType : ProductType.values()) {
            if (productType.getStringType().equals(type)) {
                return true;
            }
        }
        return false;
    }
    /**
     * this finding the product type using given string value
     * @param stringType
     * @return productType
     */
    private ProductType getProductType(String stringType) {
        List<ProductType> typeList = Arrays.asList(ProductType.values());

        return typeList.stream().filter(pt -> pt.getStringType().equals(stringType)).findFirst().get();
    }

}
