package com.pddPharmacy.services;

import com.pddPharmacy.data.repositories.Drugs;
import com.pddPharmacy.dtos.request.AddDrugRequest;
import com.pddPharmacy.dtos.response.AddDrugResponse;

import java.time.LocalDate;

public class PharmacistServices {
    private Drugs drugs;

    public void addDrug(String name, String type, String category, LocalDate expiry) {
    }

    public AddDrugResponse addDrug(AddDrugRequest addDrugRequest){
        return null;
    }
}
