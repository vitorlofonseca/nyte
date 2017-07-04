/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Especie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


/**
 *
 * @author Nathan
 */
public class EspecieDAO {
    
    
    public static HashMap getEspecies() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_especie;");
        
        HashMap<Integer,Especie> especies = new HashMap<Integer,Especie>();

        //Lista os alunos no console
        while (rs.next()) {
            
            Especie especie = new Especie();

            especie.setId(rs.getInt("id"));
            especie.setNome(rs.getString("nome"));
            
            especies.put (rs.getInt("id"), especie);
        }

        return especies;
    }
    
       
    public static Especie getEspeciePorId(int id) throws SQLException, ClassNotFoundException{
        
        Connection conn = Connect.conectar();
        
        Especie especie = new Especie();
 
        //Executa a query de seleção
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_especie where id="+id);

        //Lista os alunos no console
        while (rs.next()) {
            especie.setId(rs.getInt("id"));
            especie.setNome(rs.getString("nome"));
        }
        
        return especie;
    }    
    
    
    public static Especie getEspeciePorEspecie(String especieString) throws SQLException, ClassNotFoundException{
        
        Connection conn = Connect.conectar();
        
        Especie especie = new Especie();
 
        //Executa a query de seleção
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_especie where nome like '"+especieString+"';");

        //Lista os alunos no console
        while (rs.next()) {
            especie.setId(rs.getInt("id"));
            especie.setNome(rs.getString("nome"));
        }
        
        return especie;
    }    
    
}
