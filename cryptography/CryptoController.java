/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import javafx.fxml.FXML;

/**
 *
 * @author stianreistadrogeberg
 */
public class CryptoController {
    private ClassicCryptography c;
    
    public CryptoController() {
        init();
    }
    
    private void init() {
        c = new ClassicCryptography();
    }
    
    @FXML
    public void encrypt() {
        System.out.println(c.encrypt("xyz", 2));
        
    }

    
}
