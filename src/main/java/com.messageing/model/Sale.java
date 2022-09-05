package com.messageing.model;

public class Sale
{
    private String productType;
    private Double productPrice;
    private Integer productQuantity;

    public Sale(String productType, Double productPrice, Integer productQuantity) {
        this.productType = productType;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "productType='" + productType + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
