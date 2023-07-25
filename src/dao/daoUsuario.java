/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.ConectionFactory;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Usuario;

/**
 *
 * @author viniv
 */
public class daoUsuario {
    
    private Connection con = null;

    public daoUsuario() {
        
        this.con = ConectionFactory.getConnection();
    }
    
    public List<Usuario> ler(){
        
        PreparedStatement smt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            smt = con.prepareStatement("SELECT * FROM usuario");
            rs = smt.executeQuery();
            
            while (rs.next()) {
            
               Usuario usuario = new Usuario();
               
               usuario.setIdUsuario(rs.getInt("idUsuario"));
               usuario.setUsuario(rs.getString("nome"));
               usuario.setSenhaDoUsuario(rs.getString("senha"));
               usuario.setStatusDoUsuario(rs.getString("nivelDeAcesso"));
               usuarios.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConectionFactory.CloseConection(con);
        }       
              
        
        return usuarios;    
        
    }
    
    public boolean salvarUsuario(Usuario u){
        
        String sqlSalvar = "INSERT INTO usuario(nome, cpf, senha, nivelDeAcesso, dataNascimento) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement smt;
        try {
            smt = con.prepareStatement(sqlSalvar);
            smt.setString(1, u.getUsuario());
            smt.setString(2, u.getCpf());
            smt.setString(3, u.getSenhaDoUsuario());
            smt.setString(4, u.getStatusDoUsuario());
            smt.setString(5, u.getDataNascimento());
            smt.execute();
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "O usuario não foi salvo devido ao erro: "+ex);
            return false;
        }
        
        
    }
    
    public boolean deletarUsuario(int id){
        
        String sqlDeletar = " DELETE 'usuario' WHERE id = ?";
        PreparedStatement smt;
        
        try {
            smt = con.prepareStatement(sqlDeletar);
            smt.setInt(1, id);
            smt.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "falha ao deletar usuari "+"/n tipo de falha: "+e);
            return false;
        }
    }
    
    public boolean atualizarUsuario(Usuario u){
        
        String sql = "UPDATE usuario SET nome = ?, status  = ?, senha = ? WHERE id = ?";
        PreparedStatement smt = null;        
        
        try {
            smt.setString(1, u.getUsuario());
            smt.setString(2, u.getStatusDoUsuario());
            smt.setString(3, u.getSenhaDoUsuario());
            smt.setInt(4, u.getIdUsuario());
            smt.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "falha ao atualizar usuari "+u.getUsuario()+"/n tipo de falha: "+e);
            return false;
        }
    }
    
    
    
}
