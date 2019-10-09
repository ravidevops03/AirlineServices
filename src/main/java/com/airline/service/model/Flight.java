
package com.airline.service.model;

import java.util.HashMap;
import java.util.Map;

public class Flight {

    private String operator;
    private String flightNumber;
    private String departsFrom;
    private String arrivesAt;
    private DepartsOn departsOn;
    private ArrivesOn arrivesOn;
    private String flightTime;
    private FarePrices farePrices;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartsFrom() {
        return departsFrom;
    }

    public void setDepartsFrom(String departsFrom) {
        this.departsFrom = departsFrom;
    }

    public String getArrivesAt() {
        return arrivesAt;
    }

    public void setArrivesAt(String arrivesAt) {
        this.arrivesAt = arrivesAt;
    }

    public DepartsOn getDepartsOn() {
        return departsOn;
    }

    public void setDepartsOn(DepartsOn departsOn) {
        this.departsOn = departsOn;
    }

    public ArrivesOn getArrivesOn() {
        return arrivesOn;
    }

    public void setArrivesOn(ArrivesOn arrivesOn) {
        this.arrivesOn = arrivesOn;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public FarePrices getFarePrices() {
        return farePrices;
    }

    public void setFarePrices(FarePrices farePrices) {
        this.farePrices = farePrices;
    }
}
