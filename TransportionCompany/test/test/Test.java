/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.org.apache.xerces.internal.util.FeatureState;
import com.sun.org.apache.xerces.internal.util.PropertyState;
import domain.Destination;
import domain.Sailboat;
import domain.Truck;
import exception.NoFuelException;
import factory.Creator;
import factory.SailboatCreator;
import factory.TruckCreator;
import org.testng.Assert;

/**
 *
 * @author Petar
 */
public class Test {

    @org.testng.annotations.Test
    public void test1() throws Exception {
        Creator c = new TruckCreator();
        c.create();
        ((Truck) c.tm).setCargo(true);
        c.tm.drive(new Destination(1, "Vienna", 2, true));
        c.tm.loadFuel(100);
        c.tm.drive(new Destination(2, "Berlin", 3, true));
    }

    @org.testng.annotations.Test
    public void test2() throws Exception {
        Creator c = new SailboatCreator();
        c.create();
        c.tm.drive(new Destination(3, "Barcelona", 3, false));
        c.tm.loadFuel(150);
        ((Sailboat) c.tm).loadCrew();
        c.tm.drive(new Destination(4, "Bari", 2, false));
    }

    @org.testng.annotations.Test //(expectedExceptions = {NoFuelException.class, Exception.class})
    public void test3() throws Exception {
        Destination d1 = new Destination(7, "Sofia", 2, true);
        Destination d2 = new Destination(8, "Dover", 5, false);

        Truck truck = new Truck();
        truck.setModel("BMW");
        truck.setServiced(true);
        truck.setEngineCapacity(3000);
        truck.setTimesDriven(0);
        truck.setCargo(false);
        truck.setYearOfProduction(2017);

        try {
            truck.drive(d1);
        } catch (NoFuelException nfe) {
            Assert.assertEquals(nfe.getMessage(), "Kamion nema dovoljno goriva! Voznja nece biti obavljena");
        }

        Sailboat sailboat = new Sailboat();
        sailboat.setName("Jedro2");
        sailboat.setFuel(200);
        sailboat.setCrewLoaded(false);
        sailboat.setServiced(true);
        sailboat.setTimesDriven(0);
        sailboat.setYearOfProduction(2002);
        
        try{
        sailboat.drive(d2);
        }catch(Exception ex){
            Assert.assertEquals(ex.getMessage(), "Jedrilica nema posadu! Nije moguce obaviti voznju!");
        }
    }
    
    @org.testng.annotations.Test
    public void test4() throws Exception{
        Destination d1 = new Destination(7, "Sofia", 2, true);
        Destination d2 = new Destination(8, "Dover", 5, false);
        
        Creator c = new TruckCreator();
        c.create();
        
        c.tm.drive(d1);
        
        c = new SailboatCreator();
        c.create();
        
        c.tm.drive(d2);
    }
}
