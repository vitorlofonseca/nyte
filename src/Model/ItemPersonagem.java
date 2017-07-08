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
public class ItemPersonagem {
    private int id;
    private int equipado;
    private Personagem personagem;
    private Item item;
    private int armaReserva;

    public ItemPersonagem() {
    }

    public int getId() {
        return id;
    }
    
        public void setId(int id) {
        this.id = id;
    }


    public int isEquipado() {
        return equipado;
    }

    public void setEquipado(int equipado) {
        this.equipado = equipado;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int isArmaReserva() {
        return armaReserva;
    }

    public void setArmaReserva(int armaReserva) {
        this.armaReserva = armaReserva;
    }
    
    
    
    
}
