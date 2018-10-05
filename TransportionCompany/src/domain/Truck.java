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
public class Truck extends Vehicle {

    public static int numberOfTrucks = 0;

    private boolean cargo;

    public Truck() {
        numberOfTrucks++;
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

    @Override
    public void drive() throws Exception {
        if ((fuel <= 20 && cargo == false) || (fuel<=40 && cargo==true)) {
            throw new Exception("Kamion nema dovoljno goriva! Voznja nece biti obavljena");
        }

        if (timesDriven > 8) {
            serviced = false;
            throw new Exception("Kamion mora da obavi servis! Voznja nece biti obavljena");
        }

        if (cargo) {
            fuel -= 40;
        } else {
            fuel -= 20;
        }

        timesDriven++;
        
        displayState();
    }

    @Override
    public void displayState() {
        System.out.println("*************************************************");
        System.out.println("Model: " + model);
        System.out.println("Zapremina motora: " + engineCapacity);
        System.out.println("Godina proizvodnje: " + yearOfProduction);
        System.out.println("Vozen: " + timesDriven + " puta");
        System.out.println("Gorivo: " + fuel + " litara");
        System.out.println("Natovaren: " + cargo);
        System.out.println("Servisiran: " + serviced);
        System.out.println("*************************************************");
    }

}
