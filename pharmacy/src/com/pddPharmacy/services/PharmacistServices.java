package com.pddPharmacy.services;

import com.pddPharmacy.data.models.Drug;
import com.pddPharmacy.data.repositories.Drugs;
import com.pddPharmacy.dtos.request.AddDrugRequest;
import com.pddPharmacy.dtos.response.AddDrugResponse;

import java.time.LocalDate;

import static com.pddPharmacy.utils.Mappers.map;

public class PharmacistServices {
    private Drugs drugs = new Drugs();

    PharmacistServices(Drugs drugs) {
        this.drugs = drugs;
    }

    public AddDrugResponse addDrug(AddDrugRequest addDrugRequest) {
        Drug drug = map(addDrugRequest);
        Drug savedDrug = drugs.save(drug);
        return null;
    }
}
