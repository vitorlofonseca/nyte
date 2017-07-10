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
    private int idDialogoAnterior;
    private int idProximoDialogo;
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

    public int getIdDialogoAnterior() {
        return idDialogoAnterior;
    }

    public void setIdDialogoAnterior(int idDialogoAnterior) {
        this.idDialogoAnterior = idDialogoAnterior;
    }

    public int getIdProximoDialogo() {
        return idProximoDialogo;
    }

    public void setIdProximoDialogo(int idProximoDialogo) {
        this.idProximoDialogo = idProximoDialogo;
    }

    public Adversidade getAdversidade() {
        return adversidade;
    }

    public void setAdversidade(Adversidade adversidade) {
        this.adversidade = adversidade;
    }
    
    
    
}
