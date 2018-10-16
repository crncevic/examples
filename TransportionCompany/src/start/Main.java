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
import constants.Constants;
import domain.TransportionMean;
import thread.MyThread;

import static org.testng.Assert.assertThrows;

import java.io.BufferedReader;
import java.io.IOException;
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
			m.threads.add(new MyThread(m.chooseTransportionMean(i)));
		}

		m.startDrives(m.threads);

	}

	public void startDrives(List<MyThread> threads) {
		int choose = -1;

		System.out.println("Izaberite : [0-Izlaz 1-Startuj voznje]");

		BufferedReader reader;
		do {
			reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				choose = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Molimo Vas unesite 0-Izlaz ili 1-Startuj voznje!");
			}

		} while (choose != 0 && choose != 1);

		clooseReader(reader);

		if (choose == 1) {
			try {
				for (MyThread myThread : threads) {
					myThread.start();
					myThread.join();
				}

				if (MyThread.allThreadsSuccessfullyEndTrip) {
					System.out.println("Sva vozila su uspesno zavrsila putovanje!");
				}
			} catch (Exception ex) {
				System.out.println("Dogodila se greska prilikom izvrsavanja voznji! Greska: " + ex.getMessage());
			}
		} else {
			System.out.println("Hvala sto ste koristili aplikaciju! Dovidjenja!");
		}

	}

	private void clooseReader(BufferedReader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Nije moguce zatvoriti BufferedReader!");
			}
		}

	}

	public int chooseNumberOfDrives() {

		int choose = -1;
		BufferedReader reader;

		System.out.println(Constants.START_MESSAGE);
		System.out.println("Unesite koliko zelite voznji: [0-Izlaz]");

		do {

			reader = new BufferedReader(new InputStreamReader(System.in));

			try {
				choose = Integer.parseInt(reader.readLine());

				if (choose == 0) {
					System.out.println(Constants.GOOD_BYE);
					System.exit(0);
				}

				if (choose < 0) {
					throw new RuntimeException();
				}
			} catch (Exception e) {
				System.out.println("Molimo Vas unesite pozitivan broj koji reprezentuje broj voznji!");
			}

		} while (choose < 0);

		clooseReader(reader);

		System.out.println("********************************************");
		System.out.println("Molimo vas da unesete " + choose + " voznji!");
		System.out.println("********************************************");

		return choose;

	}

	public ApplicationMode chooseTransportionMean(int i) {
		int choose = -1;
		BufferedReader bufferedReader;
		do {
			System.out.println("Izaberite nacin prevoza transportnog sredstva br: " + (i + 1)
					+ "  (1-auto 2-kamion 3-jahta 4-jedrilica 0-izlaz)");
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {
				choose = Integer.parseInt(bufferedReader.readLine());
			} catch (Exception ex) {
				System.out.println("Morate uneti neki od brojeva 0,1,2,3 ili 4. Pokusajte ponovo!");
				choose = -1;
			}
		} while (choose != 0 && choose != 1 && choose != 2 && choose != 3 && choose != 4);

		clooseReader(bufferedReader);

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
