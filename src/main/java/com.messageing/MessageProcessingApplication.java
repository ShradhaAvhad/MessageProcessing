package com.messageing;

import com.messageing.model.Sale;
import com.messageing.reader.MessageFileReader;
import com.messageing.reader.MessageTextFileReader;
import com.messageing.service.SalesReport;
import com.messageing.service.SalesCalculation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageProcessingApplication
{
    public static void main(String[] args)
    {
        MessageFileReader messageFileReader = new MessageTextFileReader("InputDataText.txt");
        List<Sale> saleList  = messageFileReader.readSalesMessages();

        SalesCalculation salesCalculation = new SalesCalculation();
        Map<String, List<Sale>> salesGroupByProduct = saleList.stream().collect(Collectors.groupingBy(sale -> sale.getProductType()));
        Map<String, Integer> reportDataQuantity = salesCalculation.calculateQuantity(salesGroupByProduct);
        Map<String, Double> reportDataPrice = salesCalculation.calculatePrice(salesGroupByProduct);

        SalesReport saleReport = new SalesReport();
        saleReport.generateReport(reportDataQuantity,reportDataPrice);

    }
}