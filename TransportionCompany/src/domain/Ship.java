/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Petar
 */
public abstract class Ship extends TransportionMean{
    protected boolean crewLoaded;
    protected String name;
    
    public abstract void loadCrew() throws RuntimeException;
}
