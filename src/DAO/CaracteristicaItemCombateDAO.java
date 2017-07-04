/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AtributoCombate;
import Model.CaracteristicaItemCombate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vitorlofonseca
 */
public class CaracteristicaItemCombateDAO {
    
    
    public static int incluirCaracteristicaItemCombate(CaracteristicaItemCombate caracteristicaItemCombate) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
              
        String query = "INSERT INTO tbl_caracteristica_item_combate (valor, id_atributo_combate, id_item)" +
                "VALUES ('"
                + caracteristicaItemCombate.getValor()
                + caracteristicaItemCombate.getAtributoCombate().getId()
                + caracteristicaItemCombate.getItem().getId() 
                + "');";

        st.executeUpdate(query);

        ResultSet rs = st.executeQuery("SELECT MAX(id) AS id FROM tbl_caracteristica_item_combate");
        
        int idCaracteristicaItemCombate = rs.getInt("id");
        
        conn.close();
        
        return idCaracteristicaItemCombate;
              
    }
    
}
