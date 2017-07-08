/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vitorlofonseca
 */
public class Item {
    
    private int id;
    private String nome;
    private float valor;
    private AreaCorpo areaCorpo;
    private int dano;
    private int defesa;
    private int fuga;
    private int negociacao;

    public Item() {
    }
    
    

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

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getFuga() {
        return fuga;
    }

    public void setFuga(int fuga) {
        this.fuga = fuga;
    }

    public int getNegociacao() {
        return negociacao;
    }

    public void setNegociacao(int negociacao) {
        this.negociacao = negociacao;
    }
        
    
    
}
