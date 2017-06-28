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
public class Jogador {

    public Jogador() {
    }
 
    public int id;
    public Personagem personagem;
    public String nome;

    public int getId() {
        return id;
    }

        public void setId(int id) {
        this.id = id;
    }


    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
