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
public class OpcoesCliente extends BDObjeto{

    BDConnection inst = BDConnection.getInstance();
    Connection con = inst.getConexao();

    private String cpf;
    private String nome;
    private String salario;
    private String endereco;
    private String data;

    public OpcoesCliente(String cpfCliente, String nomeCliente ,String salarioCliente, String enderecoCliente, String dataCliente) {
        cpf = cpfCliente;
        nome = nomeCliente;
        salario = salarioCliente;
        endereco = enderecoCliente;
        data = dataCliente;
    }

    public OpcoesCliente() {
    }

    @Override
    public void inserir() {

        try {
            String query = "INSERT INTO cadastro VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cpf);
            pst.setString(2, nome);
            pst.setString(3, salario);
            pst.setString(4, endereco);
            pst.setString(5, data);

            pst.executeUpdate();

            System.out.println("Inserção realizada com sucesso");
            System.out.println("-"  + nome + "-");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void modificar() {
        try {

            String query = "UPDATE cadastro SET nome = ?, salario = ?, endereco = ?, data = ? WHERE cpf = ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, cpf);
            pst.setString(2, nome);
            pst.setString(3, salario);
            pst.setString(4, endereco);
            pst.setString(5, data);
            
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

    public void deletar(String cpf) {
        try {
            String query = "DELETE FROM cadastro WHERE cpf = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cpf);

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
         
        tela.setTitle("Clientes cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        

        String[] colunas = {"CPF", "Nome","Salario","Endereco","Data"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM cadastro";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String cpf = rst.getString("cpf");
                String nome = rst.getString("nome");
                String salario = rst.getString("salario");
                String endereco = rst.getString("endereco");
                String data = rst.getString("data");
                modelo.addRow(new Object[] { cpf,nome,salario,endereco,data,});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibir os cadastros dos bancos:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
    }
    
}
