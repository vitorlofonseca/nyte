/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Adversidade;
import Model.Personagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nathan
 */
public class AdversidadeDAO {
    
    
    public static Adversidade getAdversidadePorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_adversidade where id like '"+id+"';");
       
        Adversidade adversidade = new Adversidade();
        
        Personagem personagem;
        
        //Lista os alunos no console
        while (rs.next()) {

            adversidade.setId(rs.getInt("id"));
            adversidade.setNome(rs.getString("nome"));
            adversidade.setHp(rs.getInt("hp"));
            
            personagem = PersonagemDAO.getPersonagemPorID(rs.getInt("id_personagem"));
            adversidade.setPersonagem(personagem);
                       
        }
        
        

        return adversidade;
    }
    
    public static void incluirAdversidade(Adversidade adversidade) throws SQLException, ClassNotFoundException{           
        
        int personagem = adversidade.getPersonagem().getId();
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_adversidade (id_personagem, nome, hp)" +
                      "VALUES ("+ personagem+",'"
                      + adversidade.getNome()+"',"
                      + adversidade.getHp() + ");";
              
              int i = st.executeUpdate(query);
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarAdversidade(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_adversidade WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
          }
    }

    public static void alterarAdversidade(Adversidade adversidade) throws SQLException, ClassNotFoundException{           
        
        int personagem = adversidade.getPersonagem().getId();
        
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_adversidade SET "
                      + "id_personagem ="+ personagem
                      + ", nome ='"+ adversidade.getNome()
                      + "', hp = " + adversidade.getHp()
                      + " WHERE ID =" + adversidade.getId() + ";";
                      
              st.executeUpdate(query);
          }
    }
     
    
    
}
