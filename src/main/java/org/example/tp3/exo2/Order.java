package org.example.tp3.exo2;

public class Order {
    private long id;
    private String description;

    public Order(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
