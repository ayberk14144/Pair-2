package org.example;

public class CorporateCustomer extends Customer{
    private String xcompanyName;
    private String taxNumber;

    public String getXcompanyName() {
        return xcompanyName;
    }

    public void setXcompanyName(String xcompanyName) {
        this.xcompanyName = xcompanyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
