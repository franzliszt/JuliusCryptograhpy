/*
 * @author Stian Reistad Røgeberg
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
        String userInput = inputString.getText();
        boolean ok = checkInput(userInput, encryptionKey.getText());
        
        if(encMode && ok) {
            String cipherText = c.encrypt(userInput.toUpperCase(), getKey());
            outputResult.setText(cipherText.toUpperCase());
        } 
        
        if(!encMode && ok){
            String plaintext = c.decrypt(userInput.toUpperCase(), getKey());
            outputResult.setText(plaintext.toUpperCase());
        }
    }
    
    private void resetFields() {
        inputString.setText("");
        encryptionKey.setText("");
    }
    
    private boolean checkInput(String input, String key) {
        return input.matches("[a-zA-Z]+") && key.matches("[0-9]");
    }
    
    private int getKey() {
        return Integer.parseInt(encryptionKey.getText());
    }
    
    @FXML
    public void toggleMode() {
        encMode = !encMode;
        resetFields();
        
        if(encMode) {
            encrypt.setText("Encrypt");
            mode.setText("Encryption");
        } else {
            mode.setText("Decryption");
            encrypt.setText("Decrypt");
        }
    }
}
