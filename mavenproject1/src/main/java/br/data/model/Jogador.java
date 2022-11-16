/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.model;

import lombok.Data;

/**
 *
 * @author default
 */

@Data
public class Jogador implements Comparable<Jogador>{
    
    private String nome;
    private int pontos;

    public Jogador() {
    }

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    @Override
    public int compareTo(Jogador outroJogador) {
        if(this.pontos > outroJogador.pontos)
            return -1;
        if(this.pontos < outroJogador.pontos)
            return 1;
        return 0;
    }
    
    @Override
    public String toString(){
        return "Jogador{" + "Nome: " + nome + ", Pontos: " + pontos + "}";
    }
    
}
