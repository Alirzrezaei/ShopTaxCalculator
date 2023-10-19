/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author U764901
 */
public class ProductsTest {
    
    public ProductsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test 1
     */
    @Test
    public void test4Element() {
       /*
       Input 3:
        > 1 imported bottle of perfume at 27.99
        > 1 bottle of perfume at 18.99
        > 1 packet of headache pills at 9.75
        > 1 box of imported chocolates at 11.25
        */
       
       Product p1 = new Product("bottle of perfume", 27.99, ProductType.BATHROOM, true);
       Product p2 = new Product("bottle of perfume", 18.99, ProductType.BATHROOM, false);
       Product p3 = new Product("packet of headache pills", 9.75, ProductType.MEDICAL, false);
       Product p4 = new Product("chocolates ", 11.25, ProductType.FOOD, true);
       
       Products products = new Products();
       products.addToList(p1);
       products.addToList(p2);
       products.addToList(p3);
       products.addToList(p4);
       
        System.out.println(products.toString());
        System.out.println(products.printTaxes());
        System.out.println(products.printTotal());
        
        assertTrue((""+32.19).equals(""+p1.getPriceAndTax()));
        assertTrue("Sales Taxes 6.70".equals(products.printTaxes()));
        assertTrue("Total 74.68".equals(products.printTotal()));
    }

    /**
     * Test 2
     */
    @Test
    public void test2Element() {
        /*
         Output 2:
           Input 2:
            > 1 imported box of chocolates at 10.00
            > 1 imported bottle of perfume at 47.50
           
        */
        Product p1 = new Product("box of chocolates", 10.00, ProductType.FOOD, true);
       Product p2 = new Product("bottle of perfume", 47.50, ProductType.BATHROOM, true);
       
       
       Products products = new Products();
       products.addToList(p1);
        products.addToList(p2);
       
       
        System.out.println(products.toString());
        System.out.println(products.printTaxes());
        System.out.println(products.printTotal());
        
        assertTrue("Sales Taxes 7.65".equals(products.printTaxes()));
        assertTrue("Total 65.15".equals(products.printTotal()));
        
    }

    /**
     * Test 3.
     */
    @Test
    public void test3Element() {
       /*
        ### INPUT:
        Input 1:
        > 1 book at 12.49
        > 1 music CD at 14.99
        > 1 chocolate bar at 0.85
        */
       
       Product p1 = new Product("book", 12.49, ProductType.BOOK, false);
       Product p2 = new Product("music CD", 14.99, ProductType.ELECTRONICS, false);
       Product p3 = new Product("chocolate bar", 0.85, ProductType.FOOD, false);
       
       Products products = new Products();
       products.addToList(p1);
       products.addToList(p2);
       products.addToList(p3);
       
        System.out.println(products.toString());
        System.out.println(products.printTaxes());
        System.out.println(products.printTotal());
       
        assertTrue((""+14.99).equals(""+p2.getPrice()));
        assertTrue("Sales Taxes 1.50".equals(products.printTaxes()));
        assertTrue("Total 29.83".equals(products.printTotal()));
    }
 
   
}
