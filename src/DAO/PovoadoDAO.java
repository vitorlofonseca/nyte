/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Povoado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Nathan
 */
public class PovoadoDAO {
       
    public static Povoado getPovoadoPorId(int id) throws SQLException, ClassNotFoundException{
        
        Connection conn = Connect.conectar();
        
        Povoado povoado = new Povoado();
 
        //Executa a query de seleção
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_povoado where id="+id);

        //Lista os alunos no console
        while (rs.next()) {
            povoado.setId(rs.getInt("id"));
            povoado.setNome(rs.getString("nome"));
        }
        
        return povoado;
    }    
}
