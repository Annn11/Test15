package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
public class Main {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        TableService tableService = new TableService();
        Customer customer = new Customer("c1", "Anna", "+380675894673");
        Table table = new Table("t1",25,true);
        Booking booking = bookingService.createBooking("b1", customer, table, Status.CREATED);
        bookingService.confirmBooking("b1");
        bookingService.findAllConfimBooking();
        List<Booking> bookings = new ArrayList<>();
        System.out.println();
    }
}