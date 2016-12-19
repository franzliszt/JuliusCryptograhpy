/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.Scanner;

/**
 *
 * @author stianreistadrogeberg
 */
public class Cryptography {
    
//    @Override
//    public void start(Stage stage) throws Exception {
//        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("CryptoView.fxml"));
//        
//    }
    public static void main(String[] args) {
//        launch(args);
        
        Cryptography crypto = new Cryptography();
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your text to encrypt (no spaces): ");
        String text = input.nextLine().toLowerCase();
        System.out.print("\nEnter your secret key: ");
        int encryptionKey = Integer.parseInt(input.nextLine());
        
        int key = 2;
        String plaintext = "xyz";
        String output = "Your plaintext is: " + text + 
                " and the chiffretext is: ";
        System.out.println(krypter(text, encryptionKey));
    }
    
    private static char[] initAlphabet() {
        char a = 'a';
        int temp = 26 + (int) a;
        char[] alpha = new char[26];
        int next = 0;
        while(a < temp) {
            alpha[next++] = (char) a;
            a++;
        }
        return alpha;
    }
    
    private static String krypter(String plaintext, int key) {
        char[] alpha = initAlphabet();
        
        char[] plain = plaintext.toCharArray();
        String kryptert = "";
        
        for(int i = 0; i < plain.length; i++) {
            for(int j = 0; j < alpha.length; j++) {
                if(plain[i] == alpha[j]) {
                    if(j + key >= alpha.length) {
                        kryptert += alpha[j + key - alpha.length];
                    } else {
                        kryptert += alpha[j + key]; 
                    }
                }
            }
        }
        return kryptert;
    }  
}
