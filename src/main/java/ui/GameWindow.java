package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import controler.command.CommandOne;
import controler.command.CommandTakeAsset;
import controler.ui.UiControlerBelote;
//TODO Faire sauter les d�pendances au core.
import core.game.Card;
import core.player.belote.PlayerBelote;

public class GameWindow extends JFrame implements ActionListener
{ 

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(GameWindow.class);
	
	private UiControlerBelote controler;
	
	private ArrayList<ArrayList<UiCard>> players_cards;
	private ArrayList<UiCard> playedCards;

	private JPanel actionPanel, scorePanel, gamePanel, centerPanel;	
	private JPanel player1, player2, player3, player4;
	private JPanel player2_cards_panel, player4_cards_panel;
	private JLabel takeQuestion;
	private JLabel player1_name, player2_name, player3_name, player4_name; 
	private UiCard asset; 
	private UiButton one, two;
	private ArrayList<UiButton> assetButtons;
	
	private JMenuBar mbar;
	private JMenu m1;
	private JMenu m2;

	public GameWindow(String title, UiControlerBelote uiControler)
	{ 
		setTitle(title);
		setSize(1200,600);
		
		this.controler = uiControler;
		
		// gestion evenementielle de la fermeture de la fen�tre
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);  
			}
		});

		// utilisation d'un toolkit pour l'affichage
		// d'une icone associ�e � la fen�tre
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image JFrameIcon = tk.getImage("icon.gif");
		setIconImage(JFrameIcon);

		// Ajout d'une barre de menus � la fen�tre
		mbar = new JMenuBar();
		m1 = new JMenu("Fichier");

		JMenuItem m11 = new JMenuItem("Debug");
		m11.addActionListener(this); // installation d'un �couteur d'action
		m1.add(m11);  // ajout d'une option � un menu

		JMenuItem m12 = new JMenuItem("Fermer");
		m12.addActionListener(this);
		m1.add(m12);

		m2 = new JMenu("Aide");
		JMenuItem m21 = new JMenuItem("A propos");
		m21.addActionListener(this);
		m2.add(m21);

		mbar.add(m1);  // ajout de menus � la barre de menus
		mbar.add(m2);
		setJMenuBar(mbar);
		
		
		//Gestion des panels :
		Container window = getContentPane();
		window.setLayout(new BorderLayout());
		
		//Panel des menus	
		actionPanel = new JPanel();
		actionPanel.setLayout(new FlowLayout());
		
		takeQuestion = new JLabel(controler.getCurrentPlayer().getName() + " voulez vous prendre ?");

		one = new UiButton(new CommandOne(controler), "one");
		two = new UiButton(new CommandOne(controler), "two");
		two.setVisible(false);
		
		actionPanel.add(takeQuestion);
		
		assetButtons = new ArrayList<UiButton>();
		for (int i = 0; i < 4; i++){
			UiButton b = new UiButton(new CommandTakeAsset(controler, i), i+"");
			b.setVisible(false);
			assetButtons.add(b);
			actionPanel.add(b);
		}

		actionPanel.add(two);
		actionPanel.add(one);
		
		
		// Panel des scores
		scorePanel = new JPanel();
		scorePanel.setLayout(new BorderLayout());
		
		JPanel equipes = new JPanel();
		equipes.setLayout(new GridLayout(6,2));
		equipes.add(new JLabel("Equipe1 : "),0,0);
		equipes.add(new JLabel("Score 1"),0,1);
		equipes.add(new JLabel("Nom 1"),1,0);
		equipes.add(new JLabel("Nom 3"),2,0);
		equipes.add(new JLabel("Equipe2 : "),3,0);
		equipes.add(new JLabel("Score 2"),3,1);
		equipes.add(new JLabel("Nom 2"),4,0);
		equipes.add(new JLabel("Nom 4"),5,0);
		
		scorePanel.add(equipes, BorderLayout.CENTER);
		
		window.add(scorePanel, BorderLayout.EAST);
		
		// Panel principal
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.decode("#3A9D23"));
		gamePanel.setLayout(new BorderLayout());
		
		
		// Centre
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.decode("#3A9D23"));
		centerPanel.setLayout(new BorderLayout());
		
		
		asset = new UiCard(controler, -1);
		
		playedCards = new ArrayList<UiCard>(4);
		for (int i = 0; i<4; i++){
			UiCard c = new UiCard(controler, -1);
			c.setVisible(false);
			playedCards.add(c);
		}
		
		centerPanel.add(playedCards.get(0), BorderLayout.SOUTH);
		centerPanel.add(playedCards.get(1), BorderLayout.WEST);
		centerPanel.add(playedCards.get(2), BorderLayout.NORTH);
		centerPanel.add(playedCards.get(3), BorderLayout.EAST);
		
		centerPanel.add(asset, BorderLayout.CENTER);	
		gamePanel.add(centerPanel, BorderLayout.CENTER);
		
		
		
		
		// Joueurs init 
		players_cards = new ArrayList<ArrayList<UiCard>>(4);
			
		for (int j = 0; j<4;j++){
			players_cards.add(new ArrayList<UiCard>(8));
			
			for(int i = 0; i<8; i++){
				players_cards.get(j).add(new UiCard(controler, j));
			}			
		}
		
		
		
		// Joueur 1
		player1 = new JPanel();
		player1.setBackground(Color.decode("#3A9D23"));
		player1_name = new JLabel(uiControler.getPlayer(0).getName());
		
		player1.add(player1_name);
		
		for (UiCard card : players_cards.get(0)) {
			player1.add(card);
		}
		gamePanel.add(player1,  BorderLayout.SOUTH);
		
		// Joueur 2
		player2 = new JPanel();
		player2.setBackground(Color.decode("#3A9D23"));
		player2_name = new JLabel(uiControler.getPlayer(1).getName());
			
		player2_cards_panel = new JPanel();
		player2_cards_panel.setBackground(Color.decode("#3A9D23"));
		player2_cards_panel.setLayout(new GridLayout(2,4));
				
		for(int i = 0; i<2 ; i++){
			for(int j = 0; j<4 ; j++){
				player2_cards_panel.add(players_cards.get(1).get(i*4+j),i,j);
			}
		}
	
		player2.add(player2_name);
		player2.add(player2_cards_panel);
		gamePanel.add(player2,  BorderLayout.WEST);
		
		// Joueur 3
		player3 = new JPanel();
		player3.setBackground(Color.decode("#3A9D23"));
		player3_name = new JLabel(uiControler.getPlayer(2).getName());
		player3.add(player3_name);
		for (UiCard card : players_cards.get(2)) {
			player3.add(card);
		}
		gamePanel.add(player3,  BorderLayout.NORTH);
		
		// Joueur 4
		player4 = new JPanel();
		player4.setBackground(Color.decode("#3A9D23"));
		player4_name = new JLabel(uiControler.getPlayer(3).getName());
		player4.add(player4_name);

		player4_cards_panel = new JPanel();
		player4_cards_panel.setLayout(new GridLayout(2,4));
		player4_cards_panel.setBackground(Color.decode("#3A9D23"));

		for(int i = 0; i<2 ; i++){
			for(int j = 0; j<4 ; j++){
				player4_cards_panel.add(players_cards.get(3).get(i*4+j),i,j);
			}
		}
		
		player4.add(player4_cards_panel);

		gamePanel.add(player4, BorderLayout.EAST);

		window.add(gamePanel, BorderLayout.CENTER);
		window.add(actionPanel, BorderLayout.SOUTH);
		window.setBackground(Color.decode("#3A9D23"));
		this.setVisible(true);

	}

	
	/**
	 * Affiche les cartes.
	 */
	public void displayHand(){
		
		int i;
		int j = 0;
		
		for (PlayerBelote player : controler.getPlayers()) {
			i = 0;
			for (Card card : player.getHand()) {
				if(j==0 || logger.isDebugEnabled()){
					players_cards.get(j).get(i).drawCard(card);
					i++;
				}
				else{
					players_cards.get(j).get(i).drawCard(null);
					i++;
				}
			};
			
			for(;i<8;i++){
				players_cards.get(j).get(i).drawCard(null);
			}
		j++;	
		}
	}
	

	/**
	 * Affiche l'atout.
	 * 
	 * @param asset Carte � afficher en tant qu'atout.
	 */
	public void displayAsset(Card asset) {
		if(asset!=null){
			this.asset.drawCard(asset);
			
			assetButtons.get(asset.getColor()).setVisible(true);
			
			this.asset.setVisible(true);
		}
		
		actionPanel.setVisible(true);
	}
	

	public void displayPlayedCard(Card card, int player){
		playedCards.get(player).setVisible(true);
		playedCards.get(player).drawCard(card);		
	}
	
	/**
	 * Met � jour l'assetPanel.
	 */
	public void refreshActionPanel() {
		takeQuestion.setText(controler.getCurrentPlayer().getName() + " voulez vous prendre ?");
		
		if(controler.getSkip() == 2){
			one.setVisible(false);
			two.setVisible(true);
			
			for (int i = 0; i < assetButtons.size(); i++){
				assetButtons.get(i).setVisible(i != asset.getCard().getColor());
			}
		}
		else {
			one.setVisible(true);
			two.setVisible(false);
			
			for (int i = 0; i < assetButtons.size(); i++){
				assetButtons.get(i).setVisible(i == asset.getCard().getColor());
			}
		}
	}
	
	/**
	 * Distribue l'atout et d�clenche la seconde distribution.
	 */
	public void closeAssetManagement(){
			asset.setVisible(false);
			actionPanel.setVisible(false);
	}
	
	/**
	 * Efface les cartes jou�es au centre. 
	 */
	public void eraseCenter() {
		
		playedCards.get(0).drawCard(null);
		playedCards.get(1).drawCard(null);
		playedCards.get(2).drawCard(null);
		playedCards.get(3).drawCard(null);
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent evt)
	{  
		// gestion des évènements liés aux menus
		if (evt.getSource()instanceof JMenuItem) 
		{ 
			String ChoixOption = evt.getActionCommand();
			if (ChoixOption.equals("Debug")) {		
				
				if(!logger.isDebugEnabled()){
					Logger.getRootLogger().setLevel(Level.DEBUG);
					logger.info("Activation du mode debug");
				} else {
					Logger.getRootLogger().setLevel(Level.INFO);
					logger.info("Désactivation du mode debug");
				}
				
				displayHand();
			}	
			else if(ChoixOption.equals("Fermer")) {
				System.exit(0);  
			}
			else if(ChoixOption.equals("A propos")) {
				JOptionPane.showMessageDialog(null, "IHM de test Belote v0.1");
			}
		}
	}
}