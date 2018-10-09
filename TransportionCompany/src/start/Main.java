/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import application.mode.ApplicationMode;
import application.mode.CarMode;
import application.mode.SailboatMode;
import application.mode.TruckMode;
import application.mode.YachtMode;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                am = new TruckMode();
                am.startConversation();
                break;
            case 3:
                am = new YachtMode();
                am.startConversation();
                break;
            case 4:
                am = new SailboatMode();
                am.startConversation();
                break;
            default:
                System.out.println("Hvala na poverenju! Dovidjenja!!!");
                System.exit(0);

        }

    }

}
