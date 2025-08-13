package com.pddPharmacy.dtos.request;

import java.time.LocalDate;

public class AddDrugRequest {
    private String name;
    private String type;
    private String category;
    private LocalDate expiry;
    private int quality;
    private LocalDate manufacturedOn;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public LocalDate getManufacturedOn() {
        return manufacturedOn;
    }

    public void setManufacturedOn(LocalDate manufacturedOn) {
        this.manufacturedOn = manufacturedOn;
    }
}
