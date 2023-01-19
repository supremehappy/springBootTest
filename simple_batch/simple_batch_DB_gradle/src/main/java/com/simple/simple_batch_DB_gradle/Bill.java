package com.simple.simple_batch_DB_gradle;

public class Bill {

    private String aptcd;
    private String dongho;
    private String billym;
    private String saledt;
    private String amount;

    public Bill(){}

    public Bill(String aptcd, String dongho, String billym, String saledt, String amount){
        this.aptcd = aptcd;
        this.dongho = dongho;
        this.billym = billym;
        this.saledt = saledt;
        this.amount = amount;
    }

    public String getAptcd() {
        return aptcd;
    }

    public void setAptcd(String aptcd) {
        this.aptcd = aptcd;
    }

    public String getDongho() {
        return dongho;
    }

    public void setDongho(String dongho) {
        this.dongho = dongho;
    }

    public String getBillym() {
        return billym;
    }

    public void setBillym(String billym) {
        this.billym = billym;
    }

    public String getSaledt() {
        return saledt;
    }

    public void setSaledt(String saledt) {
        this.saledt = saledt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "aptcd='" + aptcd + '\'' +
                ", dongho='" + dongho + '\'' +
                ", billym='" + billym + '\'' +
                ", saledt='" + saledt + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}