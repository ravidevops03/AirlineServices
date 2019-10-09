
package com.airline.service.model;

import java.util.HashMap;
import java.util.Map;

public class First {

    private Ticket ticket;
    private BookingFee bookingFee;
    private Tax tax;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BookingFee getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(BookingFee bookingFee) {
        this.bookingFee = bookingFee;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }  
}
