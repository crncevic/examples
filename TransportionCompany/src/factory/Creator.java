/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import domain.TransportionMean;

/**
 *
 * @author Petar
 */
public abstract class Creator {
    
    public TransportionMean tm;
    
    public void create(){
       tm = createTransportionMean();
    }
    
    public abstract TransportionMean createTransportionMean();
}
