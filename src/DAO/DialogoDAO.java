/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Dialogo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author vitorlofonseca
 */
public class DialogoDAO {
    
    public static HashMap getDialogos() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_dialogo;");
        
        HashMap<Integer,Dialogo> dialogos = new HashMap<Integer,Dialogo>();

        //Lista os alunos no console
        while (rs.next()) {
            
            Dialogo dialogo = new Dialogo();
     
            dialogo.setId(rs.getInt("id"));
            dialogo.setTexto(rs.getString("texto"));
            dialogo.setIdDialogoAnterior(rs.getInt("id_dialogo_anterior"));
            dialogo.setIdProximoDialogo(rs.getInt("id_proximo_dialogo"));
            dialogo.setAdversidade(AdversidadeDAO.getAdversidadePorID(rs.getInt("id_adversidade")));
            
            dialogos.put (rs.getInt("id"), dialogo);
        }
        

        return dialogos;
    }
    
    
    public static Dialogo getDialogoPorID(int id) throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_dialogo where ID = '"+id+"';");

        Dialogo dialogo = new Dialogo();
        
        //Lista os alunos no console
        while (rs.next()) {

            dialogo.setId(rs.getInt("id"));
            dialogo.setTexto(rs.getString("texto"));
            dialogo.setIdDialogoAnterior(rs.getInt("id_dialogo_anterior"));
            dialogo.setIdProximoDialogo(rs.getInt("id_proximo_dialogo"));
            dialogo.setAdversidade(AdversidadeDAO.getAdversidadePorID(rs.getInt("id_adversidade")));
            
        }
        
        

        return dialogo;
    }
    
    public static Dialogo getPrimeiroDialogo() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_dialogo order by id limit 1;");

        Dialogo dialogo = new Dialogo();
        
        //Lista os alunos no console
        while (rs.next()) {

            dialogo.setId(rs.getInt("id"));
            dialogo.setTexto(rs.getString("texto"));
            dialogo.setIdDialogoAnterior(rs.getInt("id_dialogo_anterior"));
            dialogo.setIdProximoDialogo(rs.getInt("id_proximo_dialogo"));
            dialogo.setAdversidade(AdversidadeDAO.getAdversidadePorID(rs.getInt("id_adversidade")));
            
        }

        return dialogo;
    }
    
    public static void incluirDialogo(Dialogo dialogo) throws SQLException, ClassNotFoundException{           
               
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_dialogo (texto, id_dialogo_anterior, id_proximo_dialogo, id_adversidade)" +
                      "VALUES ('"+ dialogo.getTexto() +"','"
                      + dialogo.getIdDialogoAnterior() +","
                      + dialogo.getIdProximoDialogo()+","
                      + dialogo.getAdversidade().getId() + ");";
              
              int i = st.executeUpdate(query);
           
    }
    
}
