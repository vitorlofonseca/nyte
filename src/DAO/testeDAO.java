/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CaracteristicaItemCombate;
import Model.Personagem;
import Model.Especie;
import Model.Item;
import Model.Jogador;
import Model.Povoado;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author vitorlofonseca
 */
public class testeDAO {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
                
        Random rand = new Random();
        
        for(int i=0 ; i<240 ; i++){
            
            boolean bMaisUm = false;
            
            for(int j=0 ; j<4 ; j++){
                
                Item item = ItemDAO.getItemPorID(i+1);
                
                int valor = (int) Math.floor((item.getValor()/100)-rand.nextInt(5 - 0 + 1) + 0);
                
                if(valor < 0) valor = 0;
                
                if(j==3 && !bMaisUm){
                    valor = 1;
                }
                
                System.out.println(valor);
                
                CaracteristicaItemCombate caracteristica = new CaracteristicaItemCombate();
                caracteristica.setAtributoCombate(AtributoCombateDAO.getAtributoCombatePorID(j+1));
                caracteristica.setItem(item);
                caracteristica.setValor(valor);
                
                CaracteristicaItemCombateDAO.incluirCaracteristicaItemCombate(caracteristica);
                
                if(valor > 1){
                    bMaisUm = true;
                }
                
            }
            
        }
        
    }
}
