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
public class AtributoEspecilizacao {
     private int id;
    private String atributo;

    public AtributoEspecilizacao() {
    }
    
        public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
}
