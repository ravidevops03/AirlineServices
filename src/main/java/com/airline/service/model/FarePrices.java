
package com.airline.service.model;

import java.util.HashMap;
import java.util.Map;

public class FarePrices {

    private First first;
    private Business business;
    private Economy economy;

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Economy getEconomy() {
        return economy;
    }

    public void setEconomy(Economy economy) {
        this.economy = economy;
    }
}
