/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caesarcipher2;

import java.util.Scanner;

/**
 *
 * @author lucad
 */
public class CaesarCipher2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputText;
            int shiftKey;
            while (true) {
                // Prompt the user to enter a string to encrypt
                System.out.print("Enter a string to encrypt: ");
                inputText = scanner.nextLine();
                
                // Prompt the user to enter a shift key (integer)
                System.out.print("Enter a shift key (integer): ");
                String shiftInput = scanner.nextLine();
                
                try {
                    // Parse the shift key as an integer
                    shiftKey = Integer.parseInt(shiftInput);
                    
                    // Check if the input text contains only alphabetic characters
                    if (isAlpha(inputText)) {
                        // Encrypt the input text using the Caesar cipher
                        String encryptedText = encrypt(inputText, shiftKey);
                        System.out.println("Encrypted text: " + encryptedText);
                        break;
                    } else {
                        // Display an error message if the input text is not alphabetic
                        System.out.println("Error: Input text must contain only alphabetic characters.");
                    }
                } catch (NumberFormatException e) {
                    // Display an error message if the shift key is not an integer
                    System.out.println("Error: Shift key must be an integer.");
                }
            }
            // Close the scanner
        }
    }

    // Function to check if a string contains only alphabetic characters
    public static boolean isAlpha(String text) {
        return text.chars().allMatch(Character::isLetter);
    }

    // Function to encrypt a string using the Caesar cipher
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the input text
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';

                // Apply the Caesar cipher shift to the character
                result.append((char) (((c - base + shift) % 26) + base));
            } else {
                // Preserve non-alphabetic characters
                result.append(c);
            }
        }

        // Return the encrypted text
        return result.toString();
    }
}
