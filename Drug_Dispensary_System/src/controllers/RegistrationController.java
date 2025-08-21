package controllers;

import dtos.response.LoginResponse;
import services.Service;

public class RegistrationController {
    private final Service service;

    public RegistrationController(Service service) {
        this.service = service;
    }

    public LoginResponse login(String email, String password) {
        return service.login(email, password);
    }
}
