/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.Login;

import BDConnection.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author BARRETO
 */
public class VerificaAcesso {

    BDConnection inst = BDConnection.getInstance();
    Connection con = inst.getConexao();

    public VerificaAcesso(String nome, String senha) {

    }

    public boolean Acessa(String nome, String senha) {

        try {
            String query = "SELECT * FROM login WHERE nome =? AND senha=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro:" + ex);
        }
        return false;
    }
}
