/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nathan
 */
public class CombatePersonagem {
    private int id;
    private AtributoCombate atributoCombate;
    private int valor;
    private Personagem personagem;

    public int getId() {
        return id;
    }
    
        public void setId(int id) {
        this.id = id;
    }


    public CombatePersonagem() {
    }
    
    
    public AtributoCombate getAtributoCombate() {
        return atributoCombate;
    }

    public void setAtributoCombate(AtributoCombate atributoCombate) {
        this.atributoCombate = atributoCombate;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    
    
    
}
