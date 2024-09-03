package Game.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GameView extends JFrame {
	
	private JPanel CurrentHero;
	private JPanel OppHero;
    private JPanel CurrHeroHand;
    private JPanel CurrHeroPl;
    private JPanel CurrHeroField;
    private JPanel OppHeroHand;
    private JPanel OppHeroField;
    private JPanel OppHeroPl;
    JPanel pp1;
    JPanel pp2;
    JPanel FieldGrid1;
    JPanel FieldGrid2;
    
  
    
    public GameView() throws IOException{
	  this.setTitle("PLAY");
	  FieldGrid1=new JPanel();
	  FieldGrid2=new JPanel();
	  FieldGrid1.setLayout(new GridLayout(0, 4));
	  FieldGrid2.setLayout(new GridLayout(0, 4));
	  FieldGrid1.setBackground(Color.BLACK);
	  FieldGrid2.setBackground(Color.blue);
	  FieldGrid1.setVisible(true);
	  FieldGrid2.setVisible(true);
	  FieldGrid1.setPreferredSize(new Dimension(100,100));
	  
	  
	  
	  CurrentHero=new JPanel();
	  CurrHeroHand=new JPanel();
	  CurrHeroPl=new JPanel();
	  CurrHeroField=new JPanel();
	  OppHero=new JPanel();
	  OppHeroHand=new JPanel();
	  OppHeroField=new JPanel();
	  OppHeroPl=new JPanel();
	  pp1=new JPanel();
	  pp2=new JPanel();
	  this.setBounds(0,0, 1000, 900);
	  this.setVisible(true);
	  this.add(CurrentHero,BorderLayout.SOUTH);
	  this.add(OppHero,BorderLayout.NORTH);
	  OppHero.setBackground(Color.WHITE);
	  OppHero.setLayout(new BorderLayout());
	  
	  OppHero.setPreferredSize(new Dimension(1000, 360));
	  
	  
	  CurrentHero.setLayout(new BorderLayout());
	  CurrentHero.setPreferredSize(new Dimension(1000, 360));
	  CurrHeroHand.setPreferredSize(new Dimension(300, 360));
	  CurrHeroHand.setLayout(new GridLayout(4, 3));
	  CurrHeroHand.setBackground(Color.CYAN);
	  CurrHeroField.setPreferredSize(new Dimension(700,360));
	  CurrHeroField.setLayout(new BorderLayout());
	  CurrHeroField.setBackground(Color.YELLOW);
	  CurrHeroPl.setPreferredSize(new Dimension(150,360));
	  CurrHeroPl.setBounds(100, 100, 100,100);
	  //CurrHeroPl.setLayout(new GridLayout(0, 1));
	  CurrHeroPl.setLayout(new BorderLayout());
	  CurrHeroPl.setBackground(Color.BLUE);
	  CurrHeroField.add(CurrHeroPl,BorderLayout.EAST);
	 
	  CurrentHero.add(CurrHeroHand,BorderLayout.WEST);
	  CurrentHero.add(CurrHeroField,BorderLayout.CENTER);

	  
	  
	  
	  OppHeroHand.setPreferredSize(new Dimension(300, 360));
	  OppHeroHand.setLayout(new GridLayout(4, 3));
	  OppHeroHand.setBackground(Color.pink);
	  OppHero.add(OppHeroHand,BorderLayout.WEST);
	  OppHeroField.setPreferredSize(new Dimension(700,360));
	  OppHeroField.setLayout(new BorderLayout());
	  OppHeroField.setBackground(Color.GREEN);
	  OppHero.add(OppHeroField,BorderLayout.CENTER);
	  OppHeroPl.setPreferredSize(new Dimension(150,360));
	  OppHeroPl.setBounds(100, 100, 100,100);
	  //OppHeroPl.setLayout(new GridLayout(0, 1));
	  OppHeroPl.setLayout(new BorderLayout());
	  OppHeroPl.setBackground(Color.RED);
	  OppHeroField.add(OppHeroPl,BorderLayout.EAST);
	  

	  pp1.setPreferredSize(new Dimension(CurrHeroPl.getWidth(),30));
	  pp2.setPreferredSize(new Dimension(OppHeroPl.getWidth(),30));

	  
	  CurrHeroField.add(FieldGrid1);
	  OppHeroField.add(FieldGrid2);
	  
	  CurrHeroPl.add(pp1);
	  OppHeroPl.add(pp2);
	  this.revalidate();
	  this.repaint();
  }

	public JPanel getFieldGrid1() {
		return FieldGrid1;
	}

	public JPanel getFieldGrid2() {
		return FieldGrid2;
	}

	public JPanel getPp1() {
		return pp1;
	}

	public JPanel getPp2() {
		return pp2;
	}

	public JPanel getOppHeroPl() {
		return OppHeroPl;
	}

	public JPanel getCurrHeroPl() {
		return CurrHeroPl;
	}

	public JPanel getCurrentHero() {
		return CurrentHero;
	}
	public JPanel getOppHero() {
		return OppHero;
	}
	
	public JPanel getCurrHeroHand() {
		return CurrHeroHand;
	}
	public JPanel getCurrHeroField() {
		return CurrHeroField;
	}
	public JPanel getOppHeroField() {
		return OppHeroField;
	}
public static void main(String [] args) throws IOException{
	   new GameView();
   }



public JPanel getOppHeroHand() {
	return OppHeroHand;
}                 
}
