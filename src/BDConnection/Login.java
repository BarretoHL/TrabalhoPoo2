/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author BARRETO
 */
public class Login extends BDObjeto{
    
   BDConnection inst = BDConnection.getInstance();
    Connection con = inst.getConexao();

    private String login;
    private String senha;
    private String NomeAtual;

    public Login(String nomeUser, String senhaUser) {
        login = nomeUser;
        senha = senhaUser;
        NomeAtual = nomeUser;
    }

    @Override
    public void inserir() {
        try {
            String query = "INSERT INTO login VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, login);
            pst.setString(2, senha);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Login! efetuado");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void mostrar() {
        JFrame tela = new JFrame();

        tela.setTitle("Login cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Senha"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);

        try {
            String query = "SELECT * FROM login";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String nome = rst.getString("nome_usuario");
                String senha = rst.getString("senha_usuario");
                modelo.addRow(new Object[]{nome, senha});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Exibe a janela
        tela.setVisible(true);
    }

    @Override
    public void atualizar() {
        try {

            String query = "UPDATE usuarios SET nome_usuario = ?, senha_usuario = ? WHERE nome_usuario = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, login);
            pst.setString(2, senha);
            pst.setString(3, NomeAtual);
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro alterado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro alterado. ###");
            }

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }

    }

    public void deletar(String nome) {
        try {
            String query = "DELETE FROM usuarios WHERE nome_usuario = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro eliminado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro eliminado. ###");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
    }
}