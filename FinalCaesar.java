/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalcaesar;

/**
 *
 * @author lucad
 */
import java.util.Scanner;

public class FinalCaesar {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean done = false;
            while (!done) {
                // Prompt the user to choose "Encrypt" or "Decrypt"
                System.out.print("Would you like to encrypt (E) or decrypt (D)? ");
                String choice = scanner.nextLine().toUpperCase();

                if (choice.equals("E")) {
                    // Choose encryption
                    performEncryption(scanner);
                    done = true;
                } else if (choice.equals("D")) {
                    // Choose decryption
                    performDecryption(scanner);
                    done = true;
                } else {
                    System.out.println("Invalid input. Please enter 'E' for encryption or 'D' for decryption.");
                }
            }
        }
    }

    // Function to perform encryption of a text
    public static void performEncryption(Scanner scanner) {
        while (true) {
            System.out.print("Enter the text to encrypt: ");
            String inputText = scanner.nextLine();

            System.out.print("Enter the shift key (positive integer): ");
            int shiftKey;
            try {
                shiftKey = Integer.parseInt(scanner.nextLine());
                if (shiftKey <= 0) {
                    System.out.println("Error: Shift key must be a positive integer.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Shift key must be a positive integer.");
                continue;
            }

            // Check if the input text contains only alphabetic characters
            if (!isAlpha(inputText)) {
                System.out.println("Error: Input text must contain only alphabetic characters.");
                continue;
            }

            // Perform encryption and display the result
            String encryptedText = encrypt(inputText, shiftKey);
            System.out.println("Encrypted text: " + encryptedText);
            break;
        }
    }

    // Function to perform decryption of a text
    public static void performDecryption(Scanner scanner) {
        while (true) {
            System.out.print("Enter the text to decrypt: ");
            String inputText = scanner.nextLine();

            System.out.print("Enter the shift key (positive integer): ");
            int shiftKey;
            try {
                shiftKey = Integer.parseInt(scanner.nextLine());
                if (shiftKey <= 0) {
                    System.out.println("Error: Shift key must be a positive integer.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Shift key must be a positive integer.");
                continue;
            }

            // Check if the input text contains only alphabetic characters
            if (!isAlpha(inputText)) {
                System.out.println("Error: Input text must contain only alphabetic characters.");
                continue;
            }

            // Perform decryption and display the result
            String decryptedText = decrypt(inputText, shiftKey);
            System.out.println("Decrypted text: " + decryptedText);
            break;
        }
    }

    // Function to check if a string contains only alphabetic characters
    public static boolean isAlpha(String text) {
        return text.chars().allMatch(Character::isLetter);
    }

    // Function to encrypt a text using the Caesar cipher algorithm
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) (((c - base + shift) % 26) + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Function to decrypt a text using the Caesar cipher algorithm
    public static String decrypt(String text, int shift) {
        // To decrypt, we use a negative shift
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) (((c - base - shift + 26) % 26) + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
