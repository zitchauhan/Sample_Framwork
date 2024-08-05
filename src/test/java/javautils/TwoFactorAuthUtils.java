package javautils;


import org.jboss.aerogear.security.otp.Totp;

public class TwoFactorAuthUtils {

    // Method to generate a TOTP code using a shared secret
    public static String generateTOTP(String secret) {
        Totp totp = new Totp(secret);
        return totp.now(); // Returns the current TOTP code
    }

    // Method to verify a TOTP code
    public static boolean verifyTOTP(String secret, String code) {
        Totp totp = new Totp(secret);
        return totp.verify(code);
    }

    // Example usage with Google Authenticator
    public static void main(String[] args) {
        String secret = "JBSWY3DPEHPK3PXP"; // Example secret key (Base32 encoded)

        // Generate a TOTP code
        String generatedCode = generateTOTP(secret);
        System.out.println("Generated TOTP code: " + generatedCode);

        // Verify the generated code (for demonstration purposes, we use the same code)
        boolean isValid = verifyTOTP(secret, generatedCode);
        System.out.println("Is the code valid? " + isValid);
    }
}
