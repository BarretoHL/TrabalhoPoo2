/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.Login;

import BDConnection.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CadastroLogin extends JFrame {
    
   //1° passo
    public JLabel lblLogin, lblSenha;
    public JTextField txtLogin, txtSenha;
    public JButton btnCadastrar;
    public JButton btnVoltar;
    
    public CadastroLogin() throws ParseException{
    
              setLayout(null);

        //---------------------------------------------Parente 1 ----------------------------------------------------------
        // 2° passo
        lblLogin = new JLabel("Login:");
        txtLogin = new JTextField();
        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
                
     
        
        btnCadastrar = new JButton("Criar Login");
        
        btnVoltar = new JButton("Voltar");
        
        
        lblLogin.setBounds(10, 40, 200, 25);
        txtLogin.setBounds(80, 40, 250, 25);
        lblSenha.setBounds(10, 80, 200, 25);
        txtSenha.setBounds(80, 80, 250, 25);
        btnCadastrar.setBounds(30,160, 150, 40);
        btnVoltar.setBounds(210,160, 150, 40);
       

      
        getContentPane().add(lblLogin);
        getContentPane().add(txtLogin);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnCadastrar);
        getContentPane().add(btnVoltar);
        
      
        setSize(400, 300);
        setTitle("Cadastrar Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastraLogin();
                  try {
                    Voltar();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Voltar();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    private synchronized void CadastraLogin(){
    String nomeLogin  = txtLogin.getText();
    String senhaLogin = txtSenha.getText();
    
    
        try {
            Login login = new Login(nomeLogin, senhaLogin);
            login.inserir();
        } catch (Exception e) {
        }
    }
    
    private void Voltar() throws ParseException{
        this.dispose();
        TelaLogin TelaLogin = new TelaLogin();
    }
}