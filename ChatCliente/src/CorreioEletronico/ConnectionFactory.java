/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreioEletronico;

import Telas.TelaLogin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marti
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_redes";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

    /*private static String status = "Não conectou...";
    public Statement stm;
    public ResultSet rs;
    // Atributo do tipo Connection.
    Connection connection = null;
    
   

    
    public boolean Mensagem(String remetente, String destinatario, String assunto, String mensagem) throws SQLException {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyyMMdd");
        //System.out.print(formatarDate.format(data));
        getConexaoMySQL();
        String sql = "INSERT INTO mensagens() "
                + "VALUES(null, '" + remetente + "', '" + destinatario + "', '" + assunto + "', '" + mensagem + "', '" + formatarDate.format(data) + "' )";
        System.out.println(sql);
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            return true;
        }                
    }
    
    public boolean Recuperar(String remetente, String destinatario, String assunto, String mensagem) throws SQLException{
        ConnectionFactory conex = new ConnectionFactory();
        
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyyMMdd");
        getConexaoMySQL();
        conex.executaSQL("SELECT * FROM mensagens() WHERE destinatario = " + TelaLogin.email);
        //System.out.println(sql);
        try {
            conex.rs.first();
            return true;
        }catch(SQLException ex){
            System.out.println("deu ruim");
        }
        return false;
       
    }*/


    
    

