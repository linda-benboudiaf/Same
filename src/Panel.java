import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
public class Panel extends JPanel implements MouseListener , MouseMotionListener{
	public JFrame cadre; 
	public JButton bouton; 
	public Grille jeu; 
	
	class RestartListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			jeu.restart();
			repaint(); 
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		jeu.dessine(g);
	}
	
	public void go () {
		jeu= new Grille();
		cadre = new JFrame();
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bouton = new JButton ("Nouvelle Partie"); 
		bouton.addActionListener(new RestartListener());
		cadre.getContentPane().add(BorderLayout.CENTER, this);
		cadre.getContentPane().add(BorderLayout.SOUTH, bouton);
		cadre.setSize(400, 400);
		cadre.setVisible(true);
		this.addMouseListener(this); 
		this.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		jeu.deselectionne(); 
		repaint(); 
		jeu.selectionnePion((int)(e.getX()/40), (int)(e.getY()/40)); 
		repaint(); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jeu.supprimerSelection(); 
		repaint ();
		
	}

	public static void main(String[] args) {
		Panel p = new Panel(); 
		p.go();
	}
	   
	    public void restart() {

	    }
	    public void mouseEntered(MouseEvent e) {       

	    }
	    public void mouseExited(MouseEvent e) {

	    }
	    public void mousePressed(MouseEvent e) {
	     
	    }   
	    public void mouseReleased(MouseEvent e) {
		
	    }
	    public void mouseDragged(MouseEvent e) {

	    }

	


}
