
package com.airline.service.model;

import java.util.HashMap;
import java.util.Map;

public class Economy {

    private Ticket__ ticket;
    private BookingFee__ bookingFee;
    private Tax__ tax;

    public Ticket__ getTicket() {
        return ticket;
    }

    public void setTicket(Ticket__ ticket) {
        this.ticket = ticket;
    }

    public BookingFee__ getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(BookingFee__ bookingFee) {
        this.bookingFee = bookingFee;
    }

    public Tax__ getTax() {
        return tax;
    }

    public void setTax(Tax__ tax) {
        this.tax = tax;
    }
}
