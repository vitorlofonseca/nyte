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
public class AtributoEspecializacaoCombate {
    
    private int id;
    private int valorMelhoria;
    private AtributoEspecilizacao atributoEspecializacao;
    private Personagem personagem;

    public int getId() {
        return id;
    }
    
        public void setId(int id) {
        this.id = id;
    }


    public AtributoEspecializacaoCombate() {
    }
    
    
    public int getValorMelhoria() {
        return valorMelhoria;
    }

    public void setValorMelhoria(int valorMelhoria) {
        this.valorMelhoria = valorMelhoria;
    }

    public AtributoEspecilizacao getAtributoEspecializacao() {
        return atributoEspecializacao;
    }

    public void setAtributoEspecializacao(AtributoEspecilizacao atributoEspecializacao) {
        this.atributoEspecializacao = atributoEspecializacao;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    
    
    
    
}
