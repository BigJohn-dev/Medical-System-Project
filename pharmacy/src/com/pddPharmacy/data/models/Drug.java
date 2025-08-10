package com.pddPharmacy.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Drug {
    private int id;
    private String name;
    private Type type;
    private Category category;
    private LocalDate expiry;
    private LocalDate manufactureOn;
    private LocalDateTime dateAdded;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public LocalDate getExpiry() {
        return expiry;
    }
    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }
    public LocalDate getManufactureOn() {
        return manufactureOn;
    }
    public void setManufactureOn(LocalDate manufactureOn) {
        this.manufactureOn = manufactureOn;
    }
    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}