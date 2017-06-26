/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Personagem;
import Model.Jogador;
import Model.Povoado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nathan
 */
public class JogadorDAO {
    
       
    public static Jogador getJogadorPorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_jogador where id like '"+id+"';");
       
        Jogador jogador = new Jogador();
        
        Personagem personagem;
        
        //Lista os alunos no console
        while (rs.next()) {

            jogador.setId(rs.getInt("id"));
            jogador.setNome(rs.getString("nome"));
            
            personagem = PersonagemDAO.getPersonagemPorID(rs.getInt("id_personagem"));
            jogador.setPersonagem(personagem);
                       
        }
        
        conn.close();

        return jogador;
    }
    
    public static void incluirJogador(Jogador jogador) throws SQLException, ClassNotFoundException{           
        
        int personagem = jogador.getPersonagem().getId();
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_jogador (id_personagem, nome)" +
                      "VALUES ("+ personagem+",'"
                      + jogador.getNome()+"');";
              
              int i = st.executeUpdate(query);
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarJogador(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_jogador WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
          }
    }

    public static void alterarJogador(Jogador jogador) throws SQLException, ClassNotFoundException{           
        
        int personagem = jogador.getPersonagem().getId();
        
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_jogador SET "
                      + "id_personagem ="+ personagem
                      + ", nome ='"+ jogador.getNome()
                      + "' WHERE ID =" + jogador.getId() + ";";
                      
              st.executeUpdate(query);
          }
    }
     
    
}
