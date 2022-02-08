package com.example.payphone.models;

public class SaleStatus {
    private String email,cardType,lastDigits,cardBrand,clientTransactionId,phoneNumber,
            transactionStatus,document,storeName,date;
    private int amount;

    public SaleStatus() {
    }

    public SaleStatus(String email, String cardType, String lastDigits, String cardBrand,
                      String clientTransactionId, String phoneNumber, String transactionStatus,
                      String document, String storeName, String date, int amount) {
        this.email = email;
        this.cardType = cardType;
        this.lastDigits = lastDigits;
        this.cardBrand = cardBrand;
        this.clientTransactionId = clientTransactionId;
        this.phoneNumber = phoneNumber;
        this.transactionStatus = transactionStatus;
        this.document = document;
        this.storeName = storeName;
        this.date = date;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getLastDigits() {
        return lastDigits;
    }

    public void setLastDigits(String lastDigits) {
        this.lastDigits = lastDigits;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
