/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.crud;

import br.data.model.Jogador;
import java.util.ArrayList;

/**
 *
 * @author default
 */
public class CrudJogador {
    
    private static CrudJogador crudJogadorUnico;
    
    private ArrayList<Jogador> jogadores;
    
    private CrudJogador(){
        jogadores = new ArrayList<>();
    }
    
    public static CrudJogador getCrudJogadorUnico(){
        if (crudJogadorUnico == null){
            crudJogadorUnico = new CrudJogador();
        }
        return crudJogadorUnico;
    }
    
    
    public ArrayList<Jogador> getAll(){
        return jogadores;
    }
    
    public void addJogador(Jogador jogador){
        jogadores.add(jogador);
    }
    
}
