// WENG Julie 21209248
// PENG Kairui 21219046
// groupe mono info 8

public class Agent8{
    private int x;
    private int y;
    private int taille;
    private Joyaux [] sac;
    private static int nbJoyaux = 0;
    private Grille g;

    public Agent8(int x,int y,int taille,Grille g) {
        this.x = x;
        this.y = y;
        this.taille = taille;
        this.g = g;
        sac = new Joyaux[taille];
    }

    public void seDeplacer(int xnew,int ynew) throws DeplacementIncorrectException{
        try {
            if (!g.sontValides(xnew,ynew)) {
                throw new DeplacementIncorrectException("tentative de mauvais placement");
            }
            x = xnew;
            y = ynew;
            if ( !g.caseEstVide(x,y) ) {
                Contenu c = g.getCase(x,y);
                if ( c instanceof Joyaux ) {
                    if ( nbJoyaux < taille ) {    //si la sac non vide
                        Joyaux j = (Joyaux) (g.videCase(x,y));
                        sac[nbJoyaux] = j;
                        nbJoyaux++;
                    } else {        //sinon
                        System.out.println("la sac est vide");
                    }
                } else if ( c instanceof Gardien ) {
                    for ( int i=0;i<nbJoyaux;i++ ) {
                        sac[i] = null;
                    }
                    System.out.println("occupée par un gardien");
                    nbJoyaux = 0;
                }
            }
        } catch (CoordonneesIncorrectesException e) {
            System.out.println("Erreur: "+e.getMessage());
        } catch (CaseNonPleineException e) {
            System.out.println("Erreur: "+e.getMessage());
        }
    }

    public void seDeplacer(int xnew, int ynew, int f) throws DeplacementIncorrectException{
        try {
            if (!g.sontValides(xnew,ynew)) {
                throw new DeplacementIncorrectException("tentative de mauvais placement");
            }
            x = xnew;
            y = ynew;
            if ( !g.caseEstVide(x,y) ) {
                Contenu c = g.getCase(x,y);
                if ( c instanceof Joyaux ) {
                    if ( nbJoyaux < taille ) {    //si la sac non vide
                        Joyaux j = (Joyaux) (g.videCase(x,y));
                        sac[nbJoyaux] = j;
                        nbJoyaux++;
                    } else {        //sinon
                        System.out.println("la sac est vide");
                    }
                } else if ( c instanceof Gardien ) {
                    Gardien gard = (Gardien) (g.getCase(x,y));
                    if ( gard.getNbVie() <= f ) {
                        gard = (Gardien) (g.videCase(x,y));
                    } else {
                        for ( int i=0;i<nbJoyaux;i++ ) {
                        sac[i] = null;
                        }
                        System.out.println("occupée par un gardien");
                        nbJoyaux = 0;
                        gard.baisserVie(f);
                    }
                }
            }
        } catch (CoordonneesIncorrectesException e) {
            System.out.println("Erreur: "+e.getMessage());
        } catch (CaseNonPleineException e) {
            System.out.println("Erreur: "+e.getMessage());
        }
    }

    public int fortune() {
        int prix = 0;
        for ( int i=0;i<nbJoyaux;i++ ){
            prix += sac[i].getPrix();
        }
        return prix;
    }

    public void contenuSac() {
        if ( nbJoyaux == 0 ) {
            System.out.println("la sac est vide");
        } else {
            for ( int i=0;i<nbJoyaux;i++ ) {
                System.out.println(sac[i].toString() + " prix : " + sac[i].getPrix());
            }
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public String toString() {
        return " agent : ("+x+" , "+y+")" + " fortune : " + this.fortune();
    }
}





