package TDD.Space_invader;

public class SpaceInvaders {

	private int largeur;
	private int hauteur;
	Vaisseau vaisseau;
	
	public SpaceInvaders(int largeur, int hauteur){
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	@Override
	public String toString() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				if (aUnVaisseauQuiOccupeLaPosition(y, x))
					espaceDeJeu.append('V');
				else
					espaceDeJeu.append('.');
			}
			espaceDeJeu.append('\n');
		}
		return espaceDeJeu.toString();
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
		return this.aUnVaissseau() && vaisseau.occupeLaPosition(x, y);
	}

	private boolean aUnVaissseau() {
		return vaisseau!=null;
	}
	
	

	public void positionnerUnNouveauVaisseau(int x, int y) {
        this.vaisseau = new Vaisseau (x,y);
	}
}
