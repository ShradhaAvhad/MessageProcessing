package com.messageing.reader;

import com.messageing.model.Sale;

import java.util.List;

public interface MessageFileReader
{
    List<Sale> readSalesMessages();
}
