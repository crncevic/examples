/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.mode;

import constants.Constants;
import domain.Destination;
import domain.Sailboat;
import factory.SailboatCreator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import service.Service;

/**
 *
 * @author Petar
 */
public class SailboatMode extends ApplicationMode {

	private List<Destination> destinations;
	private Destination currentDestination;

	public SailboatMode() {
		creator = new SailboatCreator();
		creator.create();
		service = new Service();
		destinations = service.getDestinationsFor(Constants.SHIP);
	}

	@Override
	public void startConversation() {
		chooseDestination();
		try {
			drive();
		} catch (Exception e) {
			System.out.println("Dogodila se greska u izvrsavanju aplikacije. Greska: " + e.getMessage());
		}
	}

	@Override
	public void chooseDestination() {
		int choose = -1;
		System.out.println("Destinacije:");

		for (Destination destination : destinations) {
			System.out.println("ID: " + destination.getDestinationId() + ", Mesto: " + destination.getName());
		}

		System.out.println("Izaberite destinaciju tako sto ce te uneti tacan id destinacije.");
		
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				choose = Integer.parseInt(reader.readLine());
				if (isValidID(choose)) {
					//clooseReader(reader);
					break;
				} else {
					System.out.println("Molimo Vas unesite validan ID destinacije!");
				}
			} catch (Exception e) {
				System.out.println("Molimo Vas unesite validan ID destinacije!");
			}

		}


	}

	@Override
	public void drive() throws Exception {
		while (true) {

			int choose = -1;
			System.out.println("Izaberite opciju 1-natoci gorivo, 2-uradi servis, 3-ukrcaj posadu [0-Sledeci korak]");

			do {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					choose = Integer.parseInt(reader.readLine());
					if (choose != 1 && choose != 2 && choose != 3 && choose != 0) {
						System.out.println(
								"Molimo Vas izaberite opciju 1-natoci gorivo, 2-uradi servis, 3-ukrcaj posadu [0-Sledeci korak]. Pokusajte ponovo!");
					}
				} catch (Exception e) {
					System.out.println(
							"Molimo Vas izaberite opciju 1-natoci gorivo, 2-uradi servis, 3-ukrcaj posadu [0-Sledeci korak]. Pokusajte ponovo!");
				}

				
			} while (choose != 0 && choose != 1 && choose != 2 && choose != 3);

			switch (choose) {

			case 1:
				loadFuel();
				break;
			case 2:
				service();
				break;
			case 3:
				loadCrew();
				break;
			default:
				break;
			}

			int choose2 = -1;
			System.out.println(
					"Da li zelite jos akcija pre nego sto zavrsite sa podesavanjima za jedrilicu? [1-DA 0-NE]");

			do {
				BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
				try {
					choose2 = Integer.parseInt(reader2.readLine());
					if (choose2 != 0 && choose2 != 1) {
						throw new Exception();
					}

				} catch (Exception ex) {
					System.out.println("Molimo Vas izaberite 1-jos akcija 0-kraj podesavanja!");
				}

				
			} while (choose2 != 0 && choose2 != 1);

			if (choose2 == 0) {
				break;
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
				System.out.println("Molimo Vas unesite validan ceo pozitivan broj:");
			}
		}

	}

	private void loadCrew() {
		try {
			Sailboat sailboat = (Sailboat) creator.tm;
			sailboat.loadCrew();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void startDrive() throws Exception {
		try {
			creator.tm.drive(currentDestination);
			System.out.println("Jedrilica je stigla u :" + currentDestination.getName());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
	}

	private void service() {
		creator.tm.doService();
	}

}
