package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;
public class BookingService {
    private static final Logger logger = Logger.getLogger(BookingService.class.getName());
    private Repository<Booking> bookings = new Repository<>();

    public Booking createBooking(String id, Customer customer, Table table, Status status) {
        if (id == null || id.isBlank()) {
            logger.severe("id is null or blank");
            throw new BookingException("id cannot be null or blank");
        }
        if (customer == null) {
            logger.warning("customer is null or blank");
            throw new BookingException("customer cannot be null");
        }
        if (table == null) {
            logger.warning("table is null or blank");
            throw new BookingException("table cannot be null");
        }
        Booking booking = new Booking(id, customer, table, status);
        bookings.add(booking);
        return booking;
    }

    public void confirmBooking(String id) {
        Booking booking = bookings.findById(id)
                .orElseThrow(() -> {
                    logger.severe("booking id is null");
                    return new BookingException("booking id cannot be null");
                });
        if (booking.getStatus() != Status.CREATED) {
            logger.severe("booking status is not CREATED");
            throw new BookingException("booking status is not Created");
        }
        if (booking.getStatus() == Status.CONFIRMED);
            logger.info("Booking status confirmed");
    }
    public void cancelBooking(String id) {
        Booking booking = bookings.findById(id)
                .orElseThrow(() -> {
                    logger.severe("booking id is null");
                    return new BookingException("booking id cannot be null");
                });
        if (booking.getStatus() != Status.CONFIRMED) {
            logger.severe("booking status is not CONFIRMED");
            throw new BookingException("booking status is not CONFIRMED");
        }
        if (booking.getStatus() == Status.CANCELLED) {
            logger.info("booking status is CANCELLED");
        }
    }
    public List<Booking> findAllBookings() {
        return bookings.findAll();
    }
    public Optional<Booking> findBookingById(String id) {
        return bookings.findById(id);
    }
    public List<Booking> findAllConfimBooking(){
        return bookings.findAll().stream()
                .filter(b -> b.getStatus() == Status.CONFIRMED)
                .toList();
    }
}
