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
    private boolean equipado;
    private Personagem personagem;
    private Item item;
    private boolean armaReserva;

    public ItemPersonagem() {
    }

    public int getId() {
        return id;
    }
    
        public void setId(int id) {
        this.id = id;
    }


    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
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

    public boolean isArmaReserva() {
        return armaReserva;
    }

    public void setArmaReserva(boolean armaReserva) {
        this.armaReserva = armaReserva;
    }
    
    
    
    
}
