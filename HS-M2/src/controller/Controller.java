package controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import engine.Game;

import javax.swing.*;

import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Spell;
import model.heroes.*;
import Game.view.*;
import engine.GameListener;
public class Controller implements ActionListener{
	private Game game;
	private GameListener Glistener;
	private boolean spp ,att;
	private Spell s;
	private Minion m1, m2,m3;
	private Hero herotarget;
	private JButton Hero1;
	private JButton Hero2;
	private Hero hero1=null;
	private Hero hero2=null;
	private GameView GameView;
	private MainMenu Menu;
	private JButton endturn;
	private JButton UseHero;
	private JButton Mage;
	private JButton Hunter;
	private JButton Paladin;
	private JButton Priest;
	private JButton Warlock;
	private JButton ChooseHero1;
	private JButton ChooseHero2;
	private JButton Start;
	private JButton H1;
	private JButton H2;
	private int c1=0;
	private int c2=0;
	private String s1="";
	private String s2="";
	private int conf;
	private int c=0;
	public Controller(){
		att=false;
		s=null;
		spp=false;
		m1=null;
		m2=null;
		m3=null;
		herotarget=null;
		conf=0;
		Hero1=new JButton();
		Hero2=new JButton();
		Hero1.setPreferredSize(new Dimension(100,100));
		Hero2.setPreferredSize(new Dimension(100,100));
		Hero1.addActionListener(this);
		Hero2.addActionListener(this);
		Start=new JButton("Start");
		endturn=new JButton("EndTurn");
		endturn.setActionCommand("EndTurn");
		endturn.addActionListener(this);
		endturn.setPreferredSize(new Dimension(100,25));
		Menu=new MainMenu();
		UseHero=new JButton("UseHero");
		UseHero.addActionListener(this);
		UseHero.setBounds(150, 30, 150, 30);
		ChooseHero1 =new JButton("Choose First Hero");
		ChooseHero2 =new JButton("Choose Second Hero");
	    Mage=new JButton("Mage");
		Mage.setBounds(100, 100, 100, 100);
		Hunter=new JButton("Hunter");
		Paladin=new JButton("Paladin");
		Priest=new JButton("Priest");
		Warlock=new JButton("Warlock");
		ChooseHero1.setVisible(true);
		ChooseHero2.setVisible(true);
		Start.setVisible(true);
		Mage.setVisible(true);
		Hunter.setVisible(true);
		Paladin.setVisible(true);
		Priest.setVisible(true);
		Warlock.setVisible(true);
		Mage.addActionListener(this);
		Hunter.addActionListener(this);
		Paladin.addActionListener(this);
		Warlock.addActionListener(this);
		Priest.addActionListener(this);
		ChooseHero1.addActionListener(this);
		ChooseHero2.addActionListener(this);
		Start.addActionListener(this);
		Menu.getHeroes().add(Mage);
		Menu.getHeroes().add(Hunter);
		Menu.getHeroes().add(Warlock);
		Menu.getHeroes().add(Priest);
		Menu.getHeroes().add(Paladin);
		Menu.getJl().add(ChooseHero1,BorderLayout.NORTH );
		Menu.getJl().add(ChooseHero2,BorderLayout.CENTER );
		Menu.getJl().add(Start,BorderLayout.SOUTH );
		ImageIcon mageicon=new ImageIcon("images/Mage.png");
		Image mage2=mageicon.getImage();
		Image newmage=mage2.getScaledInstance(210,190, java.awt.Image.SCALE_SMOOTH);
		mageicon=new ImageIcon(newmage);
		Mage.setIcon(mageicon);
		mageicon=new ImageIcon("images/Hunter.png");
	    mage2=mageicon.getImage();
		newmage=mage2.getScaledInstance(210,190, java.awt.Image.SCALE_SMOOTH);
		mageicon=new ImageIcon(newmage);
		Hunter.setIcon(mageicon);
		mageicon=new ImageIcon("images/Paladin.png");
	    mage2=mageicon.getImage();
		newmage=mage2.getScaledInstance(210,190, java.awt.Image.SCALE_SMOOTH);
		mageicon=new ImageIcon(newmage);
		Paladin.setIcon(mageicon);
		mageicon=new ImageIcon("images/Warlock.png");
	    mage2=mageicon.getImage();
		newmage=mage2.getScaledInstance(210,190, java.awt.Image.SCALE_SMOOTH);
		mageicon=new ImageIcon(newmage);
		Warlock.setIcon(mageicon);
		mageicon=new ImageIcon("images/Priest.png");
	    mage2=mageicon.getImage();
		newmage=mage2.getScaledInstance(210,190, java.awt.Image.SCALE_SMOOTH);
		mageicon=new ImageIcon(newmage);
		Priest.setIcon(mageicon);
	}
	
