
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
public class TelaLogin extends JFrame{
    
    //2°passo
    public JLabel lblLogin, lblSenha, lblCadastrar;
    public JTextField txtLogin, txtSenha;
    public JButton btnEnviar2;
    public JButton btnCadastrar;
    
    
    public TelaLogin() throws ParseException{
        
        //3°passo
        setLayout(null);
        
        //4°passo
        lblLogin = new JLabel("Login:");
        txtLogin = new JTextField();
        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
        btnEnviar2 = new JButton("Acessar");
        btnCadastrar = new JButton("Cadastrar");
        
        btnEnviar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueBtnEnviar();
            }
        });
        
       btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueTela2();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
        
        
        lblLogin.setBounds(10, 60, 200, 25);
        txtLogin.setBounds(120, 60, 200, 25);
        lblSenha.setBounds(10, 110, 200, 25);
        txtSenha.setBounds(120, 110, 200, 25);
        btnEnviar2.setBounds(150, 170, 100, 40);
        btnCadastrar.setBounds(150, 220, 100, 40);

        getContentPane().add(lblLogin);
        getContentPane().add(txtLogin);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnEnviar2);
        getContentPane().add(btnCadastrar);
        
        //Especificações da Tela
        setSize(400, 400);
        setTitle("Tela de Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    
    private void cliqueBtnEnviar(){
        String login = txtLogin.getText(),
               senha = txtSenha.getText();
              
        
        System.out.println("login : " + login);
        System.out.println("senha : " + senha);
        
        try(PrintWriter pw = new PrintWriter(new File("login.txt"))){
            pw.println("login : " + login);
            pw.println("senha : " + senha);
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não existe");
        }
        try {
             BDConnection.insereLogin(login, senha);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void cliqueTela2() throws ParseException{
    this.dispose();
    TelaInicial TelaInicial= new TelaInicial();
    }
}