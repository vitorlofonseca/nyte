/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AtributoCombate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nathan
 */
public class AtributoCombateDAO {
    
    public static AtributoCombate getAtributoCombatePorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_atributo_combate where id like '"+id+"';");
       
        AtributoCombate atributoCombate = new AtributoCombate();
        
        
        //Lista os alunos no console
        while (rs.next()) {

            atributoCombate.setId(rs.getInt("id"));
            atributoCombate.setAtributo(rs.getString("atributo"));
                      
        }
        
        conn.close();

        return atributoCombate;
    }
    
    public static void incluirAtributoCombate(AtributoCombate atributoCombate) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_atributo_combate (atributo)" +
                      "VALUES ('"+ atributoCombate.getAtributo()+"');";
              
              int i = st.executeUpdate(query);
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarAtributoCombate(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_atributo_combate WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
          }
    }

    public static void alterarAtributoCombate(AtributoCombate atributoCombate) throws SQLException, ClassNotFoundException{           
        
        try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_atributo_combate SET "
                      + " atributo ='"+ atributoCombate.getAtributo()
                      + "' WHERE ID =" + atributoCombate.getId() + ";";
                      
              st.executeUpdate(query);
          }
    }
     
}
