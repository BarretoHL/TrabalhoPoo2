/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author professores
 */
public class BDConnection {
  
    private static BDConnection instancia;
    
    public static void insereLogin(String login, String senha) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "1511");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO banco (LOGIN, SENHA)VALUES" + 
                    "('"+login+"','"+senha+"')");
        
        conexao.close();

    }
    public static void insereUsuario(String id, String local, String agencia, String conta, String banco, String limite) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "1511");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO banco (ID, LOCAL, AGENCIA, CONTA, BANCO, LIMITE)VALUES" + 
                    "('"+id+"','"+local+"','"+agencia+"','"+conta+"','"+banco+"','"+limite+"')");
        
        conexao.close();

    }
    
    public static void inserePessoais(String cpf, String nome, String salario, String endereco, String data) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/conta_banco";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "1511");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO cadastro (CPF, NOME, SALARIO, ENDERECO, DATA)VALUES" + 
                    "('"+cpf+"','"+nome+"','"+salario+"','"+endereco+"','"+data+"')");
        
        conexao.close();

    }
    
    public static synchronized BDConnection getInstance(){
        
        if(instancia == null){
            instancia = new BDConnection();
        }
        return instancia;
    } 
    
    public void conectar(){
        
        System.out.println("conectei");
    }
    
    public void desconectar(){
        
        System.out.println("desconectei");
    }
}
