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
    private ClassicCryptography c;
    private boolean encMode;
    
    @FXML public TextField inputString;
    @FXML public TextField encryptionKey;
    @FXML public Button encrypt;
    @FXML public Button mode;
    @FXML public Label outputResult;
    
    
    public CryptoController() {
        encMode = true;
        init();
    }
    
    private void init() {
        c = new ClassicCryptography();
    }
    
    @FXML
    public void encryptionMode() {
        if(encMode) {
            outputResult.setText(c.encrypt(inputString.getText(), getKey()));
            System.out.println("inne");
        } else {
            c.decrypt("", getKey());
        }
    }
    
    private String getInput() {
        return inputString.getText();
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
