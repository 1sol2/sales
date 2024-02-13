package com.ohgiraffers.management.customer.model.dto;

public class CustomerDTO {
    private int customerCode;
    private String customerName;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerCode, String customerName) {
        this.customerCode = customerCode;
        this.customerName = customerName;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerCode=" + customerCode +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
