/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author stianreistadrogeberg
 */
public class ClassicCryptography {
    private char[] alphabet;
    private int length;
    
    public ClassicCryptography() {
        alphabet = initAlphabet(alphabet);
        length = 26;
    }
    
    /**
     * This is a method that initialize the alphabet to be used in the encryption
     * and decryption.
     * @param alpha
     * @return 
     */
    private char[] initAlphabet(char[] alpha) {
        char a = 'a';
        int temp = 26 + (int) a;
        alpha = new char[26];
        int next = 0;
        
        while(a < temp) {
            alpha[next++] = (char) a++;
        }
        return alpha;
    }
    
    /**
     * This method takes a plaintext to be encrypted as input and the encryption key.
     * @param plaintext
     * @param encryptionKey
     * @return 
     */
    public String encrypt(String plaintext, int encryptionKey) {
        char[] plain = plaintext.toCharArray();
        String ciphertext = "";
        
        for(int i = 0; i < plain.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(plain[i] == alphabet[j]) {
                    if(j + encryptionKey >= alphabet.length) {
                        ciphertext += alphabet[j + encryptionKey - alphabet.length];
                    } else {
                        ciphertext += alphabet[j + encryptionKey]; 
                    }
                }
            }
        }
        return ciphertext.toUpperCase();
    }
    
    /**
     * This method takes a encrypted text and an encryption key as input
     * and return the decrypted plaintext.
     * @param ciphertext
     * @param key
     * @return 
     */
    public String decrypt(String ciphertext, int key) {
        char[] cipher = ciphertext.toCharArray();
        String plaintext = "";
        
        for(int i = 0; i < cipher.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(cipher[i] == alphabet[j]) {
                    if(j - key < 0) {
                        plaintext += alphabet[j - key + alphabet.length];
                    } else {
                        plaintext += alphabet[j - key];
                    }
                }
            }
        }
        return plaintext.toUpperCase();
    }
}
