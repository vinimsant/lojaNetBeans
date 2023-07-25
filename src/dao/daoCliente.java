/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniv
 */
public class daoCliente {
    private Connection con = null;

    public daoCliente() {
        
        this.con = ConectionFactory.getConnection();
    }
    
    public boolean save(){
        
        String nome = "Maria";
        String sql = "INSERT INTO clientes (nome) VALUES (?)";
        PreparedStatement smt = null;
        
        try {
            smt = con.prepareStatement(sql);
            smt.setString(1, nome);
            smt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(daoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            ConectionFactory.CloseConection(con);
        }
       
    }
    
}