	public void actionPerformed(ActionEvent e){
		JButton b= (JButton) e.getSource();
		if(b.getActionCommand().equals("Choose First Hero") && H1!=null && c1==0){	
			c1=1;
			s1=H1.getActionCommand();
//			System.out.println(s1);
			
			
		}
		else{
			if(!b.getActionCommand().equals("Choose First Hero") && 
			!b.getActionCommand().equals("Choose Second Hero")&&
			!b.getActionCommand().equals("Start")){
			  H1=b;
		}
			}
		
		if(b.getActionCommand().equals("Choose Second Hero") && H2!=null && c2==0){	
			c2=1;
			s2=H2.getActionCommand();
//			System.out.println(s2);
		}
		else{
			if(!b.getActionCommand().equals("Choose Second Hero") &&
					!b.getActionCommand().equals("Choose First Hero")
					&& !b.getActionCommand().equals("Start")){
			  H2=b;
		}
			}
		
		if(b.getActionCommand().equals("Start") && !s1.equals("") && !s2.equals("") ){
			
			try {
				switch(s1) {
			  case "Mage":
				  hero1=new Mage();
				break;
			  case "Hunter":
				  hero1=new Hunter();
				  break;
			  case "Paladin":
				  hero1=new Paladin();
				  break;
			  case "Priest":
				  hero1=new Priest();
				  break;
			  case "Warlock":
				  hero1=new Warlock();
				  break;
			
			}
				switch(s2) {
				  case "Mage":
					  hero2=new Mage();
					  break;
				  case "Hunter":
					  hero2=new Hunter();
					  break;
				  case "Paladin":
					  hero2=new Paladin();
					  break;
				  case "Priest":
					  hero2=new Priest();
					  break;
				  case "Warlock":
					  hero2=new Warlock();
					  break;
				
				}
				
				game=new Game(hero1,hero2);
				Menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				Menu.dispose();
				GameView=new GameView();
				conf=1;
				
	    		s1=game.getCurrentHero().getName();
				s2=game.getOpponent().getName();
				updateField();
				System.out.println("s1="+s1);
				System.out.println("s2="+s2);
				
				
				GameView.revalidate();
				GameView.repaint();
				
				} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "IOException" );
			} catch (CloneNotSupportedException e1) {
			JOptionPane.showMessageDialog(null, "CloneNotSupportedException");
			} catch (FullHandException e1) {
			JOptionPane.showMessageDialog(null,"FullHandException" );
			}
		}  
		
		
 
		
		if(hero1!=null && hero2!=null && conf==1 && !att){
			Card x=null;
			
			if(b.getActionCommand().equals("EndTurn")){
				Card x1=null;
				String q="";
				try {
					att=false;
					spp=false;
					
					if(game.getCurrentHero().getDeck().size()>0)
						{x1=game.getCurrentHero().getDeck().get(0);
						if(x1 instanceof Minion){
							Minion m=(Minion) x1;
							q="You Lost th Card:"+"\n" +m.getName();
						}else{
							Spell s=(Spell) x1;
							q="You Lost th Card:"+"\n" +s.getName() ;
						}
						
						}
					
					if(c==0)
						c=1;
					else
						c=0;
					
					
					if(game.getCurrentHero()!=null && game.getOpponent()!=null)
							game.endTurn();
					
					
				} catch (FullHandException e1) {
					
					
					if(x1 instanceof Minion){
						Minion m=(Minion) x1;
						JOptionPane.showMessageDialog(null, q );
					}else{
						Spell s=(Spell) x1;
						JOptionPane.showMessageDialog(null, q);

					}
					

				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null, "CloneNotSupportedException");
				}

//				m1=null;
//				m2=null;
//				m3=null;
				
				updateField ();
				GameView.revalidate();
				GameView.repaint();
				
			}
			if(b.getActionCommand().equals("UseHero")){
				try {
					game.getCurrentHero().useHeroPower();
					GameView.revalidate();
					GameView.repaint();
				}catch (NotEnoughManaException e1) {
					
					JOptionPane.showMessageDialog(null, "NotEnoughManaException");

				} catch (HeroPowerAlreadyUsedException e1) {
					JOptionPane.showMessageDialog(null, "HeroPowerAlreadyUsedException");
				} catch (NotYourTurnException e1) {
					JOptionPane.showMessageDialog(null, "NotYourTurnException");
				} catch (FullHandException e1) {
					JOptionPane.showMessageDialog(null, "FullHandException");
				} catch (FullFieldException e1) {
					JOptionPane.showMessageDialog(null, "FullFieldException");
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null, "CloneNotSupportedException");

				}
				updateField();

			}
			try {
			int pl=0;
			
			if(s1.equals(game.getCurrentHero().getName()) && c==0){
				for(int i=0;i<game.getCurrentHero().getHand().size()&& att==false && pl==0;i++){
					if(b.getActionCommand().equals(game.getCurrentHero().getHand().get(i).getName()+"1") && pl==0){
					if(game.getCurrentHero().getHand().get(i) instanceof Minion){
					x= game.getCurrentHero().getHand().get(i);
					Minion m=(Minion) x;
					game.getCurrentHero().playMinion(m);
					updateField();
					pl=1;
					break;
					}
					
					}
				}
		
				for(int i=0;i<game.getOpponent().getHand().size()&& att==false && pl==0;i++){
					if(b.getActionCommand().equals(game.getOpponent().getHand().get(i).getName()+"2") && pl==0){
					if(game.getOpponent().getHand().get(i) instanceof Minion){
					x= game.getOpponent().getHand().get(i);
					Minion m=(Minion) x;
					game.getOpponent().playMinion(m);
					updateField();
					pl=1;
					break;
					}
					
					
					}
				}
				
			
				
//				updateField();
				GameView.revalidate();
				GameView.repaint();
				
				
			}else{
				if(s2.equals(game.getCurrentHero().getName()) && c==1){
					for(int i=0;i<game.getCurrentHero().getHand().size()&& att==false && pl==0;i++){
						if(b.getActionCommand().equals(game.getCurrentHero().getHand().get(i).getName()+"2") && pl==0){
						if(game.getCurrentHero().getHand().get(i) instanceof Minion){
						x= game.getCurrentHero().getHand().get(i);
						Minion m=(Minion) x;
						game.getCurrentHero().playMinion(m);
						updateField();
						pl=1;
						break;
						}
						
						}
						
						
						}
						for(int i=0;i<game.getOpponent().getHand().size()&& att==false && pl==0;i++){
							if(b.getActionCommand().equals(game.getOpponent().getHand().get(i).getName()+"1") && pl==0){
							if(game.getOpponent().getHand().get(i) instanceof Minion){
							x= game.getOpponent().getHand().get(i);
							Minion m=(Minion) x;
							game.getOpponent().playMinion(m);
							updateField();
							pl=1;
							break;
							}
			
							}
						}
						
						
						GameView.revalidate();
						GameView.repaint();	
			}

				
				pl=0;
				GameView.revalidate();
				GameView.repaint();
				}
				}catch (NotYourTurnException e1) {
					JOptionPane.showMessageDialog(null, "NotYourTurnException");
				} catch (NotEnoughManaException e1) {
					JOptionPane.showMessageDialog(null, "No enough mana");
				} catch (FullFieldException e1) {
					JOptionPane.showMessageDialog(null, "FullFieldException");
					
				}
		
			for(int i=0;i<game.getCurrentHero().getField().size()&& conf==1;i++){
				if((b.getActionCommand().equals(game.getCurrentHero().getField().get(i).getName()+"4")
				||b.getActionCommand().equals(game.getCurrentHero().getField().get(i).getName()+"3"))
				&&game.getCurrentHero().getField().get(i)instanceof Minion){
				System.out.println("lalalala");
				m1=game.getCurrentHero().getField().get(i);break;
				}
			}

			for(int i=0;i<game.getOpponent().getField().size()&& conf==1;i++){
				if((b.getActionCommand().equals(game.getOpponent().getField().get(i).getName()+"4")||
					b.getActionCommand().equals(game.getOpponent().getField().get(i).getName()+"3"))
					&& game.getOpponent().getField().get(i) instanceof Minion&& m1!=null ){
					m2=game.getOpponent().getField().get(i);
					System.out.println("lalalala2");
					try {
						System.out.println("done");
						game.getCurrentHero().attackWithMinion(m1, m2);
						att=false;
						m1=null;
						m2=null;
						updateField();
						GameView.revalidate();
						GameView.repaint();
					} catch (CannotAttackException e1) {
						JOptionPane.showMessageDialog(null, "CloneNotSupportedException");
						
					} catch (NotYourTurnException e1) {
						JOptionPane.showMessageDialog(null, "NotYourTurnException");
					
					} catch (TauntBypassException e1) {
						JOptionPane.showMessageDialog(null, "TauntBypassException");
						
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, "InvalidTargetException");
						
					} catch (NotSummonedException e1) {
						JOptionPane.showMessageDialog(null, "NotSummonedException");
						
					}
		
					break;	}
			}
			for(int i=0;i<game.getOpponent().getField().size()&& conf==1;i++){
				if((b.getActionCommand().equals(game.getOpponent().getField().get(i).getName()+"4")||
					b.getActionCommand().equals(game.getOpponent().getField().get(i).getName()+"3"))
					&& game.getOpponent().getField().get(i) instanceof Minion&& m3==null ){
					m3=game.getOpponent().getField().get(i);
					System.out.println("lalalala2");
					break;
				}
			}
			for(int i=0;i<game.getCurrentHero().getField().size()&& conf==1;i++){
				if((b.getActionCommand().equals(game.getCurrentHero().getField().get(i).getName()+"4")
				||b.getActionCommand().equals(game.getCurrentHero().getField().get(i).getName()+"3"))
				&&game.getCurrentHero().getField().get(i)instanceof Minion && m3==null ){
				System.out.println("lalalala");
				m3=game.getCurrentHero().getField().get(i);
				break;
				}
			}
			
			
			for(int i=0;i<game.getCurrentHero().getHand().size()&& conf==1;i++){
				if((b.getActionCommand().equals(game.getCurrentHero().getHand().get(i).getName()+"1")
				||b.getActionCommand().equals(game.getCurrentHero().getHand().get(i).getName()+"2"))
				&&game.getCurrentHero().getHand().get(i) instanceof Spell && s==null ){
				System.out.println("Spell1");
				s=(Spell) game.getCurrentHero().getHand().get(i);
				break;
				}
			}

			for(int i=0;i<game.getOpponent().getHand().size()&& conf==1;i++){
				if((b.getActionCommand().equals(game.getOpponent().getHand().get(i).getName()+"1")
				||b.getActionCommand().equals(game.getOpponent().getHand().get(i).getName()+"2"))
				&&game.getOpponent().getHand().get(i)instanceof Spell && s==null ){
				System.out.println("Spell2");
				s=(Spell) game.getOpponent().getHand().get(i);
				break;
				}
			}
			if(b.getActionCommand().equals(game.getCurrentHero().getName())&& conf==1){
				herotarget=game.getCurrentHero();
			}
			else if(b.getActionCommand().equals(game.getOpponent().getName())&& conf==1){
				herotarget=game.getOpponent();
			}
			
			if(game.getCurrentHero().getCurrentHP()==0&& conf==1){
				JOptionPane.showMessageDialog(null,game.getOpponent().getName() +" HAS WON THE GAME");
				GameView.dispose();
		
			}
			else{if(game.getOpponent().getCurrentHP()==0&& conf==1){
				JOptionPane.showMessageDialog(null,game.getCurrentHero().getName() +" HAS WON THE GAME");
				GameView.dispose();
			}
				
			}
