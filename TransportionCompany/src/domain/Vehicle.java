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
public abstract class Vehicle extends TransportionMean {
    
    protected String model;
    protected double engineCapacity;
    protected int yearOfProduction;
    protected int timesDriven;
    protected double registrationTax;

   
     public abstract void drive() throws Exception; 
     public abstract void displayState();
}
