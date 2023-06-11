/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.Cadastro;

import BDConnection.OpcoesBanco;
import BDConnection.OpcoesCliente;
import gui.Banco.DeletaBanco;
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
public class DeletaCadastro extends JFrame{
    
    private final JLabel lblDelete;
    private final  JTextField txtCpf;
    private final JButton btnDeletar;
    private final JButton btnVoltar;
        
    public DeletaCadastro() {
             
        setLayout(null);
        
        lblDelete = new JLabel("Digite o CPF:");
        txtCpf = new JTextField();
        
        btnDeletar = new JButton("Deletar");
        btnVoltar = new JButton("Voltar");
        
        lblDelete.setBounds(10, 40, 200, 25);
        txtCpf.setBounds(160, 40, 250, 25);
        btnDeletar.setBounds(40,90, 150, 40);
        btnVoltar.setBounds(240,90, 150, 40);
        
        
        getContentPane().add(lblDelete);
        getContentPane().add(txtCpf);
        getContentPane().add(btnDeletar);
        getContentPane().add(btnVoltar);
        
        
        setSize(450, 200);
        setTitle("Deletar Cadastro Cliente");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          btnDeletar.addActionListener((ActionEvent e) -> {
            deletarCadastro();
        });
        
        btnVoltar.addActionListener((ActionEvent e) -> {
            try {
                voltarMenu();
            } catch (ParseException ex) {
                Logger.getLogger(DeletaCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    
    }
    
    private void deletarCadastro(){
      
       String cpf = txtCpf.getText();
       OpcoesCliente opcoesCliente = new OpcoesCliente();
       opcoesCliente.deletar(cpf);
    }
    
    private void voltarMenu() throws ParseException{
        this.dispose();
        OpcoesCadastro opcoesCadastro = new OpcoesCadastro();
    }
}
