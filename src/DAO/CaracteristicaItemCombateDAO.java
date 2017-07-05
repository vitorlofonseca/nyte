/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CaracteristicaItemCombate;
import Model.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author vitorlofonseca
 */
public class CaracteristicaItemCombateDAO {
    
    
    public static int incluirCaracteristicaItemCombate(CaracteristicaItemCombate caracteristicaItemCombate) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
              
        String query = "INSERT INTO tbl_caracteristica_item_combate (valor, id_atributo_combate, id_item)" +
                "VALUES ("
                + caracteristicaItemCombate.getValor() +", "
                + caracteristicaItemCombate.getAtributoCombate().getId() +", "
                + caracteristicaItemCombate.getItem().getId() 
                + ");";

        st.executeUpdate(query);

        ResultSet rs = st.executeQuery("SELECT MAX(id) AS id FROM tbl_caracteristica_item_combate");
        
        int idCaracteristicaItemCombate = rs.getInt("id");
        
        conn.close();
        
        return idCaracteristicaItemCombate;
              
    }
    
    
    public static HashMap getCaracteristicasItemCombatePorItem(Item item) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_caracteristica_item_combate where id_item = "+item.getId()+";");

        HashMap<Integer,CaracteristicaItemCombate> caracteristicasItemCombate = new HashMap<Integer,CaracteristicaItemCombate>();

        //Lista os alunos no console
        while (rs.next()) {
            
            CaracteristicaItemCombate caracteristicaItemCombate = new CaracteristicaItemCombate();
            caracteristicaItemCombate.setValor(Integer.parseInt(rs.getString("valor")));
            caracteristicaItemCombate.setItem(ItemDAO.getItemPorID(Integer.parseInt(rs.getString("id_item"))));
            caracteristicaItemCombate.setAtributoCombate(AtributoCombateDAO.getAtributoCombatePorID(Integer.parseInt(rs.getString("id_atributo_combate"))));
            
            //o id do item é a chave do map pra ficar mais fácil pra pegar 
            caracteristicasItemCombate.put(rs.getInt("id_atributo_combate"), caracteristicaItemCombate);
        }

        return caracteristicasItemCombate;
    }
    
    
    
}
