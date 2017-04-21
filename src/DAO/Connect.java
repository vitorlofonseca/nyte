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
    
    private static Connection connection;
    
    public static Connection conectar() throws ClassNotFoundException, SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://52.33.82.146/nyte", "USUARIO", "SENHA");
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
        return connection;
    }
}
