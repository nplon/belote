package core.game;

import main.Constant;


public class Card {
	
	
	private final String id;
	private int value;
	private int color;
	private boolean asset;
	private int point;
	
	public Card(int value, int color) {
		this.id = color + "-" + value;
		this.value = value;
		this.color = color;
		this.asset = false;
		this.point = 0;
	}
	
	
	/**
	 * @return l'id de la carte.
	 */
	public String getId() {
		return id;
	}

	/** 
	 * 7
	 * 8
	 * 9
	 * 10
	 * 11 -> valet
	 * 12 -> dame
	 * 13 -> roi
	 * 14 -> as
	 * @return la valeur de la carte.
	 */
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * 0 -> coeur
	 * 1 -> pique
	 * 2 -> carreau
	 * 3 -> trefle
	 * 
	 * @return la couleur de la carte
	 */
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return true si la carte est un atout, false sinon.
	 */
	public boolean isAsset() {
		return asset;
	}
	
	/**
	 * Permet de d�clarer la carte comme atout ou non.
	 * @param atout true si la carte est un atour, false sinon
	 */
	public void setAsset(boolean asset) {
		this.asset = asset;
	}


	/**
	 * @return le nombre de point d'une carte
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Définit le nombre de point d'une carte
	 * 
	 * @param point Nombre de point d'une carte
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return Constant.LABELS.get(id);
	}
	
}
