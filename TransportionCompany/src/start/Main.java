/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import domain.Car;
import domain.Destination;
import domain.Sailboat;
import domain.Ship;
import domain.Truck;
import domain.Vehicle;
import domain.Yacht;
import factory.CarCreator;

import factory.Creator;
import factory.SailboatCreator;
import factory.TruckCreator;
import factory.YachtCreator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import service.Service;

/**
 *
 * @author Petar
 */
public class Main {

    Creator creator;
    Service service;
    Destination currentDestination;

    public Main() {
        service = new Service();
    }

    public static void main(String[] args) {
        Main m = new Main();

        m.chooseTransportionMean();
        m.creator.create();
        Destination destination = m.chooseDestination();
        if (destination != null) {
            m.drive(destination);
        } else {
            System.out.println("Dogodila se greska u sistemu");
        }

    }

    public void chooseTransportionMean() {
        int choose = -1;
        do {
            System.out.println("Izaberite nacin prevoza(1-auto 2-kamion 3-jahta 4-jedrilica 0-izlaz)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choose = Integer.parseInt(bufferedReader.readLine());
            } catch (Exception ex) {
                System.out.println("Morate uneti neki od brojeva 0,1,2,3 ili 4. Pokusajte ponovo!");
                choose = -1;
            }
        } while (choose != 0 && choose != 1 && choose != 2 && choose != 3 && choose != 4);

        switch (choose) {
            case 1:
                creator = new CarCreator();
                break;
            case 2:
                creator = new TruckCreator();
                break;
            case 3:
                creator = new YachtCreator();
                break;
            case 4:
                creator = new SailboatCreator();
                break;
            default:
                System.out.println("Hvala na poverenju! Dovidjenja!!!");
                System.exit(0);

        }

    }

    public void drive(Destination d) {
        int choose = -1;

        do {
            if (creator.tm instanceof Vehicle) {
                System.out.println("Izaberite (1-Startuj voznju 0-Izlaz)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    choose = Integer.parseInt(bufferedReader.readLine());
                } catch (Exception ex) {
                    System.out.println("Molimo Vas izaberite neki od brojeva 0 ili 1. Pokusajte ponovo");
                    choose = -1;
                }
            } else if (creator.tm instanceof Ship) {
                System.out.println("Izaberite (1-Startuj voznju 2- Ukrcaj posadu 0-Izlaz)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    choose = Integer.parseInt(bufferedReader.readLine());
                } catch (Exception ex) {
                    System.out.println("Molimo Vas izaberite neki od brojeva 0,1 ili 2. Pokusajte ponovo");
                    choose = -1;
                }
            }

            switch (choose) {
                case 1:
                    try {
                        creator.tm.drive(d);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    Ship s = (Ship) creator.tm;
                    s.loadCrew();
                    break;
                case 0:
                    System.out.println("Hvala na poverenju! Dovidjenja!!!");
                    System.exit(0);
                default:
                    break;
            }
        } while (choose != 0);
    }

    public Destination chooseDestination() {

        Destination d = null;
        System.out.println("Izaberite destinaciju. Unesite tacan ID destinacije gde zelite da putujete!");

        if (creator.tm instanceof Car || creator.tm instanceof Truck) {
            for (Destination destination : service.getDestinations()) {
                if (destination.isLandTransportion()) {
                    System.out.println("ID: " + destination.getDestinationId() + ", Destinacija: " + destination.getName());
                }
            }
        } else if (creator.tm instanceof Yacht || creator.tm instanceof Sailboat) {
            for (Destination destination : service.getDestinations()) {
                if (!destination.isLandTransportion()) {
                    System.out.println("ID: " + destination.getDestinationId() + ", Destinacija: " + destination.getName());
                }
            }
        }

        boolean canBreake = false;
        int choose = -1;
        while (!canBreake) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choose = Integer.parseInt(bufferedReader.readLine());
            } catch (Exception ex) {
                System.out.println("Molimo vas izaberite neki od ponudjenih ID-eva ili 0 za izlaz!");
            }

            if (choose == 0) {
                System.out.println("Hvala na poverenju!Dovidjenja!");
                System.exit(0);
            }
            d = containsDestination(choose);
            if (d != null) {
                canBreake = true;
            } else {
                System.out.println("Molimo vas izaberite neki od ponudjenih ID-eva ili 0 za izlaz!");
            }
        }

        return d;
    }

    private Destination containsDestination(int choose) {
        for (Destination destination : service.getDestinations()) {
            if (destination.getDestinationId() == choose) {

                return destination;
            }
        }
        return null;
    }

}
