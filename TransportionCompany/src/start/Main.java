/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import application.mode.ApplicationMode;
import application.mode.CarMode;
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

    ApplicationMode am;
   

    public Main() {
     
    }

    public static void main(String[] args) {
        Main m = new Main();

        m.chooseTransportionMean();
        

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
                am = new CarMode();
                am.startConversation();
                break;
            case 2:
             //   creator = new TruckCreator();
                break;
            case 3:
              //  creator = new YachtCreator();
                break;
            case 4:
               // creator = new SailboatCreator();
                break;
            default:
                System.out.println("Hvala na poverenju! Dovidjenja!!!");
                System.exit(0);

        }

    }

   
}
