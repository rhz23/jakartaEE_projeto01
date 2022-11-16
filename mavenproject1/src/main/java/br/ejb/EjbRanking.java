/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.crud.CrudJogador;
import br.data.model.Jogador;
import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.Stateless;

/**
 *
 * @author default
 */
@Stateless
public class EjbRanking {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private CrudJogador crudJogador = CrudJogador.getCrudJogadorUnico();
    
    public ArrayList<Jogador> getRanking(){
        ArrayList<Jogador> ranking = crudJogador.getAll();
        Collections.sort(ranking);
        return ranking;
    }
}
