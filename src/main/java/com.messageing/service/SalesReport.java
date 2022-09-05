package com.messageing.service;

import java.util.Map;

public class SalesReport
{

    public void generateReport(Map<String, Integer> reportDataQuantity, Map<String, Double> reportDataPrice)
    {
        System.out.println("\n Log report of total number of Sale and It's total sale value for each product type are as follows:");
        String formatTH = "|%1$-30s|%2$-30s|%3$-20s|\n\n";
        System.out.format(formatTH,"Product Type","Total Quantity","Total Value");
        for (String key : reportDataPrice.keySet()) {
            String formatTD = "|%1$-30s|%2$-30s|%3$-20s|\n";
            System.out.format(formatTD,key, reportDataQuantity.get(key), reportDataPrice.get(key));
        }
    }


}