/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Dialogo;
import Model.Jogador;
import Model.Personagem;
import Model.SaveGame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class SalvarDAO {
    
    
    public static HashMap getSaves() throws SQLException, ClassNotFoundException{           
        
        Connection conn = Connect.conectar();
        
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_save_game;");
        
        HashMap<Integer,SaveGame> saveGames = new HashMap<Integer,SaveGame>();
        
        Dialogo dialogo;
        Jogador jogador;

        //Lista os alunos no console
        while (rs.next()) {
            
            SaveGame saveGame = new SaveGame();

            saveGame.setId(rs.getInt("id"));
            saveGame.setNome(rs.getString("nome"));
                        
            dialogo = DialogoDAO.getDialogoPorID(rs.getInt("id_dialogo_checkpoINTEGER"));
            
            saveGame.setDialogoCheckpoint(dialogo);
            
            jogador = JogadorDAO.getJogadorPorID(rs.getInt("id_jogador"));
            
            saveGame.setJogador(jogador);  
           
            saveGames.put (rs.getInt("id"), saveGame);
        }

        return saveGames;
    }
    
       
    public static SaveGame getSaveGamePorId(int id) throws SQLException, ClassNotFoundException{
        
        Connection conn = Connect.conectar();
        
        SaveGame saveGame = new SaveGame();
 
        //Executa a query de seleção
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_save_game where id="+id);
        
        Dialogo dialogo;
        Jogador jogador;

        //Lista os alunos no console
        while (rs.next()) {
            saveGame.setId(rs.getInt("id"));
            saveGame.setNome(rs.getString("nome"));
            
            dialogo = DialogoDAO.getDialogoPorID(rs.getInt("id_dialogo_checkpoint"));
            
            saveGame.setDialogoCheckpoint(dialogo);
            
            jogador = JogadorDAO.getJogadorPorID(rs.getInt("id_jogador"));
            
            saveGame.setJogador(jogador);  
           
        }
        
        return saveGame;
    }    
    
    
    public static SaveGame getSaveGamePorNome(String saveGameString) throws SQLException, ClassNotFoundException{
        
        Connection conn = Connect.conectar();
        
        SaveGame saveGame = new SaveGame();
 
        //Executa a query de seleção
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_save_game where nome like '"+saveGameString+"';");

        Dialogo dialogo;
        Jogador jogador;

        
        //Lista os alunos no console
        while (rs.next()) {
            saveGame.setId(rs.getInt("id"));
            saveGame.setNome(rs.getString("nome"));
            
            dialogo = DialogoDAO.getDialogoPorID(rs.getInt("id_dialogo_checkpoINTEGER"));
            
            saveGame.setDialogoCheckpoint(dialogo);
            
            jogador = JogadorDAO.getJogadorPorID(rs.getInt("id_jogador"));
            
            saveGame.setJogador(jogador);
            
        }
        
        return saveGame;
    }

 public static int incluirSaveGame(SaveGame saveGame) throws SQLException, ClassNotFoundException{           
        
        int jogador = saveGame.getJogador().getId();
        int dialogo = saveGame.getDialogoCheckpoint().getId();

        
        Connection conn = Connect.conectar();
        Statement st = conn.createStatement();
        
              
              String query = "INSERT INTO tbl_save_game (nome,"
                      + "id_dialogo_checkpoINTEGER, id_jogador)" +
                      " VALUES ('"
                      + saveGame.getNome()+"',"
                      + dialogo + ","
                      + jogador + ");";
              
              int i = st.executeUpdate(query);
              
        ResultSet rs = st.executeQuery("SELECT MAX(id) AS id FROM tbl_save_game");
        
        int idSave = rs.getInt("id");
        
        
        return idSave;
           
    }
         
          //personagem = PersonagemDAO.getPersonagemPorID(personagem.getId());
          //return personagem;
    
    public static void deletarPersonagem(int id) throws SQLException, ClassNotFoundException{           
        
               
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "DELETE FROM tbl_save_game WHERE ID = "+id+";";
                                   
              int i = st.executeUpdate(query);
              
          }
    }

    public static void alterarSaveGame(SaveGame saveGame) throws SQLException, ClassNotFoundException{           
                
        int jogador = saveGame.getJogador().getId();
        int dialogo = saveGame.getDialogoCheckpoint().getId();
        
          try (Connection conn = Connect.conectar()) {
              java.sql.Statement st = conn.createStatement();
              
              String query = "UPDATE tbl_personagem SET "
                      + "id_dialogo_checkpoint ="+ dialogo
                      + ", id_jogador ="+ jogador
                      + ", nome = '"+ saveGame.getNome()
                      + "' WHERE ID =" + saveGame.getId() + ";";
                      
              st.executeUpdate(query);
              
          }
    }    

}
