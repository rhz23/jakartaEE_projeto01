/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.crud.Jogada;
import br.data.model.Jogador;
import br.ejb.EjbPartida;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import lombok.Data;

/**
 *
 * @author default
 */
@Named(value = "jsfPartida")
@Data
@SessionScoped
public class JsfPartida implements Serializable{

    @EJB
    private EjbPartida ejbPartida;

    /**
     * Creates a new instance of JsfPartida
     */
    
    private String nomeJogador;
    private int pontosJogador;
    private int valor;
    private boolean partidaIniciada;
    private boolean partidaFinalizada;
    
    public JsfPartida() {
    }
    
    public void verificaPartidaIniciada(){
        partidaIniciada = ejbPartida.verificaPartidaIniciada();
    }
    
    public void verificaPartidaFinalizada(){
        partidaFinalizada = ejbPartida.verificaPartidaFinalizada();
    }
    
    public Jogador getJogador(){
        return ejbPartida.getJogador();
    }
    
   public Jogada getJogada(){
       return ejbPartida.getJogada();
   }
   
   public void verificaJogada(){
       ejbPartida.confereJogada(valor);
       pontosJogador = ejbPartida.getJogador().getPontos();
       atualizaStatusPartida();
   }
   
   public void setJogador(){
       ejbPartida.addJogador(nomeJogador);
       atualizaStatusPartida();
   }
   
   public void iniciarNovaPartida(){
       ejbPartida.iniciaNovaPartida();
       atualizaStatusPartida();
   }
   
   private void atualizaStatusPartida(){
       partidaIniciada = ejbPartida.verificaPartidaIniciada();
       partidaFinalizada = ejbPartida.verificaPartidaFinalizada();
   }
    
    
}
