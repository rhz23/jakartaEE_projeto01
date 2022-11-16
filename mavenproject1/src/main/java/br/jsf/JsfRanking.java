/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.model.Jogador;
import br.ejb.EjbRanking;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author default
 */
@Named(value = "jsfRanking")
@RequestScoped
public class JsfRanking {

    @EJB
    private EjbRanking ejbRanking;

    /**
     * Creates a new instance of JsfRanking
     */
    public JsfRanking() {
    }
    
    public ArrayList<Jogador> getRanking(){
        return ejbRanking.getRanking();
    }
}
