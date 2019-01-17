import java.awt.Graphics;
import java.awt.Point;
import java.util.*;
import javax.swing.*;

public class Grille extends JPanel {
	public static int largeur = 9;
	public static int hauteur = 7;
	private List<List<Pion>> ensPions;
	private ArrayList<Point> selection;
	
	public Grille (){
		selection = new ArrayList<Point>(); 
		ensPions = new ArrayList<List<Pion>>(); 
		List<Pion> col;  
		for (int i=0; i < largeur ; i++) {
			 col = new ArrayList<Pion>();
			for(int j=0 ; j < hauteur ; j++) {
					col.add(new Pion()); 
			}
			ensPions.add(col); 
		}
	}
	public int sizeCol(int i){
		return getCol(i).size(); 
	}
    public List<Pion> getCol(int i){//modif <= --> < pour i!!
		if (i >= 0 && i <nbCol()) {
		return ensPions.get(i); 
	}
		else return null; 
	}
	public Pion getPion(int i, int j) {
		if (i < nbCol() && i >= 0) { 
			if (j >=0  && j<sizeCol(i)) {
			    //System.out.println(getCol(i).get(j)); 
			return getCol(i).get(j);
			}
		}
		return null; 
	}
	public int nbCol() {
		return ensPions.size();
	}
	public boolean selectionnePion(int i, int j) {
		 if (this.getPion(i,j).getEtatSelection() == false && this.getPion(i, j) != null) {
			 this.getPion(i, j).setEtatSelection(true); 
			 selection.add(new Point(i,j)); 
			 	if (getPion(i, j+1) != null && this.getPion(i, j).memeCoul(getPion(i, j+1)) ){
			 		selectionnePion(i,j+1);
			 	}
			 	if (getPion(i, j-1) != null && this.getPion(i, j).memeCoul(getPion(i, j-1))){
			 		selectionnePion(i, j-1); 
			 	}
				if (getPion(i-1, j) != null && this.getPion(i, j).memeCoul(getPion(i-1, j))){
			 		selectionnePion(i-1, j); 
			 	}
				if (getPion(i+1, j) != null && this.getPion(i, j).memeCoul(getPion(i+1, j))){
			 		selectionnePion(i+1, j); 
			 	}
		 }
		 return true;
	}
	
	public boolean supprimerSelection(){
		if (!selection.isEmpty()) {
			for (int i = nbCol()-1; i>=0; i--) {
				for (int j= sizeCol(i)-1; j>=0; j--) {
					if (selection.contains(new Point(i,j))) {
						getCol(i).remove(getPion(i,j)); 
					}
				}
			}
		this.selection.clear();
		}
		return false;
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer(); 
		for (int i =0 ; i <nbCol() ; i++ ) {
			sb.append("Col"+ i + " ");
			for (int j =0 ; j<sizeCol(i); j++) {
				sb.append(getPion(i,j)); 
			}
			sb.append("\n"); 
		}
		return sb.toString(); 
	}
	public void deselectionne() {
		for (int i = 0; i<nbCol(); i++) {
			for(int j=0; j<sizeCol(i); j++) {
				if (getPion(i,j).getEtatSelection()==true) {
					getPion(i,j).setEtatSelection(false);
				}
			}
		}
		this.selection.clear();
	}
	public void restart() {
		Grille g = new Grille(); 
		this.ensPions=g.ensPions;
		this.selection= g.selection;
	}
	public void dessine (Graphics g) {
	    //System.out.println(this);
		for (int i=0; i< nbCol(); i++) {
		    for(int j=0; j<sizeCol(i); j++) {//i --> j!!!
				getPion(i,j).dessine(g, i+i*40, j+j*40);
				//System.out.print("i=" +i + " j=" +j);
				//System.out.println(getPion(i,j));
			}
		
		}
	}
	public static void main(String[] args) {
			Grille g = new Grille(); 
			System.out.println(g); 
			System.out.println(g.selectionnePion(3,6));
			System.out.println(g);
			//g.deselectionne(); 
			System.out.println(g.supprimerSelection());
			System.out.println(g);
			
	}
}
