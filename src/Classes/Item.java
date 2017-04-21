/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author vitorlofonseca
 */
public class Item {
    
    private int id;
    private String nome;
    private float valor;
    private AreaCorpo areaCorpo;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public AreaCorpo getAreaCorpo() {
        return areaCorpo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setAreaCorpo(AreaCorpo areaCorpo) {
        this.areaCorpo = areaCorpo;
    }
        
    
}
