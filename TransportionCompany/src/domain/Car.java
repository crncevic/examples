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
public class Car extends Vehicle{

    public static int numberOfCars = 0; 
    
    public Car(){
        numberOfCars++;
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
    public void drive() throws Exception{
        if(fuel <= 20){
            throw new Exception("Auto nema dovoljno goriva! Voznja nece biti obavljena!");
        }
        
        if(timesDriven > 8){
            throw new Exception("Auto mora na servis! Voznja nece biti obavljena!");
        }
        
        this.fuel -= 20;
        this.timesDriven ++ ;
        
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
        System.out.println("Servisiran: " + serviced);
        System.out.println("*************************************************");
    }
    
}
