/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caesarcipher;

/**
 *
 * @author lucad
 */
// import required classes and package, if any    
import java.util.Scanner;   
   
// create class CaesarCipherExample for encryption and decryption    
public class CaesarCipher  
{   
    // ALPHABET string denotes alphabet from a-z   
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
      
    // create encryptData() method for encrypting user input string with given shift key   
    public static String encryptData(String inputStr, int shiftKey)   
    {   
        // convert inputStr into lower case   
        inputStr = inputStr.toLowerCase();   
          
        // encryptStr to store encrypted data   
        String encryptStr = "";   
          
        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++)   
        {   
            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));   
              
            // get encrypted char for each char of inputStr   
            int encryptPos = (shiftKey + pos) % 26;   
            char encryptChar = ALPHABET.charAt(encryptPos);   
              
            // add encrypted char to encrypted string   
            encryptStr += encryptChar;   
        }   
          
        // return encrypted string   
        return encryptStr;   
    }   
      
    
      
    // main() method start   
    public static void main(String[] args)   
    {   
        // take input from the user
        try ( // create an instance of Scanner class
                Scanner sc = new Scanner(System.in)) {
            // take input from the user
            System.out.println("Enter a string for encryption using Caesar Cipher: ");
            String inputStr = sc.nextLine();
            System.out.println("Enter the value by which each character in the plaintext message gets shifted: ");
            int shiftKey = Integer.parseInt(sc.nextLine());
            System.out.println("Encrypted Data ===> "+encryptData(inputStr, shiftKey));
             
            // close Scanner class object
        }   
    }   
}   