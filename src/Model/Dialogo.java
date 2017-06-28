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
public class Dialogo {

    public Dialogo() {
    }
    
    
        public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String texto;
    private Dialogo dialogoAnterior;
    private Dialogo proximoDialogo;
    private Adversidade adversidade;

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Dialogo getDialogoAnterior() {
        return dialogoAnterior;
    }

    public void setDialogoAnterior(Dialogo dialogoAnterior) {
        this.dialogoAnterior = dialogoAnterior;
    }

    public Dialogo getProximoDialogo() {
        return proximoDialogo;
    }

    public void setProximoDialogo(Dialogo proximoDialogo) {
        this.proximoDialogo = proximoDialogo;
    }

    public Adversidade getAdversidade() {
        return adversidade;
    }

    public void setAdversidade(Adversidade adversidade) {
        this.adversidade = adversidade;
    }
    
    
    
}
