/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author stianreistadrogeberg
 */
public class CryptoController {
    private final ClassicCryptography c;
    private boolean encMode;
    
    @FXML public TextField inputString;
    @FXML public TextField encryptionKey;
    @FXML public Button encrypt;
    @FXML public Button mode;
    @FXML public Label outputResult;
    
    
    public CryptoController() {
        encMode = true;
        c = new ClassicCryptography();
    }
    
    @FXML
    public void encryptionMode() {
        String userInput = inputString.getText().toLowerCase();
        boolean ok = checkInput(userInput);
        
        if(encMode && ok) {
            String cipherText = c.encrypt(userInput, getKey());
            outputResult.setText(cipherText);
        } 
        
        if(!encMode && ok){
            String plaintext = c.decrypt(userInput, getKey());
            outputResult.setText(plaintext);
        }
    }
    
    private void resetFields() {
        inputString.setText("");
        encryptionKey.setText("");
    }
    
    private boolean checkInput(String input) {
        return input.matches("[a-z]+");
    }
    
    private int getKey() {
        return Integer.parseInt(encryptionKey.getText());
    }
    
    @FXML
    public void toggleMode() {
        encMode = !encMode;
        
        if(encMode) {
            encrypt.setText("Encrypt");
            mode.setText("Encryption");
        } else {
            mode.setText("Decryption");
            encrypt.setText("Decrypt");
        }
    }
}
