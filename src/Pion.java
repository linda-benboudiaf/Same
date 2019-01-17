import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Pion extends JPanel {
	private boolean etatSelection;
	private Color couleur; 
	public Pion(){
		etatSelection = false; 
		switch ((int)(Math.random()*3)){
		case 0:
			couleur = new Color (255,77,148);
		break;	
		case 1: 	
			couleur = new Color (12,26,200);
		break;
		case 2:
			couleur = new Color (255,255,77);
		break;
		}
	}
	
	public boolean getEtatSelection () {
		return etatSelection; 
	}
	public Color getCouleur() {
		return couleur; 
	}
	
	public String toString () {
		String coul = "";
		String selection = "";
		if (etatSelection) {
			selection = "T"; 
		}else selection = "F"; 
		
		if (couleur.equals(new Color(255,77,148))) {
			coul = "V"; 
		}
		if (couleur.equals(new Color(12,26,200))) {
			coul = "B"; 
		}
		if (couleur.equals(new Color(255,255,77))) {
			coul = "Y"; 
		}
		return "["+ selection +  ", " + coul+"]"; 
	}
	
	public void setEtatSelection(boolean b) {
		etatSelection = b;
	}

	public boolean memeCoul (Pion p ) {
		return this.couleur.equals(p.couleur); 
	}
	public void dessine(Graphics g, int x, int y) {
		g.setColor(getCouleur());
		if (this.getEtatSelection()) {
			g.fillRect(x, y, 40, 40);
		}else {
			g.fillOval(x, y, 40, 40);
		}
	}
	public static void main(String[] args) {
		Pion p1 = new Pion ();
		Pion p2 = new Pion ();
		Pion p3 = new Pion ();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p1.setEtatSelection(true);
		System.out.println(p1); 
		System.out.println(p1.memeCoul(p3));
	}
}
