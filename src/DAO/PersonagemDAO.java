/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AreaCorpo;
import Model.Especie;
import Model.Personagem;
import Model.Povoado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javafx.scene.control.Tab;

/**
 *
 * @author Nathan
 */
public class PersonagemDAO {
    
    public static Personagem getPersonagemPorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_personagem where id like '"+id+"';");
       
        Personagem personagem = new Personagem();
        
        Povoado povoado;
        Especie especie;
        
        //Lista os alunos no console
        while (rs.next()) {

            personagem.setId(rs.getInt("id"));
            personagem.setAltura(rs.getFloat("altura"));
            personagem.setPeso(rs.getFloat("peso"));
            personagem.setNome(rs.getString("nome"));
            personagem.setIdade(rs.getInt("idade"));
            personagem.setLevel(rs.getInt("lvl"));
            
            povoado = PovoadoDAO.getPovoadoPorId(rs.getInt("id_povoado"));
            
            personagem.setPovoado(povoado);
            
            especie = EspecieDAO.getEspeciePorId(rs.getInt("tbl_especie_id"));
            
            personagem.setEspecie(especie);
                       
        }
        
        conn.close();

        return personagem;
    }
    
    public static int incluirPersonagem(Personagem personagem) throws SQLException, ClassNotFoundException{           
        
        int especie = personagem.getEspecie().getId();
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_personagem (altura, peso,"
                      + "idade, nome, lvl,"
                      + "id_povoado, tbl_especie_id)" +
                      " VALUES ("+ personagem.getAltura()+","
                      + personagem.getPeso()+","
                      + personagem.getIdade()+",'"
                      + personagem.getNome()+"',"
                      + personagem.getLevel()+","
                      + "1,"
                      + especie + ");";
              
              int i = st.executeUpdate(query);
              
        ResultSet rs = st.executeQuery("SELECT MAX(id) AS id FROM tbl_personagem");
        
        int idPersonagem = rs.getInt("id");
        
        conn.close();
        return idPersonagem;
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarPersonagem(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_personagem WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
              conn.close();
          }
    }

    public static void alterarPersonagem(Personagem personagem) throws SQLException, ClassNotFoundException{           
        
        int povoado = personagem.getPovoado().getId();
        int especie = personagem.getEspecie().getId();
        
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_personagem SET "
                      + "id_povoado ="+ povoado
                      + ", altura ="+ personagem.getAltura()
                      + ", idade ="+ personagem.getIdade()
                      + ", peso ="+ personagem.getPeso()
                      + ", nome ='"+ personagem.getNome()
                      + "', lvl ="+ personagem.getLevel()
                      + ", tbl_especie_id ="+ especie 
                      + " WHERE ID =" + personagem.getId() + ";";
                      
              st.executeUpdate(query);
              conn.close();
          }
    }
        
}
