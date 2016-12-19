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
    
    public ClassicCryptography() {
        alphabet = initAlphabet(alphabet);
    }
    
    private char[] initAlphabet(char[] alpha) {
        char a = 'a';
        int temp = 26 + (int) a;
        alpha = new char[26];
        int next = 0;
        
        while(a < temp) {
            alpha[next++] = (char) a;
            a++;
        }
        return alpha;
    }
    
    public String encrypt(String plaintext, int key) {
        //char[] alpha = initAlphabet();
        
        char[] plain = plaintext.toCharArray();
        String kryptert = "";
        
        for(int i = 0; i < plain.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(plain[i] == alphabet[j]) {
                    if(j + key >= alphabet.length) {
                        kryptert += alphabet[j + key - alphabet.length];
                    } else {
                        kryptert += alphabet[j + key]; 
                    }
                }
            }
        }
        return kryptert;
    }
    
    public String decrypt(String chifertext, int key) {
        return null;
    }
}
