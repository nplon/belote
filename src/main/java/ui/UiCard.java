package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Constant;
import controler.command.Command;
import controler.command.CommandPlay;
import controler.ui.UiControlerBelote;
import core.game.Card;

public class UiCard extends JPanel implements MouseListener{

	private Card card; //TODO : Faire sauter la d�pendance.
	private JLabel content;
	private Command command;
	private UiControlerBelote controler;
	private int player;
	
	private static final long serialVersionUID = -137142180498700264L;
	
	public UiCard(UiControlerBelote controler, int player){
		super();
		content = new JLabel();
		content.setPreferredSize(new Dimension(72,96));
		this.controler = controler;
		this.player = player;
		this.addMouseListener(this);
		this.add(content);
		this.setBackground(Color.decode("#3A9D23"));
	}
	
	/**
	 * Dessine une carte.
	 * 
	 * @param card Carte � afficher
	 */
	public void drawCard(Card card){
		if(card == null){
			content.setIcon(null);
		}
		else {
			this.card = card;
			content.setIcon(new ImageIcon(Constant.CARDSOURCE + card.getId() +".gif"));
		}
	}

	public Card getCard() {
		return card;
	}	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		command = new CommandPlay(controler, card, player);
		command.execute();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
