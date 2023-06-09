/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author professores
 */
public class BDConnection {
  
    
    public static void insereLogin(String login, String senha) throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        //String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
        //Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        //"root", 
                                                        //"1511");
       
        //Statement comando = (Statement) conexao.createStatement();
        
            //comando.execute("INSERT INTO banco (LOGIN, SENHA)VALUES" + 
                    //"('"+login+"','"+senha+"')");
        
        //conexao.close();

    }
    public static void insereBanco(String id, String local, String agencia, String conta, String banco, String limite) throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        //String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
        //Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        //"root", 
                                                        //"1511");
       
        //Statement comando = (Statement) conexao.createStatement();
        
            //comando.execute("INSERT INTO banco (ID, LOCAL, AGENCIA, CONTA, BANCO, LIMITE)VALUES" + 
                    //"('"+id+"','"+local+"','"+agencia+"','"+conta+"','"+banco+"','"+limite+"')");
        
        //conexao.close();

    }
    
    public static void inserePessoais(String cpf, String nome, String salario, String endereco, String data) throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        //String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
        //Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        //"root", 
                                                        //"1511");
       
        //Statement comando = (Statement) conexao.createStatement();
        
            //comando.execute("INSERT INTO cadastro (CPF, NOME, SALARIO, ENDERECO, DATA)VALUES" + 
                    //"('"+cpf+"','"+nome+"','"+salario+"','"+endereco+"','"+data+"')");
        
        //conexao.close();

    }
    
    private java.sql.Connection conexao;
    
    private static final String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
    private static final String usuario = "root";
    private static final String senha = "1511";
    
    private static BDConnection instance;
    
    private BDConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexao funcionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro na conexão" + ex.getMessage());
        }
    }

    public static synchronized BDConnection getInstance() {

        if (instance == null) {
            instance = new BDConnection();
        }
        return instance;
    }

    public synchronized java.sql.Connection getConexao() {
        return this.conexao;
    }
}
