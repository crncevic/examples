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
import domain.TransportionMean;
import thread.MyThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Petar
 */
public class Main {

	ApplicationMode am;
	int numberOfDrives = 0;
	List<MyThread> threads;

	public Main() {
		threads = new ArrayList<MyThread>();
	}

	public static void main(String[] args) {
		Main m = new Main();

		m.numberOfDrives = m.chooseNumberOfDrives();

		for (int i = 0; i < m.numberOfDrives; i++) {
			m.threads.add(new MyThread(m.chooseTransportionMean()));
		}
		
		m.startDrives(m.threads);

	}

	public void startDrives(List<MyThread> threads) {
		int choose = -1;

		System.out.println("Izaberite : [0-Izlaz 1-Startuj voznje]");

		do {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				choose = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Molimo Vas unesite 0-Izlaz ili 1-Startuj voznje!");
			}

		} while (choose != 0 && choose != 1);

		if (choose == 1) {
			try {
				for (MyThread myThread : threads) {
					myThread.start();
					myThread.join();
				}
				
				if(MyThread.allThreadsSuccessfullyEndTrip) {
					System.out.println("Sva vozila su uspesno zavrsila putovanje!");
				}
			} catch (Exception ex) {
				System.out.println("Dogodila se greska prilikom izvrsavanja voznji! Greska: " + ex.getMessage());
			}
		} else {
			System.out.println("Hvala sto ste koristili aplikaciju! Dovidjenja!");
		}

	}

	public int chooseNumberOfDrives() {

		int choose = -1;
		do {
			System.out.println("Unesite koliko zelite voznji:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			try {
				choose = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Molimo Vas unesite pozitivan broj koji reprezentuje broj voznji!");
			}

		} while (choose < 0);

		System.out.println("********************************************");
		System.out.println("Molimo vas da unesete " + choose + " voznji!");
		System.out.println("********************************************");

		return choose;

	}

	public ApplicationMode chooseTransportionMean() {
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

		return am;

	}

}
