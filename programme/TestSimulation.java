// WENG Julie 21209248
// PENG Kairui 21219046
// groupe mono info 8

import java.io.*;
public class TestSimulation{

	public static void main(String [] args) throws IOException{
		Joyaux ja = new Joyaux("A",2);
		Joyaux jb = new Joyaux("B",3);
		Joyaux jc = new Joyaux("C",4);
		Joyaux jd = new Joyaux("D",5);
		Joyaux je = new Joyaux("E",3);
		Joyaux jf = new Joyaux("F",4);
		Joyaux jg = new Joyaux("G",5);
		Gardien d1 = new Gardien ("G1",1);
		Gardien d2 = new Gardien ("G2",3);
		Gardien d3 = new Gardien ("G3",5);

		Contenu [] tab = {d1,d2,d3,ja,jb,jc,jd,je,jf,jg};    // len = 10
		Grille g = new Grille(10,10);
		Simulation s = new Simulation(tab,10,9,g);		// m = 9

		File f = new File("resultat.txt");
		FileOutputStream out = null ;
		String msg = "WENG Julie et PENG Kairui, Groupe 8 \n";
		if (!f.exists()) { 
			f.createNewFile();
		}
		f.delete();
		try {
			out = new FileOutputStream(f,true);
			out.write(msg.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if ( out!=null ) { out.close();}
		}

		s.lance(50,f);

		
	}
}






