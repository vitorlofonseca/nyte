/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.AreaCorpo;
import Classes.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author vitorlofonseca
 */
public class ItemDAO {
    
    public static HashMap getItens(Connection conn) throws SQLException, ClassNotFoundException{           
        
        java.sql.Statement st = conn.createStatement();
        st.executeQuery("select * from tbl_item");
        ResultSet rs = st.getResultSet();

        HashMap areasCorpo = AreaCorpoDAO.getAreasCorpo(conn);
        
        HashMap<Integer,Item> itens = new HashMap<Integer,Item>();

        //Lista os alunos no console
        while (rs.next()) {
            
            Item itemTemp = new Item();

            itemTemp.setId(rs.getInt("id"));
            itemTemp.setAreaCorpo((AreaCorpo) areasCorpo.get(rs.getInt("id_area_corpo")));
            itemTemp.setNome(rs.getString("nome"));
            itemTemp.setValor(rs.getFloat("valor"));
            
            itens.put (rs.getInt("id"), itemTemp);
        }

        return itens;
    }
    
}
