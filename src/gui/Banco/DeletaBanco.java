/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.Banco;

import BDConnection.OpcoesBanco;
import gui.OpcoesCadastro;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author BARRETO
 */
public class DeletaBanco extends JFrame{
    
    private final JLabel lblDelete;
    private final JComboBox cmbID_Banco;
    private final JButton btnDeletar;
    private final JButton btnVoltar;
    
    private final String[] idBanco = {"1- Santander", "2- Itaú", "3- Banco do Brasil", "4- Nubank", "5- C6Bank"};
    
    public DeletaBanco() {
             
        setLayout(null);
        
        lblDelete = new JLabel("Selecione o banco:");
        cmbID_Banco = new JComboBox(idBanco);
        
        btnDeletar = new JButton("Deletar");
        btnVoltar = new JButton("Voltar");
        
        lblDelete.setBounds(10, 40, 200, 25);
        cmbID_Banco.setBounds(160, 40, 250, 25);
        btnDeletar.setBounds(40,90, 150, 40);
        btnVoltar.setBounds(240,90, 150, 40);
        
        
        getContentPane().add(lblDelete);
        getContentPane().add(cmbID_Banco);
        getContentPane().add(btnDeletar);
        getContentPane().add(btnVoltar);
        
        
        setSize(450, 200);
        setTitle("Deletar Cadastro Banco");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          btnDeletar.addActionListener((ActionEvent e) -> {
            deletarBanco();
        });
        
        btnVoltar.addActionListener((ActionEvent e) -> {
            try {
                voltarMenu();
            } catch (ParseException ex) {
                Logger.getLogger(DeletaBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    
    }
    
    private void deletarBanco(){
      
       String id = cmbID_Banco.getSelectedItem().toString();
       OpcoesBanco opcoesbanco = new OpcoesBanco();
       opcoesbanco.deletar(id);
    }
    
    private void voltarMenu() throws ParseException{
        this.dispose();
        OpcoesCadastro opcoesCadastro = new OpcoesCadastro();
    }
    
}
