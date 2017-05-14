package utils;

import TDD.Space_invader.Vaisseau;

@SuppressWarnings("serial")
public class HorsEspaceJeuException extends RuntimeException {

	private Vaisseau vaisseau;
	
    public HorsEspaceJeuException(String message) {
	    super(message);
    }

public void positionnerUnNouveauVaisseau(int x, int y) {
		
		if (  !estDansEspaceJeu(x, y) )
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 
	}

	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < 15)) && ((y >= 0) && (y < 10));
	}
}