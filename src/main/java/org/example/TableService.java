package org.example;
import java.util.Optional;
import java.util.List;
public class TableService {
    private Repository<Table> tables = new Repository<>();
    public Table createTable(String id, int number, boolean avaiable) {
        if (id == null || id.isBlank()) {
            throw new BookingException("id cannot be blank");
        }
        if (number <= 0) {
            throw new BookingException("number cannot be <0");
        }
        if (!avaiable) {
            throw new BookingException("avaiable cannot be false");
        }
        Table table = new Table(id, number, avaiable);
        tables.add(table);
        return table;
    }
    public Optional<Table> findTableById(String id) {
        return tables.findById(id);
    }
    public List<Table> findAllTables() {
        return tables.findAll();
    }
}
