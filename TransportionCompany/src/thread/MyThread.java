package thread;

import application.mode.ApplicationMode;

public class MyThread extends Thread {

	ApplicationMode am;
	public static boolean allThreadsSuccessfullyEndTrip = true;

	public MyThread(ApplicationMode applicationMode) {
		am = applicationMode;
	}

	@Override
	public void run() {
		try {
			am.startDrive();
		} catch (Exception e) {
			allThreadsSuccessfullyEndTrip = false;
			System.out.println("Voznja nije uspesno zavrsena!Greska:" + e.getMessage());
		}
	}
}
