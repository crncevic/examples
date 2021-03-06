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
public class Yacht extends Ship {

    public static int numberOfYachts = 0;
    private final int gasUnitInLitres = 100;

    public Yacht() {
        numberOfYachts++;
    }

   
    @Override
    public void drive(Destination d) throws RuntimeException {
        if (!serviced) {
            throw new RuntimeException("Jahta nije servisirana! Nije moguce obaviti voznju!");
        }

        if (!crewLoaded) {
            throw new RuntimeException("Jahta nema posadu! Nije moguce obaviti voznju!");
        }

        if (fuel < (d.getGasUnits() * gasUnitInLitres)) {
            throw new NoFuelException("Jahta nema dovoljno goriva! Nije moguce obaviti voznju!",null);
        }

        if (timesDriven == Constants.YACHT_DRIVES_LIMIT) {
            serviced = false;
        }

        timesDriven++;
        fuel -= gasUnitInLitres;
        crewLoaded = false;

        System.out.println("Voznja uspesno obavljena!!!");
        displayState();
    }

    @Override
    public void displayState() {
        System.out.println("************************ STANJE JAHTE ***************************");
        System.out.println("Naziv: " + name);
        System.out.println("Godina proizvodnje: " + yearOfProduction);
        System.out.println("Servisirana: " + serviced);
        System.out.println("Posada ukrcana: " + crewLoaded);
        System.out.println("Vozena " + timesDriven + " puta");
        System.out.println("Gorivo: " + fuel + " litara");
        System.out.println("*****************************************************************");
    }

    @Override
    public void loadCrew() throws RuntimeException {
        if (!crewLoaded) {
            crewLoaded = true;
            System.out.println("Posada je ukrcana. Putovanje moze poceti!!");
        } else {
            throw new RuntimeException("Posada je vec ukrcana!");
        
        }
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
    
    public boolean isCrewLoaded() {
        return crewLoaded;
    }

    public void setCrewLoaded(boolean crewLoaded) {
        this.crewLoaded = crewLoaded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static int getNumberOfYachts() {
        return numberOfYachts;
    }


}
