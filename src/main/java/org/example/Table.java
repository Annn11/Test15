package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Table implements Identifiable {
    private String id;
    private int number;
    private boolean avaible;

    public Table(String id, int number, boolean avaible) {
        this.id = id;
        this.number = number;
        this.avaible = avaible;
    }
    public String getId() {
        return id;
    }
    public int getNumber() {
        return number;
    }
    public boolean isAvaible() {
        return avaible;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return getId().equals(table.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
