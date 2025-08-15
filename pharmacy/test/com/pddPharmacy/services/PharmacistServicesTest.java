package com.pddPharmacy.services;

import com.pddPharmacy.data.repositories.Drugs;
import com.pddPharmacy.dtos.request.AddDrugRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.pddPharmacy.data.models.Type.ANALGESIC;
import static org.junit.jupiter.api.Assertions.*;

class PharmacistServicesTest {
    private PharmacistServices pharmacistServices;
    private Drugs drugs;

    @BeforeEach
    public void setUp() {
        drugs = new Drugs();
        pharmacistServices = new PharmacistServices(drugs);
    }
    @Test
    public void addDrug_drugCountIsOneTest() {
        AddDrugRequest addDrugRequest= new AddDrugRequest();
        addDrugRequest.setName("Panadol");
        addDrugRequest.setCategory(ANALGESIC);
        addDrugRequest.setQuantity(5);
        addDrugRequest.setType("Capsule");
        addDrugRequest.setManufacturedOn(LocalDate.now());
        addDrugRequest.setExpiry(addDrugRequest.getManufacturedOn().plusMonths(5));
        pharmacistServices.addDrug(addDrugRequest);
        assertEquals(1L,drugs.count());

    }


}