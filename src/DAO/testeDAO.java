/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Personagem;
import Model.Especie;
import Model.Jogador;
import Model.Povoado;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author vitorlofonseca
 */
public class testeDAO {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        
        Personagem personagem = PersonagemDAO.getPersonagemPorID(2);
        
        Jogador jogador = new Jogador();
        
        jogador.setNome("Player Teste");
        jogador.setPersonagem(personagem);
        
        JogadorDAO.incluirJogador(jogador);
        
    }
}
