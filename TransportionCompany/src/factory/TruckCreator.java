/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import domain.TransportionMean;
import domain.Truck;

/**
 *
 * @author Petar
 */
public class TruckCreator extends Creator {

    Truck truck;

    @Override
    public TransportionMean createTransportionMean() {
        truck = new Truck();

        truck.setModel("Mercedes");
        System.out.println("Model kamiona je Mercedes");

        truck.setYearOfProduction(2016);
        System.out.println("Godina proizvodnje kamiona je 2016");

        truck.setEngineCapacity(3000);
        System.out.println("Zapremina motora je 3000cm3");

        truck.setServiced(true);
        System.out.println("Kamion je servisiran");

        truck.setFuel(200);
        System.out.println("Kamion ima 200 litara goriva");

        truck.setTimesDriven(0);
        System.out.println("Kamion je vozen 0 puta");

        truck.setCargo(false);
        System.out.println("Kamion ne vozi teret");

        if (truck.getEngineCapacity() > 4000) {
            truck.setRegistrationTax(3000);
        } else {
            truck.setRegistrationTax(2000);
        }

        System.out.println("Registracija kamiona kosta " + truck.getRegistrationTax() + " evra \n");
        System.out.println("Kamion je kreiran za vas!");
        return truck;
    }

}
