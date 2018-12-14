package fr.formation.ejb.client;

import fr.formation.ejb.server.FormationUtilRemote;

public class FormationUtilTest implements Runnable {

	public static void main(String[] args) {
		new FormationUtilTest().run();
	}

	private FormationUtilRemote formationUtil;

	public void run() {
		// 1. Récupérer l'EJB grâce à l'interface distance.
		this.formationUtil = this.lookupEJB();
		if (this.formationUtil != null) {
			// On a bien récupéré l'EJB à distance.
			System.out.println("L'EJB est bien récupéré !");
			// TODO: Tester la méthode isRoundNumber.
		} else {
			// L'EJB n'a pas pu être récupéré.
			System.out.println("L'EJB pour l'interface distance "
					+ "FormationUtilRemote n'a pas été trouvé.");
		}
	}

	private FormationUtilRemote lookupEJB() {
		// TODO Auto-generated method stub
		return null;
	}
}
