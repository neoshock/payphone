package com.example.payphone.models;

public class Payment {

    private String phoneNumber, countryCode, clientUserId, reference ,responseUrl ,clientTransactionId;
    private int amount, amountWithTax, amountWithoutTax, tax;

    public Payment(String phoneNumber, String countryCode, String clientUserId, String reference,
                   String responseUrl, String clientTransactionId, int amount, int amountWithTax,
                   int amountWithoutTax, int tax) {
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.clientUserId = clientUserId;
        this.reference = reference;
        this.responseUrl = responseUrl;
        this.clientTransactionId = clientTransactionId;
        this.amount = amount;
        this.amountWithTax = amountWithTax;
        this.amountWithoutTax = amountWithoutTax;
        this.tax = tax;
    }

    public Payment() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(String clientUserId) {
        this.clientUserId = clientUserId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(int amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    public int getAmountWithoutTax() {
        return amountWithoutTax;
    }

    public void setAmountWithoutTax(int amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
}
