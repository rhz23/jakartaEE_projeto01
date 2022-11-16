/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.data.crud.CrudJogador;
import br.data.crud.Jogada;
import br.data.model.Jogador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author default
 */
@Stateful
public class EjbPartida {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private boolean partidaIniciada;
    private Jogador jogadorPartida;
    private boolean partidaFinalizada;
    private Jogada jogadaAtual;
    private CrudJogador crudJogador = CrudJogador.getCrudJogadorUnico();
    private ArrayList<Jogador> rankingInicial;

    
    public void addJogador (String nomeJogador){
        jogadorPartida = new Jogador(nomeJogador, 0);
        partidaIniciada = true;
    }
    
    public boolean verificaPartidaIniciada(){
        return partidaIniciada;
    }
    
    public boolean verificaPartidaFinalizada(){
        return partidaFinalizada;
    }
    
    public Jogada novaJogada(){
        jogadaAtual = new Jogada();
        return jogadaAtual;
    }
    
    public Jogada confereJogada(int valor){
        
        if (jogadaAtual.confereJogada(valor) == true){
            jogadorPartida.setPontos(jogadorPartida.getPontos() + 1);
            return novaJogada();
        } else {
            partidaFinalizada = true;
            crudJogador.addJogador(jogadorPartida);
            if (confereSeNovoGanhador(jogadorPartida))
                send();
            return jogadaAtual;
        }
    }
    
    public Jogada getJogada(){
        if (jogadaAtual == null)
            return novaJogada();
        else
            return jogadaAtual;
    }
    
    public Jogador getJogador(){
        return jogadorPartida;
    }
    
    public void iniciaNovaPartida(){
        partidaIniciada = false;
        partidaFinalizada = false;
        rankingInicial = getRankingOrdenado();
        
    }
    
    @Resource(lookup="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup="java/Topico")
    private Topic topico;
    
    public void send(){
        try{
            JMSContext context = connectionFactory.createContext();
            context.createProducer().send(topico, rankingString(getRankingOrdenado()));          
        } catch(Exception e){
            System.out.println("ERRO");
            System.out.println(e.getMessage());
        }        
    }
    
    private ArrayList<Jogador> getRankingOrdenado(){
        ArrayList<Jogador> rankingOrdenado = crudJogador.getAll();
        Collections.sort(rankingOrdenado);
        return rankingOrdenado;
    }
    
    private boolean confereSeNovoGanhador(Jogador jogador){
        if(rankingInicial == null){
            return true;
        }
        else{
            int pontosPrimeiroColocado = rankingInicial.get(0).getPontos();
            if (jogador.getPontos() > pontosPrimeiroColocado) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    private String rankingString(ArrayList<Jogador> array){
        String mensagem = Arrays.asList(array).stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
        return mensagem;
    }
    
}
