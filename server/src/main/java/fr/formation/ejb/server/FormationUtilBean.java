package fr.formation.ejb.server;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Implémentation de l'interface distance FormationUtil utilisant uniquement
 * Java SE.
 */
@Stateless
@Remote(FormationUtilRemote.class)
public class FormationUtilBean implements FormationUtilRemote {

	/**
	 * {@inheritDoc} Implémentation par utilisation d'une expression régulière
	 * et String.matches().
	 */
	@Override
	public boolean isRoundNumber(String str) {
		boolean result = true;
		if (str == null) {
			result = false;
		} else if (str.isEmpty()) {
			result = false;
		} else if (!str.matches("^-?[0-9]+$")) {
			result = false;
		}
		return result;
	}

}
