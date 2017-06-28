/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Item;
import Model.ItemPersonagem;
import Model.Personagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            itemPersonagem.setEquipado(rs.getBoolean("equipado"));
            itemPersonagem.setArmaReserva(rs.getBoolean("arma_reserva"));
            
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
}
