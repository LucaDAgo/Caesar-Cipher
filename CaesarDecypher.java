/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caesardecypher;

import java.util.Scanner;

/**
 *
 * @author lucad
 */
public class CaesarDecypher {

     // ALPHABET string denotes alphabet from a-z   
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
      
    // create encryptData() method for encrypting user input string with given shift key   
    public static String decryptData(String inputStr, int shiftKey)   
    {   
        // convert inputStr into lower case   
        inputStr = inputStr.toLowerCase();   
          
        // encryptStr to store decrypted data   
        String decryptStr = "";   
          
        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++)   
        {   
             // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));  
              
            // get decrypted char for each char of inputStr (Fehler war shiftKey - pos)   
            int decryptPos = (pos - shiftKey) % 26;   
            
            // if decryptPos is negative   
            if (decryptPos < 0){   
                decryptPos = ALPHABET.length() + decryptPos;   
            }   
            char decryptChar = ALPHABET.charAt(decryptPos);   
              
              
            // add decrypted char to decrypted string   
            decryptStr += decryptChar;   
        }   
          
        // return decrypted string   
        return decryptStr;   
    }   
      
    
    // main() method start   
    public static void main(String[] args)   
    {   
        // take input from the user
        try ( // create an instance of Scanner class
                Scanner sc = new Scanner(System.in)) {
            // take input from the user
            System.out.println("Enter a string for decryption using Caesar Cipher: ");
            String inputStr = sc.nextLine();
            System.out.println("Enter the value by which each character in the plaintext message gets shifted: ");
            int shiftKey = Integer.parseInt(sc.nextLine()); 
            System.out.println("Decrypted Data ===> "+decryptData(inputStr, shiftKey));
               
            // close Scanner class object
        }   
    }   
}   
