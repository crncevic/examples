/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import domain.TransportionMean;
import domain.Yacht;

/**
 *
 * @author Petar
 */
public class YachtCreator extends Creator {

    Yacht yacht;

    @Override
    public TransportionMean createTransportionMean() {
        yacht = new Yacht();

        yacht.setName("Monaco");
        System.out.println("Jahta ima naziv " + yacht.getName());

        yacht.setServiced(true);
        System.out.println("Jahta je servisirana: " + yacht.isServiced());

        yacht.setYearOfProduction(2018);
        System.out.println("Jahta je proizvedena " + yacht.getYearOfProduction() + " godine");

        yacht.setCrewLoaded(true);
        System.out.println("Jahta ima posadu: " + yacht.isCrewLoaded());

        yacht.setFuel(1000);
        System.out.println("Jahta ima " + yacht.getFuel() + " litara goriva!");
        
        yacht.setTimesDriven(0);
        System.out.println("Jahta je vozena "+ yacht.getTimesDriven()+" puta!");
        
        System.out.println("Jahta je kreirana za vas!");

        return yacht;
    }

}
