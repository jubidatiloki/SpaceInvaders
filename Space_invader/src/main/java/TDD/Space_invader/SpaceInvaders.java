package TDD.Space_invader;

import utils.HorsEspaceJeuException;

public class SpaceInvaders {

	private static final char MARQUE_FIN_LIGNE = '\n';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
	private int largeur;
	private int hauteur;
	Vaisseau vaisseau;
	
	public SpaceInvaders(int largeur, int hauteur){
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	@Override
	public String toString() {
		return recupererEspaceDeJeuDansChaineASCII();
	}

	public String recupererEspaceDeJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	public void deplacerVaisseauVersLaDroite() {
        if (vaisseau.abscisse()< (largeur-1)) vaisseau.seDeplacerVersLaDroite();
	}

	public void deplacerVaisseauVersLaGauche() {
		if (vaisseau.abscisse()< 1) vaisseau.seDeplacerVersLaGauche();
		
	}
	
	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (aUnVaisseauQuiOccupeLaPosition(x, y))
			marque = MARQUE_VAISSEAU;
		else
			marque = MARQUE_VIDE;
		return marque;
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
		return this.aUnVaissseau() && vaisseau.occupeLaPosition(x, y);
	}

	private boolean aUnVaissseau() {
		return vaisseau!=null;
	}
	
	

	public void positionnerUnNouveauVaisseau(int x, int y) {
		
		if (  !estDansEspaceJeu(x, y) )
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 
	}

	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < largeur)) && ((y >= 0) && (y < hauteur));
	}
	
	
}
