
package com.airline.service.model;

import java.util.HashMap;
import java.util.Map;

public class BookingFee {

    private String currency;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
