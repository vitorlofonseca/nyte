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
public class CaracteristicaItemCombate {
    private int id;
    private int valor;
    private AtributoCombate atributoCombate;
    private Item item;

    public CaracteristicaItemCombate() {
    }
    
        public void setId(int id) {
        this.id = id;
    }

    
    
    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public AtributoCombate getAtributoCombate() {
        return atributoCombate;
    }

    public void setAtributoCombate(AtributoCombate atributoCombate) {
        this.atributoCombate = atributoCombate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    
}
