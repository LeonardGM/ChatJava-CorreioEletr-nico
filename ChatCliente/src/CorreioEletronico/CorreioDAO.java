/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreioEletronico;

import Telas.CorreioEletronico;
import Telas.TelaLogin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marti
 */
public class CorreioDAO {
    
    public List<Correio> read(){

        Connection con = ConnectionFactory.getConnection();

        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Correio> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM mensagens WHERE destinatario LIKE ?" /*+TelaLogin.email*/);
            stmt.setString(1, "%"+TelaLogin.email+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Correio produto = new Correio();

                //produto.setId_mensagem(rs.getInt("id_mensagem"));
                produto.setRemetente(rs.getString("remetente"));
                produto.setDestinatario(rs.getString("destinatario"));
                produto.setAssunto(rs.getString("assunto"));
                produto.setMensagem(rs.getString("mensagem"));
                produto.setData(rs.getString("data_mensagem"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CorreioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    
    public boolean Mensagem(String remetente, String destinatario, String assunto, String mensagem) throws SQLException {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyyMMdd");
        //System.out.print(formatarDate.format(data));
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO mensagens() "
                + "VALUES(null, '" + remetente + "', '" + destinatario + "', '" + assunto + "', '" + mensagem + "', '" + formatarDate.format(data) + "' )";
        System.out.println(sql);
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.execute();
            return true;
        }                
    }
    
    public void delete(Correio p) {

        Connection con = ConnectionFactory.getConnection();
        
        ResultSet rs = null;
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM mensagens WHERE assunto = ?");
            stmt.setString(1, p.getAssunto());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
