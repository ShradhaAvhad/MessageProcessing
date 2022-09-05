package com.messageing.service;

import com.messageing.model.Sale;

import java.util.*;
import java.util.stream.Collectors;

public class SalesCalculation {

    public Map<String, Integer> reportDataQuantity = new HashMap<>();
    public Map<String, Double> reportDataPrice = new HashMap<>();


    public Map<String, Integer> calculateQuantity(Map<String, List<Sale>> salesGroupByProduct) {
        for (String key :
                salesGroupByProduct.keySet()
        ) {
            reportDataQuantity.put(key, getNumberOfSaleByProductType(salesGroupByProduct, key));
        }
        return reportDataQuantity;
    }

    public Map<String, Double> calculatePrice(Map<String, List<Sale>> salesGroupByProduct) {
        for (String key :
                salesGroupByProduct.keySet()
        ) {
            reportDataPrice.put(key, getProductSaleTotalValue(salesGroupByProduct, key));
        }

        return reportDataPrice;
    }
    public Integer getNumberOfSaleByProductType(Map<String, List<Sale>> salesGroupByProduct, String key) {
        return salesGroupByProduct.get(key).stream().collect(Collectors.summingInt(v -> v.getProductQuantity()));
    }

    public Double getProductSaleTotalValue(Map<String, List<Sale>> salesGroupByProduct, String key) {

        return salesGroupByProduct.get(key).stream().collect(Collectors.summingDouble(v -> v.getProductPrice() * v.getProductQuantity()));
    }
}
