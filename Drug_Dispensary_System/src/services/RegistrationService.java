package services;

import data.models.*;
import data.repositories.*;
import dtos.request.RegistrationRequest;
import dtos.response.RegistrationResponse;

public class RegistrationService {
    private final UserRepository userRepo;
    private final DoctorRepository doctorRepo;
    private final PharmacistRepository pharmacistRepo;

    public RegistrationService(UserRepository userRepo, DoctorRepository doctorRepo, PharmacistRepository pharmacistRepo) {
        this.userRepo = userRepo;
        this.doctorRepo = doctorRepo;
        this.pharmacistRepo = pharmacistRepo;
    }

    public RegistrationResponse register(RegistrationRequest request) {
        if ("DOCTOR".equals(request.getRole())) {
            Doctor doctor = new Doctor(
                request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(),
                request.getSpecialization(), request.getDoctorId()
            );
            userRepo.save(doctor);
            doctorRepo.save(doctor);
            return new RegistrationResponse("Doctor registered successfully.");
        } else if ("PHARMACIST".equals(request.getRole())) {
            Pharmacist pharmacist = new Pharmacist(
                request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(),
                request.getPharmacyName(), request.getPharmacistId()
            );
            userRepo.save(pharmacist);
            pharmacistRepo.save(pharmacist);
            return new RegistrationResponse("Pharmacist registered successfully.");
        }
        return new RegistrationResponse("Invalid role.");
    }
}
