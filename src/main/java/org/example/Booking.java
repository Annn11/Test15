package org.example;

public class Booking implements Identifiable {
    private String id;
    Customer customer;
    Table table;
    Status status;
    public Booking(String id, Customer customer, Table table, Status status) {
        this.id = id;
        this.customer = customer;
        this.table = table;
        this.status = status.CREATED;
    }
    public String getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Table getTable() {
        return table;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
