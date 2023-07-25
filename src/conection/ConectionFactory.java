/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniv
 */
public class ConectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbLoja";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
             return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de conexão", ex);
        }
       
    }
    
   public static void CloseConection(Connection con){
       if(con != null){
           try {
               con.close();
           } catch (SQLException ex) {
               System.err.println("Erro de conexão "+ ex);
           }
       }
   }
    
 }
