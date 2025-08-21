package controllers;

import data.models.User;
import data.repositories.UserRepository;
import dtos.response.LoginResponse;
import services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationControllerTest {
    private RegistrationController registrationController;
    private UserRepository userRepo;

    @BeforeEach
    void setup() {
        userRepo = new UserRepository();
        Service authService = new Service(userRepo);
        registrationController = new RegistrationController(authService);

        userRepo.save(new User("Test", "User", "user@example.com", "password", "DOCTOR"));
    }

    @Test
    void testLoginSuccess() {
        LoginResponse response = registrationController.login("user@example.com", "password");
        assertTrue(response.isSuccess());
        assertEquals("Login successful.", response.getMessage());
    }

    @Test
    void testLoginFailsWithWrongPassword() {
        LoginResponse response = registrationController.login("user@example.com", "wrongpass");
        assertFalse(response.isSuccess());
        assertEquals("Invalid password!", response.getMessage());
    }

    @Test
    void testLoginFailsWithUnknownEmail() {
        LoginResponse response = registrationController.login("notfound@example.com", "password");
        assertFalse(response.isSuccess());
    }
}
