
import controllers.DoctorController;
import controllers.PharmacistController;
import controllers.RegistrationController;
import data.repositories.DoctorRepository;
import data.repositories.PharmacistRepository;
import data.repositories.PrescriptionRepository;
import data.repositories.UserRepository;
import dtos.request.RegistrationRequest;
import dtos.response.LoginResponse;
import services.PrescriptionService;
import services.RegistrationService;
import services.Service;

import java.util.Scanner;

public class Main {
    private static void Register(Scanner input, RegistrationService service) {
        try {
            System.out.print("Role (DOCTOR/PHARMACIST): ");
            String role = input.nextLine().trim().toUpperCase();

            RegistrationRequest request = new RegistrationRequest();
            request.setRole(role);

            System.out.print("Enter first name: "); request.setFirstName(input.nextLine().trim());
            System.out.print("Enter last name: "); request.setLastName(input.nextLine().trim());
            System.out.print("Password: "); request.setPassword(input.nextLine().trim());
            System.out.print("Email: ");    request.setEmail(input.nextLine().trim());

            if ("DOCTOR".equals(role)) {
                System.out.print("Enter Specialization: "); request.setSpecialization(input.nextLine().trim());
                System.out.print("Enter Doctor Id : "); request.setDoctorId(input.nextLine().trim());
            } else if ("PHARMACIST".equals(role)) {
                System.out.print("Enter Pharmacy Name: "); request.setPharmacyName(input.nextLine().trim());
                System.out.print("Enter Pharmacist Id: "); request.setPharmacistId(input.nextLine().trim());
            } else {
                System.out.println("Unknown role."); return;
            }

            var response = service.register(request);
            System.out.println(response.getMessage());
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

     private static void doctorMenu(Scanner input, DoctorController controller, String prescriptions) {
        while (true) {
            System.out.println("\n[Doctor Menu]");
            System.out.println("1) Create Prescription \n2) View My Prescriptions \n0) Logout");
            System.out.print("Enter option number: ");
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    System.out.println("\nCreating Prescription");
                    System.out.print("Enter Patient's name: "); String patient = input.nextLine();
                    System.out.print("Enter Diagnosis: "); String diagnosis = input.nextLine();
                    System.out.print("Enter Drugs to be administered: "); String drugs = input.nextLine();
                    String code = controller.createPrescription(prescriptions, patient, diagnosis, drugs);
                    System.out.println("Prescription created. Code: " + code);
                }
                case "2" -> controller.printHistory(prescriptions);
                case "0" -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

        private static void pharmacistMenu(Scanner input, PharmacistController controller) {
        while (true) {
            System.out.println(controller);
            System.out.println("\n[Pharmacist Menu]");
            System.out.println("1) Verify Prescription \n2) Dispense Prescription \n3) View Dispensed History \n0) Logout");
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter prescription code: ");
                    String code = input.nextLine().trim();
                    controller.verify(code);
                }
                case "2" -> {
                    System.out.print("Enter code to dispense: ");
                    String code = input.nextLine().trim();
                    controller.dispense(code);
                }
                case "3" -> controller.printDispensedHistory();
                case "0" -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void seed(RegistrationService registrationService) {
        RegistrationRequest demo = new RegistrationRequest();
        demo.setRole("DOCTOR");
        demo.setFirstName("Gifted");
        demo.setLastName("Okafor");
        demo.setPassword("pass");
        demo.setEmail("drokafor@example.com");
        demo.setSpecialization("Cardiology");
        demo.setDoctorId("DOC123");
        registrationService.register(demo);

        RegistrationRequest pharmacist = new RegistrationRequest();
        pharmacist.setRole("PHARMACIST");
        pharmacist.setFirstName("Pharma");
        pharmacist.setLastName("Jane");
        pharmacist.setPassword("password");
        pharmacist.setEmail("jane@pharmacy.com");
        pharmacist.setPharmacyName("City Pharmacy");
        pharmacist.setPharmacistId("PHARM987");
        registrationService.register(pharmacist);
    }
     public static void main(String[] args) {

        var userRepo = new UserRepository();
        var doctorRepo = new DoctorRepository();
        var pharmacistRepo = new PharmacistRepository();
        var prescriptionRepo = new PrescriptionRepository();

        var registrationService = new RegistrationService(userRepo, doctorRepo, pharmacistRepo);
        var authService = new Service(userRepo);
        var prescriptionService = new PrescriptionService(prescriptionRepo);

        var authController = new RegistrationController(authService);
        var doctorController = new DoctorController(prescriptionService);
        var pharmacistController = new PharmacistController(prescriptionService);

        Scanner input = new Scanner(System.in);
        System.out.println("=== Drug Dispensary System ===");
         System.out.println("\nWelcome...");

        seed(registrationService);

        while (true) {
            System.out.println("\n1) Register  \n2) Login  \n0) Exit");
            System.out.print("Choose: ");
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1" -> Register(input, registrationService);
                case "2" -> {
                    System.out.print("Enter email: ");
                    String email = input.nextLine();
                    System.out.print("Enter Password: ");
                    String password = input.nextLine();
                    LoginResponse response = authController.login(email, password);
                    System.out.println(response.getMessage());
                    if (response.isSuccess()) {
                        if ("DOCTOR".equals(response.getRole())) doctorMenu(input, doctorController, email);
                        else if ("PHARMACIST".equals(response.getRole())) pharmacistMenu(input, pharmacistController);
                    }

                }
                case "0" -> { System.out.println("Signed out"); return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
