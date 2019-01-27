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
public class Personagem {
    
    private int id;
    private String nome;
    private float altura;
    private float peso;
    private Povoado povoado;
    private Especie especie;
    private int idade;
    private int level;
    private float dinheiro;
    
    public String ToString(){
        String text = "";
        text += this.getNome();
        
        return text;
    }

    public Personagem() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public int getId() {
        return id;
    }

    public Povoado getPovoado() {
        return povoado;
    }

    public void setPovoado(Povoado povoado) {
        this.povoado = povoado;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
   public float getDinheiro() {
        return this.dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }
    
}
