/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CombatePersonagem;
import Model.Personagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author vitorlofonseca
 */
public class CombatePersonagemDAO {
    
    public static void incluirCombatePersonagem(CombatePersonagem combatePersonagem) throws SQLException, ClassNotFoundException{           
        
        int personagem = combatePersonagem.getPersonagem().getId();
        int atributoCombate = combatePersonagem.getAtributoCombate().getId();
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
        String query = "INSERT INTO tbl_combate_personagem (valor, id_personagem, id_atributo_combate)" +
                "VALUES ("+ combatePersonagem.getValor()+","
                + personagem+","
                +atributoCombate+");";

        int i = st.executeUpdate(query);

        
           
    }
    
    
    public static HashMap getCombatePersonagem(Personagem personagem) throws SQLException, ClassNotFoundException{           

        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_combate_personagem where id_personagem = "+personagem.getId()+";");

        HashMap<Integer,CombatePersonagem> combatesPersonagem = new HashMap<Integer,CombatePersonagem>();

        //Lista os alunos no console
        while (rs.next()) {
            
            CombatePersonagem combatePersonagem = new CombatePersonagem();
            
            combatePersonagem.setId(rs.getInt("id"));
            combatePersonagem.setPersonagem(personagem);
            combatePersonagem.setValor(rs.getInt("valor"));
            combatePersonagem.setAtributoCombate(AtributoCombateDAO.getAtributoCombatePorID(rs.getInt("id_atributo_combate")));
            
            combatesPersonagem.put(rs.getInt("id"), combatePersonagem);
        }

        return combatesPersonagem;
           
    }
    
    
}
