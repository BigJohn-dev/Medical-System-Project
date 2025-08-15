package com.pddPharmacy.data.repositories;

import com.pddPharmacy.data.models.Drug;
import com.pddPharmacy.exceptions.IdDoesNotExist;

import java.util.ArrayList;
import java.util.List;


public class Drugs {
    private final List<Drug> drugs = new ArrayList<>();

    public long count() {
        return drugs.size();
    }

    public Drug savedNew(Drug drug) {
        drug.setId(generateId());
        drugs.add(drug);
        return drug;
    }

    private int generateId() {
        return drugs.size() + 1;
    }

    public Drug save(Drug drug) {
        if (isNew(drug)) {
            savedNew(drug);
        } else {
            update(drug);
        }
        return drug;
    }

    private boolean isNew(Drug drug) {
        if (drug.getId() == 0) {
            return true;
        }
        return false;
    }

    private  void update(Drug drug) {
        deleteById(drug.getId());
        drugs.add(drug);
    }

    public void deleteById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                drugs.remove(drug);
            }
        }
        throw new IdDoesNotExist(id + " does not exist");
    }

    public Drug findById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                return drug;
            }
        }
        throw new IdDoesNotExist("Drug with id " + id + " does not exist");
    }

    public void delete(Drug drug){
        deleteById(drug.getId());
    }

    public Drug findByName(String name){
        for(var drug : drugs) if(drug.getName().equalsIgnoreCase(name)) return drug;
        return null;
    }

}
