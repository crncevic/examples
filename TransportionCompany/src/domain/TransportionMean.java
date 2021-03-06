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
public abstract class TransportionMean {

    protected boolean serviced;
    protected double fuel;
    protected int yearOfProduction;
    protected int timesDriven;

    public abstract void drive(Destination destination) throws RuntimeException;
    public abstract void loadFuel(int litres) throws RuntimeException;
    public abstract void doService();
    public abstract void displayState();
}
