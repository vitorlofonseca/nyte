/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AreaCorpo;
import Model.Item;
import Model.Personagem;
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
        
        

        return item;
    }
    
    
    public static Item getCaracteristicasItemCombate(Item item) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select tbl_caracteristica_item_combate.* from tbl_item "
                + "inner join tbl_caracteristica_item_combate on tbl_caracteristica_item_combate.id_item = tbl_item.id "
                + "where tbl_item.id = "+item.getId()+";");

        //Lista os alunos no console
        while (rs.next()) {
            
            switch(rs.getInt("id_atributo_combate")){
                case 1:
                    item.setNegociacao(rs.getInt("valor"));   
                    break;
                case 2:
                    item.setDefesa(rs.getInt("valor"));   
                    break;
                case 3:
                    item.setDano(rs.getInt("valor"));   
                    break;
                case 4:
                    item.setFuga(rs.getInt("valor"));   
                    break;
            } 
            
        }
            
        

        return item;
    }
    
    
    
    public static HashMap getItensPorArea(AreaCorpo areaCorpo) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_item where id_area_corpo = "+areaCorpo.getId()+";");
        
        HashMap<Integer,Item> itens = new HashMap<Integer,Item>();

        //Lista os alunos no console
        while (rs.next()) {
            
            Item itemTemp = new Item();

            itemTemp.setId(rs.getInt("id"));
            itemTemp.setAreaCorpo(areaCorpo);
            itemTemp.setNome(rs.getString("nome"));
            itemTemp.setValor(rs.getFloat("valor"));
            
            itens.put (rs.getInt("id"), itemTemp);
        }
        

        return itens;
    }
    
    
}
