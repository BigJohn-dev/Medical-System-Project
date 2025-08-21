package utils;

import java.util.UUID;

public class PasswordEncoder {
    public static String shortCode() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
    }

}
