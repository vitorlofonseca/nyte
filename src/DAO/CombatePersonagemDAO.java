/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CombatePersonagem;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    
}
