package Game.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MainMenu extends JFrame{
	private JPanel Heroes;
	private JPanel center;
	private JPanel Top;
	private JPanel Chosen;
	private JLabel jl;
	private JLabel tl;
	public MainMenu(){
	this.setTitle("Choose Hero");
	jl=new JLabel("CenterJLabel");
	tl=new JLabel("");
	Chosen=new JPanel();
	Top=new JPanel();
	Heroes=new JPanel();
	center=new JPanel();
	center.setVisible(true);
	jl.setVisible(true);
	Top.setVisible(true);
	tl.setVisible(true);
	this.setVisible(true);
	Chosen.setVisible(true);
	Heroes.setLayout(new GridLayout(0, 2));
	this.setBounds(0,0, 1000, 800);
	jl.setLayout(new GridLayout(0, 1));
	jl.setPreferredSize(new Dimension(300,90));
	Top.setPreferredSize(new Dimension(1000,200));
	tl.setPreferredSize(new Dimension(1000,200));
    center.setPreferredSize(new Dimension(200,600));
	Heroes.setPreferredSize(new Dimension(400,600));
	Chosen.setPreferredSize(new Dimension(300,600));
	center.setBackground(Color.BLACK);
	Chosen.setBackground(Color.BLACK);
	Top.setBackground(Color.BLACK);
	Heroes.setBackground(Color.BLACK);
	center.add(jl,BorderLayout.CENTER);
	tl.setIcon(new ImageIcon("images/hearthstone.jpg"));
	Top.add(tl,BorderLayout.EAST);
	this.add(Heroes,BorderLayout.WEST);
	this.add(Top, BorderLayout.NORTH);
	this.add(center, BorderLayout.CENTER);
	this.add(Chosen,BorderLayout.EAST);
	this.revalidate();
	this.repaint();
}

public JLabel getJl() {
	return jl;
}

public JPanel getCenter() {
	return center;
}

public JPanel getTop() {
	return Top;
}

public JPanel getChosen() {
	return Chosen;
}

public JPanel getHeroes() {
	return Heroes;
}

public static void main(String [] args){
	   new MainMenu();
   }

}



