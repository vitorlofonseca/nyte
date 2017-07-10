/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AtributoEspecilizacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class AtributoEspecilizacaoDAO {
    
      public static AtributoEspecilizacao getAtributoEspecilizacaoPorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_atributo_especializacao where id like '"+id+"';");
       
        AtributoEspecilizacao atributoEspecilizacao = new AtributoEspecilizacao();
        
        
        //Lista os alunos no console
        while (rs.next()) {

            atributoEspecilizacao.setId(rs.getInt("id"));
            atributoEspecilizacao.setAtributo(rs.getString("atributo"));
                      
        }
        
        

        return atributoEspecilizacao;
    }
    
    public static void incluirAtributoEspecilizacao(AtributoEspecilizacao atributoEspecilizacao) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
              
        String query = "INSERT INTO tbl_atributo_especializacao (atributo)" +
                "VALUES ('"+ atributoEspecilizacao.getAtributo()+"');";

        int i = st.executeUpdate(query);
        
        
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarAtributoEspecilizacao(int id) throws SQLException, ClassNotFoundException{           
        
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_atributo_especializacao WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
              
              
          }
    }

    public static void alterarAtributoEspecilizacao(AtributoEspecilizacao atributoEspecilizacao) throws SQLException, ClassNotFoundException{           
        
        try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_atributo_especializacao SET "
                      + " atributo ='"+ atributoEspecilizacao.getAtributo()
                      + "' WHERE ID =" + atributoEspecilizacao.getId() + ";";
                      
              st.executeUpdate(query);
              
              
          }
    }
    
    
    public static HashMap getAtributoEspecializacoes() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_atributo_especializacao;");
        
        HashMap<Integer,AtributoEspecilizacao> atributoEspecializacoes = new HashMap<Integer,AtributoEspecilizacao>();

        //Lista os alunos no console
        while (rs.next()) {
            
            AtributoEspecilizacao atributoEspecializacao = new AtributoEspecilizacao();

            atributoEspecializacao.setId(rs.getInt("id"));
            atributoEspecializacao.setAtributo(rs.getString("atributo"));
            
            atributoEspecializacoes.put (rs.getInt("id"), atributoEspecializacao);
        }
        
        

        return atributoEspecializacoes;
    }
     
    
}
