/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import domain.Sailboat;
import domain.TransportionMean;

/**
 *
 * @author Petar
 */
public class SailboatCreator extends Creator {

    Sailboat sailboat;

    @Override
    public TransportionMean createTransportionMean() {
        sailboat = new Sailboat();

        sailboat.setName("Galeb");
        System.out.println("Jedrilica ima naziv "+sailboat.getName());
        
        sailboat.setYearOfProduction(2016);
        System.out.println("Jedrilica je napravljena "+sailboat.getYearOfProduction());
        
        sailboat.setServiced(true);
        System.out.println("Jedrilica je servisirana: "+sailboat.isServiced());
        
        sailboat.setCrewLoaded(true);
        System.out.println("Jedrilica ima posadu: "+sailboat.isCrewLoaded());
        
        sailboat.setFuel(500);
        System.out.println("Jedrilica ima "+sailboat.getFuel()+" litara goriva!");
        
        sailboat.setTimesDriven(0);
        System.out.println("Jedrilica je vozena "+sailboat.getTimesDriven()+" puta");
        
        System.out.println("Jedrilica je kreirana za vas!");
        return sailboat;
    }

}
