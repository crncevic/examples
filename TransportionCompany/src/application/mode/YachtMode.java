/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.mode;

import constants.Constants;
import domain.Destination;
import domain.Sailboat;
import domain.Yacht;
import factory.SailboatCreator;
import factory.YachtCreator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import service.Service;

/**
 *
 * @author Petar
 */
public class YachtMode extends ApplicationMode{
    private List<Destination> destinations;
    private Destination currentDestination;

    public YachtMode() {
        creator = new YachtCreator();
        creator.create();
        service = new Service();
        destinations = service.getDestinationsFor(Constants.SHIP);
    }

    @Override
    public void startConversation() {
        chooseDestination();
        drive();
    }

    @Override
    public void chooseDestination() {
        int choose = -1;
        System.out.println("Destinacije:");

        for (Destination destination : destinations) {
            System.out.println("ID: " + destination.getDestinationId() + ", Mesto: " + destination.getName());
        }

        System.out.println("Izaberite destinaciju tako sto ce te uneti tacan id destinacije: [0-Izlaz]");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                choose = Integer.parseInt(reader.readLine());
                if (isValidID(choose)) {
                    break;
                } else {
                    System.out.println("Molimo Vas unesite validan ID ili 0 za izlaz");
                }
            } catch (Exception e) {
                System.out.println("Molimo Vas unesite validan ID ili 0 za izlaz");
            }

        }

    }

    @Override
    public void drive() {
        int choose = -1;
        System.out.println("Izaberite opciju 1-startuj voznju, 2-natoci gorivo, 3-uradi servis, 4-ukrcaj posadu [0-Izlaz]");
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choose = Integer.parseInt(reader.readLine());
                if (choose != 1 && choose != 2 && choose != 3 && choose != 4 && choose != 0) {
                    System.out.println("Molimo Vas izaberite opciju 1-startuj voznju, 2-natoci gorivo, 3-uradi servis, 4- ukrcaj posadu [0-Izlaz]. Pokusajte ponovo!");
                }
            } catch (Exception e) {
                System.out.println("Molimo Vas izaberite opciju 1-startuj voznju, 2-natoci gorivo, 3-uradi servis, 4 - ukrcaj posadu [0-Izlaz]. Pokusajte ponovo!");
            }
        } while (choose != 0 && choose != 1 && choose != 2 && choose != 3 && choose != 4);

        switch (choose) {
            case 1:
                startDrive();
                break;
            case 2:
                loadFuel();
                break;
            case 3:
                service();
                break;
            case 4:
                loadCrew();
                break;
            default:
                System.out.println("Hvala na poverenju! Dovidjenja!");
                System.exit(0);
        }

        System.out.println("Da li zelite da nastavite sa radom? [0-NE 1-DA]");
        int choose2 = -1;

        while (true) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choose2 = Integer.parseInt(reader.readLine());
                if (choose2 != 0 && choose2 != 1) {
                    throw new Exception();
                }

                if (choose2 == 1) {
                    drive();
                    break;
                } else {
                    System.out.println("Hvala na poverenju! Dovidjenja!");
                    System.exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Molimo Vas unesite 1 ako zelite da nastavite sa radom ili 0 ako ne zelite! Pokusajte ponovo!");
            }
        }
    }

    private boolean isValidID(int choose) {
        for (Destination destination : destinations) {
            if (choose == destination.getDestinationId()) {
                currentDestination = destination;
                return true;
            }
        }
        return false;
    }

    private void loadFuel() {
        System.out.println("Unesite broj litara:");

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                int litres = Integer.parseInt(reader.readLine());
                if (litres < 0) {
                    throw new Exception();
                }
                creator.tm.loadFuel(litres);
                break;

            } catch (Exception ex) {
                System.out.println("Molimo Vas unesite validan ceo pozitivan broj![0-Izlaz]");
            }
        }
    }
    

    private void loadCrew() {
        try {
            Yacht yacht = (Yacht) creator.tm;
            yacht.loadCrew();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void startDrive() {
        try {
            creator.tm.drive(currentDestination);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void service() {
        creator.tm.doService();
    }
}
