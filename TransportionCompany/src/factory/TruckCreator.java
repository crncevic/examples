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
        System.out.println("Model kamiona je "+truck.getModel());

        truck.setYearOfProduction(2016);
        System.out.println("Godina proizvodnje kamiona je "+truck.getYearOfProduction());

        truck.setEngineCapacity(3000);
        System.out.println("Zapremina motora je "+truck.getEngineCapacity()+" cm3");

        truck.setServiced(true);
        System.out.println("Kamion je servisiran: "+truck.isServiced());

        truck.setFuel(200);
        System.out.println("Kamion ima "+truck.getFuel()+" litara goriva");

        truck.setTimesDriven(0);
        System.out.println("Kamion je vozen 0 puta");

        truck.setCargo(false);
        System.out.println("Kamion vozi teret: "+truck.isCargo());

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
