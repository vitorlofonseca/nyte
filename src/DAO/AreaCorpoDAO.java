/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AreaCorpo;
import com.sun.javafx.collections.MappingChange.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author vitorlofonseca
 */
public class AreaCorpoDAO {
    
    public static AreaCorpo getAreaCorpo(int id) throws SQLException, ClassNotFoundException{
        
        Connection conn = Connect.conectar();
        
        AreaCorpo areaCorpo = new AreaCorpo();
 
        //Executa a query de seleção
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_area_corpo where id="+id);

        //Lista os alunos no console
        while (rs.next()) {
            areaCorpo.setId(rs.getInt("Id"));
            areaCorpo.setAreaCorpo(rs.getString("area_corpo"));
        }
        
        return areaCorpo;
    }
    
    public static HashMap getAreasCorpo() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_area_corpo");

        HashMap<Integer,AreaCorpo> areasCorpo = new HashMap<Integer,AreaCorpo>();

        //Lista os alunos no console
        while (rs.next()) {
            
            AreaCorpo areaCorpoTemp = new AreaCorpo();
            areaCorpoTemp.setAreaCorpo(rs.getString("area_corpo"));
            areaCorpoTemp.setId(rs.getInt("id"));
            
            areasCorpo.put(rs.getInt("id"), areaCorpoTemp);
        }

        return areasCorpo;
    }
    
}
