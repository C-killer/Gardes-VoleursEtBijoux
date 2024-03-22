// WENG Julie 21209248
// PENG Kairui 21219046
// groupe mono info 8

import java.io.*;

public class Simulation{
	private Agent8 agent;
	private Grille g;
	private Contenu [] tab;

	public Simulation(Contenu[] tab, int taille, int m, Grille g){
		this.tab = new Contenu[tab.length];
		for ( int k=0;k<tab.length;k++ ) {
			this.tab[k] = tab[k];
		}
		this.g = g;
		int cpt = 0;
		try{
			while ( cpt<m ) {
				int i = (int)(Math.random() * g.nbLignes);
				int j = (int)(Math.random() * g.nbColonnes);
				if (g.caseEstVide(i,j) && g.sontValides(i,j)){
					g.setCase(i,j,tab[cpt]);
					cpt++;
				}
				 
			}
		} catch (CoordonneesIncorrectesException e) {
			System.out.println("Erreur: "+e.getMessage());
		}
		int i = (int)(Math.random() * g.nbLignes);
		int j = (int)(Math.random() * g.nbColonnes);
		agent = new Agent8(i,j,taille,g);
	}

	public String toString() {
		g.affiche(3);
		return g.toString() + agent.toString();
	}

	public void lance(int nbEtapes, File f) throws IOException{
		int i=1;
		while (i<=nbEtapes){
			int x = agent.getX();
			int y = agent.getY();
			double n = Math.random();    //probabilite de coordonnee
			if ( n<0.25 ){
				x++;
			} else if ( 0.25<=n && n<0.5 ) {
				x--;
			} else if ( 0.5<=n && n<0.75 ){
				y++;
			} else {
				y--;
			}
			while (!(g.sontValides(x,y))) {
				n = Math.random();
				x = agent.getX();
				y = agent.getY();
				if ( n<0.25 ){
					x++;
				} else if ( 0.25<=n && n<0.5 ) {
					x--;
				} else if ( 0.5<=n && n<0.75 ){
					y++;
				} else {
					y--;
				}
			}

			n = Math.random(); 
			String s = "";
			if (!f.exists()){
				System.out.println("le fichier n'existe pas");
				return ;
			} 
			else {
				FileOutputStream out = null ;
				if ( n<0.3 ) {			//probabilite d'obtenir force
					int force = (int)(Math.random() * 91 + 10);
					try{
						agent.seDeplacer(x,y,force);
						s = "Etape "+i+" : "+this.toString() + "\n";
						out = new FileOutputStream(f,true);
						out.write(s.getBytes());
						System.out.println(s);

					} catch (DeplacementIncorrectException e) {
						System.out.println("Erreur: "+e.getMessage());
					} finally {
						if ( out!=null ){
							out.close();
						}
					} 
				}
				else {
					try{
						agent.seDeplacer(x,y);
						s = "Etape "+i+" : "+this.toString() + "\n";
						out = new FileOutputStream(f,true);
						out.write(s.getBytes());
						System.out.println(s);
					} catch (DeplacementIncorrectException e) {
						System.out.println("Erreur: "+e.getMessage());
					} finally {
						if ( out!=null ){
							out.close();
						}
					}
				}
			}
			i++;
		}
	}
}








