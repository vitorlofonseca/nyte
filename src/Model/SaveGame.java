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
public class SaveGame {

    public SaveGame() {
    }
    
    public int id;
    public Dialogo dialogoCheckpoint;
    public String nome;
    public Jogador jogador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dialogo getDialogoCheckpoint() {
        return dialogoCheckpoint;
    }

    public void setDialogoCheckpoint(Dialogo dialogoCheckpoint) {
        this.dialogoCheckpoint = dialogoCheckpoint;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
    
    
}
