/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AtributoCombate;
import Model.AtributoEspecializacaoCombate;
import Model.AtributoEspecilizacao;
import Model.Personagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nathan
 */
public class AtributoEspecializacaoCombateDAO {
    
    
        public static AtributoEspecializacaoCombate getAtributoEspecializacaoCombatePorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_atributo_especializacao_combate where id like '"+id+"';");
       
        AtributoEspecializacaoCombate atributoEspecializacaoCombate = new AtributoEspecializacaoCombate();
        
        Personagem personagem;
        AtributoCombate atributoCombate;
        AtributoEspecilizacao atributoEspecializacao;
        
        //Lista os alunos no console
        while (rs.next()) {

            atributoEspecializacaoCombate.setId(rs.getInt("id"));
            atributoEspecializacaoCombate.setValorMelhoria(rs.getInt("valor_melhoria"));
            
            personagem = PersonagemDAO.getPersonagemPorID(rs.getInt("id_personagem"));
            atributoEspecializacaoCombate.setPersonagem(personagem);
                       
            atributoCombate = AtributoCombateDAO.getAtributoCombatePorID(rs.getInt("id_atributo_combate"));
            atributoEspecializacaoCombate.setAtributoCombate(atributoCombate);

            atributoEspecializacao = AtributoEspecilizacaoDAO.getAtributoEspecilizacaoPorID(rs.getInt("id_atributo_especializacao"));
            atributoEspecializacaoCombate.setAtributoEspecializacao(atributoEspecializacao);
            
        }
        
        conn.close();

        return atributoEspecializacaoCombate;
    }
    
    public static void incluirAtributoEspecializacaoCombate(AtributoEspecializacaoCombate atributoEspecializacaoCombate) throws SQLException, ClassNotFoundException{           
        
        int personagem = atributoEspecializacaoCombate.getPersonagem().getId();
        int atributoEspecializacao = atributoEspecializacaoCombate.getAtributoEspecializacao().getId();
        int atributoCombate = atributoEspecializacaoCombate.getAtributoCombate().getId();
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_atributo_especializacao_combate (valor_melhoria, id_personagem, id_atributo_combate, id_atributo_especializacao)" +
                      "VALUES ("+ atributoEspecializacaoCombate.getValorMelhoria()+","
                      + personagem+","
                      +atributoCombate+","
                      +atributoEspecializacao+");";
              
              int i = st.executeUpdate(query);
              
              conn.close();
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarAtributoEspecializacaoCombate(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_atributo_especializacao_combate WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
          }
    }

    public static void alterarAtributoEspecializacaoCombate(AtributoEspecializacaoCombate atributoEspecializacaoCombate) throws SQLException, ClassNotFoundException{           
        
        int personagem = atributoEspecializacaoCombate.getPersonagem().getId();
        int atributoEspecializacao = atributoEspecializacaoCombate.getAtributoEspecializacao().getId();
        int atributoCombate = atributoEspecializacaoCombate.getAtributoCombate().getId();
                
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_atributo_especializacao_combate SET "
                      + "id_personagem ="+ personagem
                      + ", id_atributo_combate ="+ atributoCombate
                      + ", valor_melhoria ="+ atributoEspecializacaoCombate.getValorMelhoria()
                      + ", id_atributo_especializacao ="+ atributoEspecializacao
                      + " WHERE ID =" + atributoEspecializacaoCombate.getId() + ";";
                      
              st.executeUpdate(query);
              
              conn.close();
            }
    }
}
