/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author BARRETO
 */
public class OpcoesCadastro extends JFrame {
    
    public JButton btnModificaBanco;
    public JButton btnDeletaBanco;
    public JButton btnListaBanco;
    
    public OpcoesCadastro() throws ParseException{
        
        //3°passo
        setLayout(null);
        
        //4°passo
        
        btnModificaBanco = new JButton("Modificar Cadastro");
        btnDeletaBanco = new JButton("Deletar Cadastro");
        btnListaBanco = new JButton("Listar Cadastros");
        
        btnModificaBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaModifica();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                                                                           
        });
        
       btnDeletaBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaDeleta();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
       
       btnListaBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaLista();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
        
        btnModificaBanco.setBounds(100, 60, 200, 25);
        btnDeletaBanco.setBounds(100, 120, 200, 25);
        btnListaBanco.setBounds(100, 180, 200, 25);
        
        
        getContentPane().add(btnModificaBanco);
        getContentPane().add(btnDeletaBanco);
        getContentPane().add(btnListaBanco);
        
        setSize(400, 400);
        setTitle("Mais Opções");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        private void cliqueTelaModifica() throws ParseException{
        this.dispose();
        ModificaBanco ModificaBanco= new ModificaBanco();
    }
        private void cliqueTelaDeleta() throws ParseException{
        this.dispose();
        ModificaBanco ModificaBanco= new ModificaBanco();
    }
        private void cliqueTelaLista() throws ParseException{
        this.dispose();
        ModificaBanco ModificaBanco= new ModificaBanco();
    }
    
}
