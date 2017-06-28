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
public class Povoado {
    private String nome;
    private int id;

    public Povoado() {
    }
    
        public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
