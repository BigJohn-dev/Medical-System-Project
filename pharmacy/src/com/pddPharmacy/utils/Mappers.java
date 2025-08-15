package com.pddPharmacy.utils;

import com.pddPharmacy.data.models.Drug;
import com.pddPharmacy.dtos.request.AddDrugRequest;

public class Mappers {
    public static Drug map(AddDrugRequest addDrugRequest) {
        Drug drug = new Drug();
        drug.setName(addDrugRequest.getName());
        drug.setCategory(addDrugRequest.getCategory());
        drug.setExpiry(addDrugRequest.getExpiry());
        drug.setManufactureOn(addDrugRequest.getManufacturedOn());
        drug.setQuantity(addDrugRequest.getQuantity());
        return drug;
    }
}
