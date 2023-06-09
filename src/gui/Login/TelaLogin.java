
package gui.Login;

import BDConnection.BDConnection;
import BDConnection.Login;
import gui.CadastroBanco;
import gui.OpcoesCadastro;
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
public class TelaLogin extends JFrame{
    
    //2°passo
    public JLabel lblLogin, lblSenha, lblCadastrar;
    public JTextField txtLogin, txtSenha;
    public JButton btnAcessar;
    public JButton btnCadastrar;
    public JButton btnOpcoes;
    
    
    public TelaLogin() throws ParseException{
        
        //3°passo
        setLayout(null);
        
        //4°passo
        lblLogin = new JLabel("Login:");
        txtLogin = new JTextField();
        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
        btnAcessar = new JButton("Logar");
        btnCadastrar = new JButton("Cadastrar");
        btnOpcoes = new JButton("Mais opções");
        
        btnAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    logar();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
       btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CadastroLogin();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        lblLogin.setBounds(10, 60, 200, 25);
        txtLogin.setBounds(120, 60, 200, 25);
        lblSenha.setBounds(10, 110, 200, 25);
        txtSenha.setBounds(120, 110, 200, 25);
        btnAcessar.setBounds(150, 170, 100, 40);
        btnCadastrar.setBounds(150, 220, 100, 40);
        btnOpcoes.setBounds(150, 270, 125, 40);


        getContentPane().add(lblLogin);
        getContentPane().add(txtLogin);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnAcessar);
        getContentPane().add(btnCadastrar);
        getContentPane().add(btnOpcoes);
        
        //Especificações da Tela
        setSize(400, 400);
        setTitle("Tela de Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    
    private synchronized void logar() throws ParseException{
       String nome = txtLogin.getText();
        String senha = txtSenha.getText();
              
        
       VerificaAcesso VerificaAcesso = new VerificaAcesso(nome, senha);

       
        if (VerificaAcesso.Acessa(nome, senha) == true) {
            this.dispose();
            CadastroBanco CadastroBanco = new CadastroBanco();

        }
    }
    
    private void CadastroLogin() throws ParseException{
    this.dispose();
    CadastroLogin CadastroLogin= new CadastroLogin();
    }
    
    private void cliqueOpcoesCadastro() throws ParseException{
    this.dispose();
    OpcoesCadastro OpcoesCadastro= new OpcoesCadastro();
    }
}