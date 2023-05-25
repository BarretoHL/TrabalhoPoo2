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
 * @author professores
 * 
 *  1° passo
 */
public class TelaInicial extends JFrame{
    
    //2°passo
    public JLabel lblID_Banco,lblLocal, lblAgencia, lblTipo_Conta, lblTipo_Banco,lblLimite;
    public JComboBox cmbID_Banco, cmbTipo_Conta, cmbTipo_Banco, cmbLimite;
    public JTextField txtLocal, txtAgencia;
    public JButton btnEnviar;
    public JButton btnPage2;
    
    private String[] idBanco = {"1- Santander", "2- Itaú", "3- Banco do Brasil", "4- Nubank", "5- C6Bank"};
    private String[] tipoConta = {"Salário", "Poupança", "Corrente"};
    private String[] tipoBanco = {"Físico", "Digital"};
    private String[] limite = {"1000", "1500","2000","2500","3000"};
    
    public TelaInicial() throws ParseException{
        
        //3°passo
        setLayout(null);
        
        //4°passo
        lblID_Banco = new JLabel("Banco");
        cmbID_Banco = new JComboBox(idBanco);
        lblLocal = new JLabel("Local");
        txtLocal = new JTextField();
        lblAgencia = new JLabel("Agência");
        txtAgencia = new JTextField();
        lblTipo_Conta = new JLabel("Tipo de Conta");
        cmbTipo_Conta = new JComboBox (tipoConta);
        lblTipo_Banco = new JLabel ("Tipo de Banco");
        cmbTipo_Banco = new JComboBox(tipoBanco);
        lblLimite = new JLabel("Limite desejado");
        cmbLimite = new JComboBox(limite);
        btnEnviar = new JButton("Enviar");
        btnPage2 = new JButton("Pessoais");
        
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueBtnEnviar();
            }
            
        });
        
        btnPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTela2();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        lblID_Banco.setBounds(10, 10, 200, 25);
        cmbID_Banco.setBounds(120, 10, 200, 25);
        lblLocal.setBounds(10, 60, 200, 25);
        txtLocal.setBounds(120, 60, 200, 25);
        lblAgencia.setBounds(10, 110, 200, 25);
        txtAgencia.setBounds(120, 110, 200, 25);
        lblTipo_Conta.setBounds(10, 160, 200, 25);
        cmbTipo_Conta.setBounds(120, 160, 200, 25);
        lblTipo_Banco.setBounds(10, 210, 200, 25);
        cmbTipo_Banco.setBounds(120, 210, 200, 25);
        lblLimite.setBounds(10, 260,200,25);
        cmbLimite.setBounds(120,260,200,25);
        btnEnviar.setBounds(220, 300, 100, 40);
        btnPage2.setBounds(80, 300, 100, 40);

        getContentPane().add(lblID_Banco);
        getContentPane().add(cmbID_Banco);
        getContentPane().add(lblLocal);
        getContentPane().add(txtLocal);
        getContentPane().add(lblAgencia);
        getContentPane().add(txtAgencia);
        getContentPane().add(lblTipo_Conta);
        getContentPane().add(cmbTipo_Conta);
        getContentPane().add(lblTipo_Banco);
        getContentPane().add(cmbTipo_Banco);
        getContentPane().add(lblLimite);
        getContentPane().add(cmbLimite);
        getContentPane().add(btnEnviar);
        getContentPane().add(btnPage2);
        
        //Especificações da Tela
        setSize(400, 400);
        setTitle("Banco");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    
    private void cliqueBtnEnviar(){
        String id = cmbID_Banco.getSelectedItem().toString(),
               local = txtLocal.getText(),
               agencia = txtAgencia.getText(),
               conta = cmbTipo_Conta.getSelectedItem().toString(),
               banco = cmbTipo_Banco.getSelectedItem().toString(),
               limite = cmbLimite.getSelectedItem().toString();
        
        System.out.println("id : " + id);
        System.out.println("local : " + local);
        System.out.println("agencia : '" + agencia);
        System.out.println("conta : " + conta);
        System.out.println("banco : " + banco);
        System.out.println("limite : " + limite);
        
        try(PrintWriter pw = new PrintWriter(new File("banco.txt"))){
            pw.println("id : " + id);
            pw.println("local : " + local);
            pw.println("agencia : " + agencia);
            pw.println("conta : " + conta);
            pw.println("banco : " + banco);
            pw.println("limite : " + limite);
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não existe");
        }
        try {
             BDConnection.insereUsuario(id,local,agencia, conta, banco, limite);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void cliqueTela2() throws ParseException{
    this.dispose();
    Tela2 Tela2= new Tela2();
        }
    }