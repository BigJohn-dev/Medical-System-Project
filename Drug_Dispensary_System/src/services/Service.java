package services;

import data.models.User;
import data.repositories.UserRepository;
import dtos.response.LoginResponse;

public class Service {
    private final UserRepository userRepo;

    public Service(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public LoginResponse login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) return new LoginResponse(false, "Invalid email!", null);
        if (!user.getPassword().equals(password)) return new LoginResponse(false, "Invalid password!", null);
        return new LoginResponse(true, "Login successful.", user.getRole());
    }
}
