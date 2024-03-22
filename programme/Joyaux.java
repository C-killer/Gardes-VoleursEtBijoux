// WENG Julie
// PENG Kairui
// groupe mono info 8

public class Joyaux extends Contenu{
    private int prix;

    public Joyaux(String nom, int quantite){
        super(nom,quantite);
        prix = (int)(Math.random()*8000+1);
    }

    public int getPrix() { return prix; }

}