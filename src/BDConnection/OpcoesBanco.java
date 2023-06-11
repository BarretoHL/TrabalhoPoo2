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
public class OpcoesBanco extends BDObjeto{

    BDConnection inst = BDConnection.getInstance();
    Connection con = inst.getConexao();

    private String id;
    private String local;
    private String agencia;
    private String conta;
    private String banco;
    private String limite;

    public OpcoesBanco(String idBanco, String localBanco ,String agenciaBanco, String contaBanco, String bancoBanco, String limiteBanco) {
        id = idBanco;
        local = localBanco;
        agencia = agenciaBanco;
        conta = contaBanco;
        banco = bancoBanco;
        limite = limiteBanco;
    }

    public OpcoesBanco() {
    }

    @Override
    public void inserir() {

        try {
            String query = "INSERT INTO banco VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, id);
            pst.setString(2, local);
            pst.setString(3, agencia);
            pst.setString(4, conta);
            pst.setString(5, banco);
            pst.setString(6, limite);

            pst.executeUpdate();

            System.out.println("Inserção realizada com sucesso");
            System.out.println("-"  + id + "-");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void modificar() {
        try {

            String query = "UPDATE banco SET local = ?, agencia = ?, conta= ?, banco = ?, limite = ? WHERE id= ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, id);
            pst.setString(2, local);
            pst.setString(3, agencia);
            pst.setString(4, conta);
            pst.setString(5, banco);
            pst.setString(6, limite);
            
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
               JOptionPane.showMessageDialog(null,"--- Cadastro alterado com sucesso. ---");
            } else {
                JOptionPane.showMessageDialog(null,"--- Nenhum cadastro alterado. ---");
            }

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }
    }

    public void deletar(String nome) {
        try {
            String query = "DELETE FROM banco WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, id);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro apagado.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cadastro apagado.");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar apagar o cadastro :" + e);
        }
    }

    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Bancos cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        

        String[] colunas = {"ID", "Local","Agência","Conta","Banco","Limite"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM banco";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String id = rst.getString("id");
                String local = rst.getString("local");
                String agencia = rst.getString("agencia");
                String conta = rst.getString("conta");
                String banco = rst.getString("banco");
                String limite = rst.getString("limite");
                modelo.addRow(new Object[] { id,local,agencia,conta,banco,limite});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibir os cadastros dos bancos:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
    }
    
}

