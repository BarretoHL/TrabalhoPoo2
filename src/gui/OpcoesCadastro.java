/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import BDConnection.OpcoesBanco;
import gui.Banco.DeletaBanco;
import gui.Banco.ModificaBanco;
import gui.Cadastro.DeletaCadastro;
import gui.Cadastro.ModificaCadastro;
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author BARRETO
 */
public class OpcoesCadastro extends JFrame {
    
    public JButton btnModificaCadastro;
    public JButton btnDeletaCadastro;
    public JButton btnListaCadastro;
    public JButton btnModificaBanco;
    public JButton btnDeletaBanco;
    public JButton btnListaBanco;
    
    public OpcoesCadastro() throws ParseException{
        
        //3°passo
        setLayout(null);
        
        //4°passo
        
        btnModificaCadastro = new JButton("Modificar Cadastro");
        btnDeletaCadastro= new JButton("Deletar Cadastro");
        btnListaCadastro = new JButton("Listar Cadastros");
        btnModificaBanco = new JButton("Modificar Banco");
        btnDeletaBanco = new JButton("Deletar Banco");
        btnListaBanco = new JButton("Listar Banco");
        
        btnModificaCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaModificaCadastro();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                                                                           
        });
        
       btnDeletaCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaDeletaCadastro();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
       
       btnListaCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaListaCadastro();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
       
       btnModificaBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaModificaBanco();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
       
       btnDeletaBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaDeletaBanco();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
       
       btnListaBanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaListaBanco();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
        
        btnModificaCadastro.setBounds(100, 60, 200, 25);
        btnDeletaCadastro.setBounds(100, 100, 200, 25);
        btnListaCadastro.setBounds(100, 140, 200, 25);
        btnModificaBanco.setBounds(100, 200, 200, 25);
        btnDeletaBanco.setBounds(100, 240, 200, 25);
        btnListaBanco.setBounds(100, 280, 200, 25);
        
        
        getContentPane().add(btnModificaCadastro);
        getContentPane().add(btnDeletaCadastro);
        getContentPane().add(btnListaCadastro);
        getContentPane().add(btnModificaBanco);
        getContentPane().add(btnDeletaBanco);
        getContentPane().add(btnListaBanco);
        
        setSize(400, 400);
        setTitle("Mais Opções");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        private void cliqueTelaModificaCadastro() throws ParseException{
        this.dispose();
        ModificaCadastro ModificaCadastro= new ModificaCadastro();
    }
        private void cliqueTelaDeletaCadastro() throws ParseException{
        this.dispose();
        DeletaCadastro DeletaCadastro= new DeletaCadastro();
    }
        private void cliqueTelaListaCadastro() throws ParseException{
        this.dispose();
        //ModificaBanco ModificaBanco= new ModificaBanco();
    }
        private void cliqueTelaModificaBanco() throws ParseException{
        this.dispose();
        ModificaBanco ModificaBanco= new ModificaBanco();
    }
        private void cliqueTelaDeletaBanco() throws ParseException{
        this.dispose();
        DeletaBanco DeletaBanco= new DeletaBanco();
    }
        private void cliqueTelaListaBanco() throws ParseException{
        this.dispose();
        //ModificaBanco ModificaBanco= new ModificaBanco();
    }
}   
