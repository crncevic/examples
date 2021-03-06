/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import domain.Car;
import domain.TransportionMean;

/**
 *
 * @author Petar
 */
public class CarCreator extends Creator {

    Car car;

    @Override
    public TransportionMean createTransportionMean() {
        car = new Car();

        car.setModel("Passat B6");
        System.out.println("Model auta je " + car.getModel());

        car.setYearOfProduction(2006);
        System.out.println("Godina proizvodnje auta je " + car.getYearOfProduction());

        car.setServiced(true);
        System.out.println("Auto je servisiran: " + car.isServiced());

        car.setFuel(50);
        System.out.println("U autu ima " + car.getFuel() + " litara benzina");

        car.setEngineCapacity(2000);
        System.out.println("Zapremina motora je " + car.getEngineCapacity() + " cm3");

        car.setTimesDriven(0);
        System.out.println("Auto je vozen " + car.getTimesDriven() + " puta do sada");

        if (car.getEngineCapacity() > 2000) {
            car.setRegistrationTax(1000);
        } else {
            car.setRegistrationTax(700);
        }
        System.out.println("Registracija auta kosta " + car.getRegistrationTax() + " evra \n");
        System.out.println("Auto je kreiran za vas!");

        return car;
    }

}
