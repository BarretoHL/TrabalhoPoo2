/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import gui.BDConnection;
import gui.TelaLogin;
import java.text.ParseException;

/**
 *
 * @author graduacao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       
        new TelaLogin();
        
        BDConnection.getInstance().conectar();
    }    
 
    
}
