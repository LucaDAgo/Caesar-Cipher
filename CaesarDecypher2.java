/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caesardecypher2;

import java.util.Scanner;

/**
 *
 * @author lucad
 */
public class CaesarDecypher2 {

    public static void main(String[] args) {
       
        try (Scanner scanner = new Scanner(System.in)) {
            String encryptedText;
            int shiftKey;
            while (true) {
                // Prompt the user to enter the encrypted text
                System.out.print("Enter the encrypted text: ");
                encryptedText = scanner.nextLine();
                
                // Prompt the user to enter the shift key (integer)
                System.out.print("Enter the shift key (integer): ");
                String shiftInput = scanner.nextLine();
                
                try {
                    // Parse the shift key as an integer
                    shiftKey = Integer.parseInt(shiftInput);
                    
                    // Decrypt the encrypted text using the Caesar cipher
                    String decryptedText = decrypt(encryptedText, shiftKey);
                    System.out.println("Decrypted text: " + decryptedText);
                    break;
                } catch (NumberFormatException e) {
                    // Display an error message if the shift key is not an integer
                    System.out.println("Error: Shift key must be an integer.");
                }
            }
            // Close the scanner
        }
    }

    // Function to decrypt a Caesar cipher
    public static String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the input text
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';

                // Apply the reverse Caesar cipher shift to the character
                int shiftedChar = ((c - base - shift) % 26);
                if (shiftedChar < 0) {
                    shiftedChar += 26; // Ensure it wraps around correctly
                }
                result.append((char) (shiftedChar + base));
            } else {
                // Preserve non-alphabetic characters
                result.append(c);
            }
        }

        // Return the decrypted text
        return result.toString();
    }
}
