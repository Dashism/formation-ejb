package fr.formation.ejb.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.formation.ejb.server.FormationUtilRemote;

public class FormationUtilTest implements Runnable {

	private static final String HTTP = "http";

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
			if (this.formationUtil.isRoundNumber("42")) {
				System.out.println("La chaine '42' est un nombre !");
			}
			if (!this.formationUtil.isRoundNumber("a12")) {
				System.out.println("La chaine 'a12' n'est pas un nombre !");
			}
		} else {
			// L'EJB n'a pas pu être récupéré.
			System.out.println("L'EJB pour l'interface distance "
					+ "FormationUtilRemote n'a pas été trouvé.");
		}
	}

	private FormationUtilRemote lookupEJB() {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.wildfly.naming.client.WildFlyInitialContextFactory");
		if (Boolean.getBoolean(HTTP)) {
			// use HTTP based invocation. Each invocation will be a HTTP request
			jndiProperties.put(Context.PROVIDER_URL,
					"http://localhost:8080/wildfly-services");
		} else {
			// use HTTP upgrade, an initial upgrade requests is sent to upgrade
			// to the remoting protocol
			jndiProperties.put(Context.PROVIDER_URL,
					"remote+http://localhost:8080");
		}
		try {
			final Context context = new InitialContext(jndiProperties);
			return (FormationUtilRemote) context
					.lookup("ejb:/formation-ejb-server/FormationUtilBean!"
							+ FormationUtilRemote.class.getName());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
