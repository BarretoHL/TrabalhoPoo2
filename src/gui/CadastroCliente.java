/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import gui.Login.TelaLogin;
import BDConnection.OpcoesCliente;
import gui.Login.CadastroLogin;
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
public class CadastroCliente extends JFrame{
    
    //2°passo
    public JLabel lblCpf, lblNome, lblSalario, lblEndereco, lblData;
    public JTextField txtCPF, txtNome, txtSalario, txtEndereco, txtData;
    public JButton btnEnviar2;
    public JButton btnPage1;
    public JButton btnOpcoes;
     
    
    public CadastroCliente() throws ParseException{
        
        //3°passo
        setLayout(null);
        
        //4°passo
        lblCpf = new JLabel("CPF:");
        txtCPF = new JTextField();
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        lblSalario = new JLabel("Salário:");
        txtSalario = new JTextField();
        lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField ();
        lblData = new JLabel ("Data:");
        txtData = new JTextField();
        btnEnviar2 = new JButton("Enviar");
        btnPage1 = new JButton("Conta");
        btnOpcoes = new JButton("Mais opções");
        
        btnEnviar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                    cliqueTelaLogin();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                cliqueBtnEnviar();
            }
            
        });
        
       btnPage1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTelaInicial();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
       
       btnOpcoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueOpcoesCadastro();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
        
        
        lblCpf.setBounds(10, 10, 200, 25);
        txtCPF.setBounds(120, 10, 200, 25);
        lblNome.setBounds(10, 60, 200, 25);
        txtNome.setBounds(120, 60, 200, 25);
        lblSalario.setBounds(10, 110, 200, 25);
        txtSalario.setBounds(120, 110, 200, 25);
        lblEndereco.setBounds(10, 160, 200, 25);
        txtEndereco.setBounds(120, 160, 200, 25);
        lblData.setBounds(10, 210, 200, 25);
        txtData.setBounds(120, 210, 200, 25);
        btnEnviar2.setBounds(220, 250, 100, 40);
        btnPage1.setBounds(80, 250, 100, 40);
        btnOpcoes.setBounds(80, 300, 240, 40);

        getContentPane().add(lblCpf);
        getContentPane().add(txtCPF);
        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        getContentPane().add(lblSalario);
        getContentPane().add(txtSalario);
        getContentPane().add(lblEndereco);
        getContentPane().add(txtEndereco);
        getContentPane().add(lblData);
        getContentPane().add(txtData);
        getContentPane().add(btnEnviar2);
        getContentPane().add(btnPage1);
        getContentPane().add(btnOpcoes);
        
        //Especificações da Tela
        setSize(400, 400);
        setTitle("Cadastro");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    
    private void cliqueBtnEnviar(){
        String cpf = txtCPF.getText(),
               nome = txtNome.getText(),
               salario = txtSalario.getText(),
               endereco = txtEndereco.getText(),
               data = txtData.getText();
        
        System.out.println("cpf : " + cpf);
        System.out.println("nome : " + nome);
        System.out.println("salario : " + salario);
        System.out.println("endereco : " + endereco);
        System.out.println("data : " + data);
        
        try(PrintWriter pw = new PrintWriter(new File("cadastro.txt"))){
            pw.println("cpf : " + cpf);
            pw.println("nome : " + nome);
            pw.println("salario : " + salario);
            pw.println("endereco : " + endereco);
            pw.println("data : " + data);
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não existe");
        }
        try {
             OpcoesCliente opcoesCliente = new OpcoesCliente(cpf, nome, salario, endereco, data);
             opcoesCliente.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
    }
    
    private void cliqueTelaLogin() throws ParseException{
    this.dispose();
    TelaLogin TelaLogin= new TelaLogin();
    }
    
    private void cliqueTelaInicial() throws ParseException{
    this.dispose();
    CadastroBanco TelaInicial= new CadastroBanco();
    }
    
    private void cliqueOpcoesCadastro() throws ParseException{
    this.dispose();
    OpcoesCadastro OpcoesCadastro= new OpcoesCadastro();
    }
}