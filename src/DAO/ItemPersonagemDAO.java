/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AreaCorpo;
import Model.Item;
import Model.ItemPersonagem;
import Model.Personagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class ItemPersonagemDAO {
    
    public static ItemPersonagem getItemPersonagemPorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_item_personagem where id like '"+id+"';");
       
        ItemPersonagem itemPersonagem = new ItemPersonagem();
        
        Personagem personagem;
        Item item;
        
        //Lista os alunos no console
        while (rs.next()) {

            itemPersonagem.setId(rs.getInt("id"));
            itemPersonagem.setEquipado(rs.getInt("equipado"));
            itemPersonagem.setArmaReserva(rs.getInt("arma_reserva"));
            
            personagem = PersonagemDAO.getPersonagemPorID(rs.getInt("id_personagem"));
            itemPersonagem.setPersonagem(personagem);
                       
            item = ItemDAO.getItemPorID(rs.getInt("id_item"));
            itemPersonagem.setItem(item);

        }
        
        conn.close();

        return itemPersonagem;
    }
    
    public static void incluirItemPersonagem(ItemPersonagem itemPersonagem) throws SQLException, ClassNotFoundException{           
        
        int personagem = itemPersonagem.getPersonagem().getId();
        int item = itemPersonagem.getItem().getId();
        
        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_item_personagem (equipado, arma_reserva, id_personagem, id_item)" +
                      "VALUES ("+ itemPersonagem.isEquipado()+","
                      + itemPersonagem.isArmaReserva()+","
                      +personagem+","
                      +item+");";
              
              int i = st.executeUpdate(query);
              
              conn.close();
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarItemPersonagem(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_item_personagem WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
          }
    }

    public static void alterarItemPersonagem(ItemPersonagem itemPersonagem) throws SQLException, ClassNotFoundException{           
        
        int personagem = itemPersonagem.getPersonagem().getId();
        int item = itemPersonagem.getItem().getId();
        
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_item_personagem SET "
                      + "id_personagem ="+ personagem
                      + ", id_item ="+ item
                      + ", equipado ="+ itemPersonagem.isEquipado()
                      + ", arma_reserva ="+ itemPersonagem.isArmaReserva()
                      + " WHERE ID =" + itemPersonagem.getId() + ";";
                      
              st.executeUpdate(query);
              
              conn.close();
          }
    }
    
    public static HashMap getItensPorPersonagemEArea(Personagem personagem, AreaCorpo areaCorpo) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from tbl_item_personagem "
                + "inner join tbl_item on tbl_item.id = tbl_item_personagem.id_item "
                + "where tbl_item_personagem.id_personagem = "+personagem.getId()+" AND tbl_item.id_area_corpo = "+areaCorpo.getId()+";");
        
        HashMap<Integer,ItemPersonagem> itensPersonagem = new HashMap<Integer,ItemPersonagem>();

        //Lista os alunos no console
        while (rs.next()) {
            
            ItemPersonagem itemTemp = new ItemPersonagem();

            itemTemp.setId(rs.getInt("id"));
            itemTemp.setEquipado(rs.getInt("equipado"));
            itemTemp.setArmaReserva(rs.getInt("arma_reserva"));
            itemTemp.setPersonagem(personagem);
            itemTemp.setItem(ItemDAO.getItemPorID(rs.getInt("id_item")));
            
            itensPersonagem.put (rs.getInt("id"), itemTemp);
        }

        return itensPersonagem;
    }
    
    
    public static ItemPersonagem getItemPorPersonagemEItem(Personagem personagem, Item item) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from tbl_item_personagem "
                + "inner join tbl_item on tbl_item.id = tbl_item_personagem.id_item "
                + "where tbl_item_personagem.id_personagem = "+personagem.getId()+" AND tbl_item.id = "+item.getId()+";");
        
        ItemPersonagem itemPersonagem = new ItemPersonagem();
        
        //Lista os alunos no console
        while (rs.next()) {

            itemPersonagem.setId(rs.getInt("id"));
            itemPersonagem.setEquipado(rs.getInt("equipado"));
            itemPersonagem.setArmaReserva(rs.getInt("arma_reserva"));
            
            personagem = PersonagemDAO.getPersonagemPorID(rs.getInt("id_personagem"));
            itemPersonagem.setPersonagem(personagem);
                       
            item = ItemDAO.getItemPorID(rs.getInt("id_item"));
            itemPersonagem.setItem(item);

        }
        
        conn.close();

        return itemPersonagem;
    }
    
    
    
    public static HashMap getItensPersonagemJoinCaracteristicasItemCombate(Personagem personagem) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from tbl_item_personagem "
                + "inner join tbl_caracteristica_item_combate on tbl_caracteristica_item_combate.id_item = tbl_item_personagem.id_item "
                + "where tbl_item_personagem.id_personagem = "+personagem.getId()+";");
        
        HashMap<Integer,ItemPersonagem> itensPersonagem = new HashMap<Integer,ItemPersonagem>();

        //Lista os alunos no console
        while (rs.next()) {
            
            ItemPersonagem itemTemp = new ItemPersonagem();

            itemTemp.setId(rs.getInt("id"));
            itemTemp.setEquipado(rs.getInt("equipado"));            
            itemTemp.setArmaReserva(rs.getInt("arma_reserva"));
            itemTemp.setPersonagem(personagem);
            
            Item item = ItemDAO.getItemPorID(rs.getInt("id_item"));
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
            
            itemTemp.setItem(item);
            
            itensPersonagem.put (rs.getInt("id"), itemTemp);
        }
            
        //System.out.println(itensPersonagem.get(1).isEquipado());

        return itensPersonagem;
    }
    
}
