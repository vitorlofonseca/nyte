/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitorlofonseca
 */
public class Connect {
    
    private static Connection connection = null;
    
    public static Connection conectar() throws ClassNotFoundException, SQLException{
        
        try {
           
            if(connection == null){
                
                Class.forName("org.sqlite.JDBC");
                // Não precisa alterar mais nada   
                connection = DriverManager.getConnection("jdbc:sqlite:src/DAO/database/nyte.sqlite");
            }
        
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
      
            
        return connection;
    }
}
