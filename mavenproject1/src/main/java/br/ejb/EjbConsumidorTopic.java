/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author default
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName="destinationLookup",
            propertyValue="java/Topico"),
    @ActivationConfigProperty(propertyName="destinationType",
            propertyValue="javax.jms.Topic")
})
public class EjbConsumidorTopic implements MessageListener{

    @Override
    public void onMessage(Message msg) {
        try{
            TextMessage tm = (TextMessage)msg;
            System.out.println(tm.getText());
        } catch(Exception e){
            
        }
    }
    
}
