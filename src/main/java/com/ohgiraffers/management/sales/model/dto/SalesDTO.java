package com.ohgiraffers.management.sales.model.dto;

import java.util.Date;

public class SalesDTO {
    private int productCode;
    private int customerCode;
    private Date salesDate;
    private int salesNumber;

    public SalesDTO() {
    }

    public SalesDTO(int productCode, int customerCode, Date salesDate, int salesNumber) {
        this.productCode = productCode;
        this.customerCode = customerCode;
        this.salesDate = salesDate;
        this.salesNumber = salesNumber;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    @Override
    public String toString() {
        return "SalesDTO{" +
                "productCode=" + productCode +
                ", customerCode=" + customerCode +
                ", salesDate=" + salesDate +
                ", salesNumber=" + salesNumber +
                '}';
    }
}
