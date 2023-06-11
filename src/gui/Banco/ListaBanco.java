/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.Banco;

import BDConnection.BDConnection;
import BDConnection.OpcoesBanco;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**

/**
 *
 * @author BARRETO
 */
public class ListaBanco extends JFrame {
    
    //BDConnection inst = BDConnection.getInstance();
    //Connection con = inst.getConexao();
    
    //public ListaBanco() throws ParseException, SQLException{
    //String[] colunas = {"ID", "Local", "Agencia", "Conta", "Banco", "Limite"};
   // DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
   // JTable tabela = new JTable(modelo);
    //try {
       // String query = "SELECT * FROM banco";
        
        //PreparedStatement pst = con.preparedStatement(query);
        
        //ResultSet rst = pst.executeQuery();
        
            //System.out.println("Informações retornadas");
            
        //while (rst.next()){
            //String id = rst.getString("id");
            //String local = rst.getString("local");
            //String agencia = rst.getString("agencia");
            //String conta = rst.getString("conta");
            //String banco = rst.getString("banco");
            //String limite = rst.getString("limite");
            //modelo.addRow(New Object[]{ id, local, agencia, conta, banco, limite});
        //}
//}   catch (SQLException ex){
            //System.out.println("Erro ao exibir cadastros: " + ex);
//}
        //tela.add(new JScrollPane(tabela));
        //tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //tela.setVisible;
    // 
}
