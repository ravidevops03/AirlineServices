
package com.airline.service.model;

import java.util.HashMap;
import java.util.Map;

public class Business {

    private Ticket_ ticket;
    private BookingFee_ bookingFee;
    private Tax_ tax;

    public Ticket_ getTicket() {
        return ticket;
    }

    public void setTicket(Ticket_ ticket) {
        this.ticket = ticket;
    }

    public BookingFee_ getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(BookingFee_ bookingFee) {
        this.bookingFee = bookingFee;
    }

    public Tax_ getTax() {
        return tax;
    }

    public void setTax(Tax_ tax) {
        this.tax = tax;
    }
}
