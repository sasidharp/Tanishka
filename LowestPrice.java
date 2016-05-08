package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 7/5/16.
 */
public class LowestPrice {
    private String Amount;
    private String CurrencyCode;
    private String FormattedPrice;

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    public String getFormattedPrice() {
        return FormattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        FormattedPrice = formattedPrice;
    }
}
