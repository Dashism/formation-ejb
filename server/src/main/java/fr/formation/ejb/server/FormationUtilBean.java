package fr.formation.ejb.server;

/**
 * Implémentation de l'interface distance FormationUtil utilisant uniquement
 * Java SE.
 */
public class FormationUtilBean implements FormationUtilRemote {

	/**
	 * {@inheritDoc} Implémentation par utilisation d'une expression régulière
	 * et String.matches().
	 */
	@Override
	public boolean isRoundNumber(String str) {
		boolean result = true;
		// TODO Auto-generated method stub
		return result;
	}

}
