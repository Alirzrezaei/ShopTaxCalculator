/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoptaxcalculator;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author U764901
 */
public enum ProductType {
    BOOK("book"), MEDICAL("medical"), FOOD("food"), ELECTRONICS("electronics"), BATHROOM("bathroom"), 
    DINNING("dinning"), BEDROOM("bedroom"), TEXTILE("textile"); 
    
    String type;
    ProductType(String type) {
        this.type = type;
    }

    public String getStringType() {
        return type;
    }
    /**
     * find the productType based on given string
     * @param stringType
     * @return 
     */
    public ProductType getEnumType(String stringType){
        List<ProductType> typeList = Arrays.asList(ProductType.values());
        
        return typeList.stream().filter(pt -> pt.getStringType().equals(stringType)).findFirst().get();
    }
    
    
}
