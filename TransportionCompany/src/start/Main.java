/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import domain.Car;
import domain.Truck;
import factory.CarCreator;

import factory.Creator;
import factory.TruckCreator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Petar
 */
public class Main {

    Creator creator;

    public static void main(String[] args) {
        Main m = new Main();

        m.chooseTransportionMean();
        m.creator.create();

    }

    public void chooseTransportionMean() {
        int choose = -1;
        do {
            System.out.println("Izaberite nacin prevoza(1-auto 2-kamion 0-izlaz)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choose = Integer.parseInt(bufferedReader.readLine());
            } catch (Exception ex) {
                System.out.println("Morate uneti neki od brojeva 0,1 ili 2. Pokusajte ponovo!");
                choose = -1;
            }
        } while (choose != 0 && choose != 1 && choose != 2);

        if (choose == 1) {
            creator = new CarCreator();
        } else if (choose == 2) {
            creator = new TruckCreator();
        } else {
            System.exit(0);
        }

    }
}
