package fr.formation.ejb.server;

/**
 * Définition d'un objet capable d'analyser des chaines de caractères.
 */
public interface FormationUtilRemote {

	/**
	 * Analyse la chaine et renvoie vrai si elle représente un nombre entier.
	 * 
	 * @param str la chaine à tester.
	 * @return boolean vrai seulement si la chaine est un nombre entier.
	 */
	public boolean isRoundNumber(String str);
}
