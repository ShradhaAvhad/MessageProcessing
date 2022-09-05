package com.messageing.reader;

import com.messageing.service.SalesCalculation;
import com.messageing.model.Sale;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class MessageTextFileReader implements MessageFileReader{

    private String fileName;
    private SalesCalculation salesCalculation = new SalesCalculation();

    public MessageTextFileReader(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public List<Sale> readSalesMessages()
    {
       List<Sale> saleList = null;
       try {
            File inputF = new File(this.fileName);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            saleList = br.lines().filter(s -> s!=null && s.length()!=0).limit(10)
           .map(sale -> parseMessage(sale)).collect(Collectors.toList());
            System.out.println("10 messages have been received and application has stopped accepting new messages.");
            br.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return saleList;
    }

    private Sale parseMessage(String sale)
    {
            String[] saleStringArray = sale.trim().split("\\s+");
            if(isMessageType1(saleStringArray)) {
                return messageType1(saleStringArray);
            } else if(isMessageType2(saleStringArray)) {
                return messageType2(saleStringArray);
            } else {
                throw new RuntimeException("Not a valid message");
            }
    }

    private boolean isMessageType1(String[] saleStringArray) {
        return saleStringArray.length == 3 && saleStringArray[1].contains("at");
    }

    private boolean isMessageType2(String[] saleStringArray) {
        return saleStringArray.length == 7 && saleStringArray[0].matches("^\\d+");
    }

    private Sale messageType1(String[] saleStringArray) {
        String parsedProductType = parseType(saleStringArray[0]);
        return new Sale(parsedProductType, changePriceFormat(saleStringArray,2),1);
    }

    private Sale messageType2(String[] saleStringArray) {
        String parsedProductType = parseType(saleStringArray[3]);
        return new Sale(parsedProductType, changePriceFormat(saleStringArray,5), Integer.valueOf(saleStringArray[0]));
    }

    private double changePriceFormat(String[] saleStringArray, Integer index) {
        String priceString =  saleStringArray[index].substring(0, saleStringArray[index].length() - 1);
        return Double.valueOf(priceString)/ 100;
    }

    public String parseType(String rawType) {
        String parsedType = "";
        String typeWithoutLastChar = rawType.substring(0, rawType.length() - 1);

        if (rawType.endsWith("o")) {
            parsedType = String.format("%soes", typeWithoutLastChar);
        } else if (rawType.endsWith("y")) {
            parsedType = String.format("%sies", typeWithoutLastChar);
        } else if (rawType.endsWith("h")) {
            parsedType = String.format("%shes", typeWithoutLastChar);
        } else if (!rawType.endsWith("s")) {
            parsedType = String.format("%ss", rawType);
        } else {
            parsedType = String.format("%s", rawType);
        }
        return parsedType.toLowerCase();
    }
}