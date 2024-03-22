// WENG Julie
// PENG Kairui
// groupe mono info 8

public class Gardien extends Contenu{
    private int nbVie;

    public Gardien(String nom, int quantite){
        super(nom,quantite);
        nbVie = (int)(Math.random()*201);
    }

    public int getNbVie() { return nbVie; }

    public void baisserVie(int f) {
        nbVie -= f;
    }
}