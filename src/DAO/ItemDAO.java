/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AreaCorpo;
import Model.Item;
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
    
    public static HashMap getItens() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_item;");

        HashMap areasCorpo = AreaCorpoDAO.getAreasCorpo();
        
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
    
    
    public static Item getItemPorNome(String nome) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_item where nome like '"+nome+"';");
        
        HashMap areasCorpo = AreaCorpoDAO.getAreasCorpo();

        Item item = new Item();
        
        //Lista os alunos no console
        while (rs.next()) {

            item.setId(rs.getInt("id"));
            item.setAreaCorpo((AreaCorpo) areasCorpo.get(rs.getInt("id_area_corpo")));
            item.setNome(rs.getString("nome"));
            item.setValor(rs.getFloat("valor"));
        }
        
        conn.close();

        return item;
    }
    
    
    public static Item getItemPorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_item where ID = '"+id+"';");
        
        HashMap areasCorpo = AreaCorpoDAO.getAreasCorpo();

        Item item = new Item();
        
        //Lista os alunos no console
        while (rs.next()) {

            item.setId(rs.getInt("id"));
            item.setAreaCorpo((AreaCorpo) areasCorpo.get(rs.getInt("id_area_corpo")));
            item.setNome(rs.getString("nome"));
            item.setValor(rs.getFloat("valor"));
        }
        
        conn.close();

        return item;
    }
    
}
