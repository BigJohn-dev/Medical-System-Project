package data.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public User(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    void validateEmail(String email) {
        if (email == null || email.isEmpty()) throw new InvalidUserInputException("Email is empty!");
        if(!email.contains("@") || !email.endsWith("gmail.com")) throw new InvalidUserInputException("Email address is invalid!");
    }
    void validateFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) throw new InvalidUserInputException("First name is empty!");
    }
    void validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) throw new InvalidUserInputException("Last name is empty!");
    }
    void validatePassword(String password) {
        if (password == null || password.isEmpty()) throw new InvalidUserInputException("Password is empty!");
        if (password.length() < 8) throw new InvalidUserInputException("Weak password! \nPassword should be at least 8 characters!");
    }
}