//			
			if(s!=null){
				System.out.println("Spellcast");
			if(s instanceof AOESpell){
				try {System.out.println("Spellcasssssssssssst");
					game.getCurrentHero().castSpell((AOESpell)s, game.getOpponent().getField());
				} catch (NotYourTurnException e1) {
					JOptionPane.showMessageDialog(null, "NotYourTurnException");
				} catch (NotEnoughManaException e1) {
					JOptionPane.showMessageDialog(null, "NotEnoughManaException");

				}
			}
			if(s instanceof MinionTargetSpell && m3!=null){
					try {System.out.println("Spellcasssssssssssst");
						game.getCurrentHero().castSpell((MinionTargetSpell)s, m3);
					} catch (NotYourTurnException e1) {
						JOptionPane.showMessageDialog(null, "NotYourTurnException");
					} catch (NotEnoughManaException e1) {
						JOptionPane.showMessageDialog(null, "NotEnoughManaException");

					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, "InvalidTargetException");

					}
				}
			if(s instanceof HeroTargetSpell && herotarget!=null ){
						try {System.out.println("Spellcasssssssssssst");
							game.getCurrentHero().castSpell((HeroTargetSpell)s, game.getOpponent());
						} catch (NotYourTurnException e1) {
							JOptionPane.showMessageDialog(null, "NotYourTurnException");
						} catch (NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, "NotEnoughManaException");

						}
					}
			if(s instanceof LeechingSpell && m3!=null){
							try {System.out.println("Spellcasssssssssssst");
								game.getCurrentHero().castSpell((LeechingSpell)s, m3);
							} catch (NotYourTurnException e1) {
								JOptionPane.showMessageDialog(null, "NotYourTurnException");
							} catch (NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, "NotEnoughManaException");

							}
						}
			if(s instanceof FieldSpell){
								try {System.out.println("Spellcasssssssssssst");
									game.getCurrentHero().castSpell((FieldSpell)s);
								} catch (NotYourTurnException e1) {
									JOptionPane.showMessageDialog(null, "NotYourTurnException");
								} catch (NotEnoughManaException e1) {
									JOptionPane.showMessageDialog(null, "NotEnoughManaException");

								}
							}
			
			if(m1!=null)
			{
				m1=null;
				m2=null;
			}	
			spp=false;
			updateField();
			GameView.revalidate();
			GameView.repaint();
			
		
	}
			att=false;
			
				if(m1!=null && herotarget!=null ){
					try {
						System.out.println("yeeeeee");
						game.getCurrentHero().attackWithMinion(m1, herotarget);
						att=false;
						updateField();
						GameView.revalidate();
						GameView.repaint();
					} catch (CannotAttackException e1) {
						JOptionPane.showMessageDialog(null, "CannotAttackException");

					} catch (NotYourTurnException e1) {
						JOptionPane.showMessageDialog(null, "NotYourTurnException");

					} catch (TauntBypassException e1) {	
						JOptionPane.showMessageDialog(null, "TauntBypassException");

					} catch (NotSummonedException e1) {
						JOptionPane.showMessageDialog(null, "NotSummonedException");

					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, "InvalidTargetException");

					}
					if(game.getCurrentHero().getCurrentHP()==0&& conf==1 ){
						JOptionPane.showMessageDialog(null,game.getOpponent().getName() +" HAS WON THE GAME");
						Glistener.onGameOver();
						GameView.dispose();
				
					}
					else{if(game.getOpponent().getCurrentHP()==0&& conf==1){
						
						JOptionPane.showMessageDialog(null,game.getCurrentHero().getName() +" HAS WON THE GAME");
						Glistener.onGameOver();
						GameView.dispose();
					}
						
					}
				
			updateField();
			GameView.revalidate();
			GameView.repaint(); 
		}
				
		}
	
		
		
		
	}	
	
	
	public void updateField(){
		m1=null;
		s=null;
		m2=null;
		m3=null;
		herotarget=null;
		GameView.getCurrHeroHand().removeAll();
		GameView.getOppHeroHand().removeAll();
		GameView.getPp1().removeAll();
		GameView.getPp2().removeAll();
		GameView.getFieldGrid1().removeAll();
		GameView.getFieldGrid2().removeAll();
		if(s1.equals(game.getCurrentHero().getName()) && c==0){
			
			for(int i=0;i<game.getCurrentHero().getHand().size();i++){
				
				JButton x=new JButton();
				x.setText(game.getCurrentHero().getHand().get(i).getName());
				x.setActionCommand(game.getCurrentHero().getHand().get(i).getName()+"1");
				x.addActionListener(this);
				JTextArea l=new JTextArea();
				l.setPreferredSize(new Dimension(150,150));
				l.setEditable(false);
				if(game.getCurrentHero().getHand().get(i) instanceof Minion){
					Minion m=(Minion) game.getCurrentHero().getHand().get(i);
					String w="";
					String e="";
					String r="";
					if(m.isDivine()){
						w="Divine";
					}
						if(m.isTaunt()){
							e="Taunt";
						}
							if(!m.isSleeping()){
								r="Charge";
							}
				
				l.setText(m.getName()
						+"\n Cost:-"+m.getManaCost()
						+"\n"+m.getRarity()
						+"\n Attack:-"+ m.getAttack()
						+"\n HP:-"+m.getCurrentHP()
						+"\n "+   w +" "+ e+" " + r);
				}
				else{
					l.setText( game.getCurrentHero().getHand().get(i).getName()+"\n"+
						game.getCurrentHero().getHand().get(i).getRarity()+"\n"+"Cost:-"+	
						game.getCurrentHero().getHand().get(i).getManaCost());
				}
				x.add(l);
				JPanel ppp=new JPanel();
				ppp.setPreferredSize(new Dimension(100,100));
				x.setPreferredSize(new Dimension(100,100));
				
				ppp.add(x);
				GameView.getCurrHeroHand().add(ppp);
			}
			for(int i=0;i<game.getCurrentHero().getField().size();i++){
				JButton x=new JButton();
				x.setText(game.getCurrentHero().getField().get(i).getName());
				x.setActionCommand(game.getCurrentHero().getField().get(i).getName()+"3");
				x.addActionListener(this);
				JPanel ppp=new JPanel();
				ppp.setPreferredSize(new Dimension(100,100));
				x.setPreferredSize(new Dimension(100,100));
				JTextArea l=new JTextArea();
				l.setPreferredSize(new Dimension(150,150));
				l.setEditable(false);
				if(game.getCurrentHero().getField().get(i) instanceof Minion){
					Minion m=(Minion) game.getCurrentHero().getField().get(i);
					String w="";
					String e="";
					String r="";
					if(m.isDivine()){
						w="Divine";
					} 
						if(m.isTaunt()){
							e="Taunt";
						}  
							if(!m.isSleeping()){
								r="Charge";
							}
				String q="";
				if(m.isSleeping()){
					q="Cant Attack";
				}else
					q="Can Attack";
				if(m.isSleeping()){
					x.setBackground(Color.red);
				}else
					x.setBackground(Color.green);
				
				l.setText(m.getName()
						+"\n Cost:-"+m.getManaCost()
						+"\n"+m.getRarity()
						+"\n Attack:-"+ m.getAttack()
						+"\n HP:-"+m.getCurrentHP()
						+"\n "+  w +" "+ e+" " + r);
				x.add(l);}
				ppp.add(x);
				GameView.getFieldGrid1().add(ppp);
			}
			JTextArea CHero=new JTextArea("CHero");
			CHero.setPreferredSize(new Dimension(150,100));
			CHero.setEditable(false);
			CHero.setBackground(Color.yellow);
			CHero.setText("Hero "+game.getCurrentHero().getName()+
					"\n CurrentHp:-"+game.getCurrentHero().getCurrentHP()
					+"\n Current Mana Crystals:- "+game.getCurrentHero().getCurrentManaCrystals() +
					"\n Total Mana Crystals:- "+ game.getCurrentHero().getTotalManaCrystals()+
					"\n Cards in Deck:- "+ game.getCurrentHero().getDeck().size());
			Hero1.setText(game.getCurrentHero().getName());
			Hero1.setActionCommand(game.getCurrentHero().getName());
			GameView.getPp1().add(Hero1);
			GameView.getPp1().add(CHero);
			GameView.getPp1().add(UseHero);
    		GameView.getPp1().add(endturn);
			for(int i=0;i<game.getOpponent().getHand().size();i++){
				JButton x=new JButton();
				x.setText(i+"");
				x.setActionCommand(game.getOpponent().getHand().get(i).getName()+"2");
				x.addActionListener(this);
				JPanel ppp=new JPanel();
				ppp.setPreferredSize(new Dimension(30,70));
				x.setPreferredSize(new Dimension(100,100));
				ppp.add(x);
				GameView.getOppHeroHand().add(ppp);
			
		}
			for(int i=0;i<game.getOpponent().getField().size();i++){
				JButton x=new JButton();
				x.setText(game.getOpponent().getField().get(i).getName());
				x.setActionCommand(game.getOpponent().getField().get(i).getName()+"4");
				x.addActionListener(this);
				JPanel ppp=new JPanel();
				ppp.setPreferredSize(new Dimension(100,100));
				x.setPreferredSize(new Dimension(100,100));
				JTextArea l=new JTextArea();
				l.setPreferredSize(new Dimension(150,150));
				l.setEditable(false);
				if(game.getOpponent().getField().get(i) instanceof Minion){
					Minion m=(Minion) game.getOpponent().getField().get(i);
				String w="";
				String e="";
				String r="";
				if(m.isDivine()){
					w="Divine";
				}
					if(m.isTaunt()){
						e="Taunt";
					} 
						if(!m.isSleeping()){
							r="Charge";
						}
				
				if(m.isSleeping()){
					x.setBackground(Color.red);
				}else
					x.setBackground(Color.green);
				
				
				l.setText(m.getName()
						+"\n Cost:-"+m.getManaCost()
						+"\n"+m.getRarity()
						+"\n Attack:-"+ m.getAttack()
						+"\n HP:-"+m.getCurrentHP()
						+"\n "+ w +" "+ e+" " + r );
				x.add(l);}
				ppp.add(x);
				GameView.getFieldGrid2().add(ppp);
			}
			
			JTextArea CHero1=new JTextArea("CHero");
    		CHero1.setPreferredSize(new Dimension(150,100));
    		CHero1.setEditable(false);
    		CHero1.setBackground(Color.cyan);
    		CHero1.setText("Hero "+game.getOpponent().getName()
    				+"\n CurrentHp:-"+game.getOpponent().getCurrentHP()
    				+"\n Current Mana Crystals:- "+game.getOpponent().getCurrentManaCrystals() +
    				"\n Total Mana Crystals:- "+ game.getOpponent().getTotalManaCrystals()+
    				"\n Cards in Deck:- "+ game.getOpponent().getDeck().size()
    				+"\n Cards in Hand:- "+game.getOpponent().getHand().size());
    		Hero2.setText(game.getOpponent().getName());
    		Hero2.setActionCommand(game.getOpponent().getName());
    		GameView.getPp2().add(Hero2);
    		GameView.getPp2().add(CHero1);
    		
		}else{
			
			
			if(s2.equals(game.getCurrentHero().getName()) && c==1){
				JTextArea CHero=new JTextArea("CHero");
				CHero.setPreferredSize(new Dimension(150,100));
				CHero.setEditable(false);
				CHero.setBackground(Color.yellow);
				CHero.setText("Hero "+game.getCurrentHero().getName()+
						"\n CurrentHp:-"+game.getCurrentHero().getCurrentHP()
						+"\n Current Mana Crystals:- "+game.getCurrentHero().getCurrentManaCrystals() +
						"\n Total Mana Crystals:- "+ game.getCurrentHero().getTotalManaCrystals()+
						"\n Cards in Deck:- "+ game.getCurrentHero().getDeck().size());
				Hero2.setText(game.getCurrentHero().getName());
				Hero2.setActionCommand(game.getCurrentHero().getName());
				GameView.getPp2().add(Hero2);
				GameView.getPp2().add(CHero);
				GameView.getPp2().add(UseHero);
	    		GameView.getPp2().add(endturn);
				for(int i=0;i<game.getCurrentHero().getHand().size();i++){
					JButton x=new JButton();
					x.setText(game.getCurrentHero().getHand().get(i).getName());
					x.setActionCommand(game.getCurrentHero().getHand().get(i).getName()+"2");
					x.addActionListener(this);
					JPanel ppp=new JPanel();
					ppp.setPreferredSize(new Dimension(30,70));
					x.setPreferredSize(new Dimension(100,100));
					JTextArea l=new JTextArea();
					l.setPreferredSize(new Dimension(150,150));
					l.setEditable(false);
					if(game.getCurrentHero().getHand().get(i) instanceof Minion){
						Minion m=(Minion) game.getCurrentHero().getHand().get(i);
						String w="";
						String e="";
						String r="";
						if(m.isDivine()){
							w="Divine";
						}
							if(m.isTaunt()){
								e="Taunt";
							} 
								if(!m.isSleeping()){
									r="Charge";
								}
					
					
					l.setText(m.getName()
							+"\n Cost:-"+m.getManaCost()
							+"\n"+m.getRarity()
							+"\n Attack:-"+ m.getAttack()
							+"\n HP:-"+m.getCurrentHP()
							+"\n "+ w +" "+ e+" " + r);}
					else{
						l.setText( game.getCurrentHero().getHand().get(i).getName()+"\n"+
							game.getCurrentHero().getHand().get(i).getRarity()+"\n"+"Cost:-"+	
							game.getCurrentHero().getHand().get(i).getManaCost());
					}
					x.add(l);
					ppp.add(x);
					GameView.getOppHeroHand().add(ppp);
			}
				for(int i=0;i<game.getCurrentHero().getField().size();i++){
					JButton x=new JButton();
					x.setText(game.getCurrentHero().getField().get(i).getName());
					x.setActionCommand(game.getCurrentHero().getField().get(i).getName()+"4");
					x.addActionListener(this);
					JPanel ppp=new JPanel();
					ppp.setPreferredSize(new Dimension(100,100));
					x.setPreferredSize(new Dimension(100,100));
					JTextArea l=new JTextArea();
					l.setPreferredSize(new Dimension(150,150));
					l.setEditable(false);
					if(game.getCurrentHero().getField().get(i) instanceof Minion){
						Minion m=(Minion) game.getCurrentHero().getField().get(i);
						String w="";
						String e="";
						String r="";
						if(m.isDivine()){
							w="Divine";
						}
							if(m.isTaunt()){
								e="Taunt";
							} 
								if(!m.isSleeping()){
									r="Charge";
								}
					
					
					String q="";
					if(m.isSleeping()){
						q="Cant Attack";
					}else
						q="Can Attack";
					
					l.setText(m.getName()
							+"\n Cost:-"+m.getManaCost()
							+"\n"+m.getRarity()
							+"\n Attack:-"+ m.getAttack()
							+"\n HP:-"+m.getCurrentHP()
							+"\n "+  w +" "+ e+" " + r);
					if(m.isSleeping()){
						x.setBackground(Color.red);
					}else
						x.setBackground(Color.green);
					x.add(l);}
					ppp.add(x);
					GameView.getFieldGrid2().add(ppp);
				}
				
				JTextArea CHero1=new JTextArea("CHero");
	    		CHero1.setPreferredSize(new Dimension(150,100));
	    		CHero1.setEditable(false);
	    		CHero1.setBackground(Color.cyan);
	    		CHero1.setText("Hero "+game.getOpponent().getName()
	    				+"\n CurrentHp:-"+game.getOpponent().getCurrentHP()
	    				+"\n Current Mana Crystals:- "+game.getOpponent().getCurrentManaCrystals() +
	    				"\n Total Mana Crystals:- "+ game.getOpponent().getTotalManaCrystals()+
	    				"\n Cards in Deck:- "+ game.getOpponent().getDeck().size()
	    				+"\n Cards in Hand:- "+game.getOpponent().getHand().size());
	    		Hero1.setText(game.getOpponent().getName());
	    		Hero1.setActionCommand(game.getOpponent().getName());
	    		GameView.getPp1().add(Hero1);
	    		GameView.getPp1().add(CHero1);
	    		
				for(int i=0;i<game.getOpponent().getHand().size();i++){
					JButton x=new JButton();
					x.setText(""+i);
					x.setActionCommand(game.getOpponent().getHand().get(i).getName()+"1");
					x.addActionListener(this);
					JPanel ppp=new JPanel();
					ppp.setPreferredSize(new Dimension(100,100));
					x.setPreferredSize(new Dimension(100,100));
					ppp.add(x);
					GameView.getCurrHeroHand().add(ppp);
				}
				for(int i=0;i<game.getOpponent().getField().size();i++){
					JButton x=new JButton();
					x.setText(game.getOpponent().getField().get(i).getName());
					x.setActionCommand(game.getOpponent().getField().get(i).getName()+"3");
					x.addActionListener(this);
					JPanel ppp=new JPanel();
					ppp.setPreferredSize(new Dimension(100,100));
					x.setPreferredSize(new Dimension(100,100));
					JTextArea l=new JTextArea();
					l.setPreferredSize(new Dimension(150,150));
					l.setEditable(false);
					if(game.getOpponent().getField().get(i) instanceof Minion){
						Minion m=(Minion) game.getOpponent().getField().get(i);
				
					String w="";
					String e="";
					String r="";
					if(m.isDivine()){
						w="Divine";
					}
						if(m.isTaunt()){
							e="Taunt";
						} 
							if(!m.isSleeping()){
								r="Charge";
							}
				
					if(m.isSleeping()){
						x.setBackground(Color.red);
					}else
						x.setBackground(Color.green);
					
					l.setText(m.getName()
							+"\n Cost:-"+m.getManaCost()
							+"\n"+m.getRarity()
							+"\n Attack:-"+ m.getAttack()
							+"\n HP:-"+m.getCurrentHP()
							+"\n "+ w +" "+ e+" " + r);
					x.add(l);}
					ppp.add(x);
					GameView.getFieldGrid1().add(ppp);
				}
				
			}
			
		}
		
	}
	
	
	public static void main(String [] args){
		   new Controller();

 
	   }

}
