/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import constants.Constants;
import exception.NoFuelException;

/**
 *
 * @author Petar
 */
public class Truck extends Vehicle {

    public static int numberOfTrucks = 0;
    private final int gasUnitInLitres = 40;

    private boolean cargo;

    public Truck() {
        numberOfTrucks++;
    }

   

    @Override
    public void drive(Destination d) throws RuntimeException {
        
    	if(!serviced) {
    		throw new RuntimeException("Kamion nije servisiran nije moguce obaviti voznju!");
    	}
    	
    	if ((fuel <= (d.getGasUnits() * gasUnitInLitres) && cargo == false) || (fuel <= (d.getGasUnits() * (gasUnitInLitres * 2)) && cargo == true)) {
            throw new NoFuelException("Kamion nema dovoljno goriva! Voznja nece biti obavljena",null);
        }

        if (timesDriven == Constants.TRUCK_DRIVES_LIMIT) {
            serviced = false;
        }

        if (cargo) {
            fuel -= gasUnitInLitres*2;
        } else {
            fuel -= gasUnitInLitres;
        }

        timesDriven++;
        cargo = false;

        displayState();
    }

    @Override
    public void displayState() {
        System.out.println("*********************** STANJE KAMIONA **************************");
        System.out.println("Model: " + model);
        System.out.println("Zapremina motora: " + engineCapacity);
        System.out.println("Godina proizvodnje: " + yearOfProduction);
        System.out.println("Vozen: " + timesDriven + " puta");
        System.out.println("Gorivo: " + fuel + " litara");
        System.out.println("Natovaren: " + cargo);
        System.out.println("Servisiran: " + serviced);
        System.out.println("*****************************************************************");
    }

    @Override
    public void calculateRegistrationFees() {
    }

    @Override
    public void loadFuel(int litres) throws RuntimeException {
        if (litres > 0) {
            fuel += litres;
            System.out.println("Natoceno je " + litres + " goriva");
        } else {
           throw new RuntimeException("Kolicina goriva mora da bude pozitivna!");
        }
        
        displayState();
    }

    @Override
    public void doService() {
        serviced = true;
        System.out.println("Kamion je servisiran!");
        displayState();
    }

    public void loadCargo() throws RuntimeException {
        if (!cargo) {
            cargo = true;
            System.out.println("Kamion je natovaren!");
        } else {
            throw new RuntimeException("Kamion je vec natovaren!");
        }
    }
    
    public boolean isCargo() {
        return cargo;
    }

    public void setCargo(boolean cargo) {
        this.cargo = cargo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getTimesDriven() {
        return timesDriven;
    }

    public void setTimesDriven(int timesDriven) {
        this.timesDriven = timesDriven;
    }

    public boolean isServiced() {
        return serviced;
    }

    public void setServiced(boolean serviced) {
        this.serviced = serviced;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getRegistrationTax() {
        return registrationTax;
    }

    public void setRegistrationTax(double registrationTax) {
        this.registrationTax = registrationTax;
    }

    public int getGasUnitInLitres() {
        return gasUnitInLitres;
    }

}
