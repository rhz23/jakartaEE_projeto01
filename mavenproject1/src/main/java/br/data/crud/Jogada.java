/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.crud;

import java.util.Random;
import lombok.Data;

/**
 *
 * @author default
 */

@Data
public class Jogada {
    
    Random random = new Random();
    
    private int numeroUm;
    private int numeroDois;

    public Jogada() {
        this.numeroUm = novoNumero();
        this.numeroDois = novoNumero();
    }
    
    public boolean confereJogada(int valor){
        int total = numeroUm + numeroDois;
        if (valor == total)
            return true;
        else
            return false;
    }
    
    private int novoNumero(){
        return random.nextInt(100);
    } 
}
