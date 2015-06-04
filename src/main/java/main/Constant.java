package main;

import java.util.HashMap;

public class Constant {

    public final static HashMap<String, String> LABELS = new HashMap<String, String>();
    static {
    	LABELS.put("0-2", "2 de coeur");
		LABELS.put("0-3", "3 de coeur");
		LABELS.put("0-4", "4 de coeur");
		LABELS.put("0-5", "5 de coeur");
		LABELS.put("0-6", "6 de coeur");
		LABELS.put("0-7", "7 de coeur");
		LABELS.put("0-8", "8 de coeur");
		LABELS.put("0-9", "9 de coeur");
		LABELS.put("0-10", "10 de coeur");
		LABELS.put("0-11", "valet de coeur");
		LABELS.put("0-12", "dame de coeur");
		LABELS.put("0-13", "roi de coeur");
		LABELS.put("0-14", "as de coeur");

		LABELS.put("1-2", "2 de pique");
		LABELS.put("1-3", "3 de pique");
		LABELS.put("1-4", "4 de pique");
		LABELS.put("1-5", "5 de pique");
		LABELS.put("1-6", "6 de pique");
		LABELS.put("1-7", "7 de pique");
		LABELS.put("1-8", "8 de pique");
		LABELS.put("1-9", "9 de pique");
		LABELS.put("1-10", "10 de pique");
		LABELS.put("1-11", "valet de pique");
		LABELS.put("1-12", "dame de pique");
		LABELS.put("1-13", "roi de pique");
		LABELS.put("1-14", "as de pique");
		
		LABELS.put("2-2", "2 de carreau");
		LABELS.put("2-3", "3 de carreau");
		LABELS.put("2-4", "4 de carreau");
		LABELS.put("2-5", "5 de carreau");
		LABELS.put("2-6", "6 de carreau");
		LABELS.put("2-7", "7 de carreau");
		LABELS.put("2-8", "8 de carreau");
		LABELS.put("2-9", "9 de carreau");
		LABELS.put("2-10", "10 de carreau");
		LABELS.put("2-11", "valet de carreau");
		LABELS.put("2-12", "dame de carreau");
		LABELS.put("2-13", "roi de carreau");
		LABELS.put("2-14", "as de carreau");
		
		LABELS.put("3-2", "2 de trèfle");
		LABELS.put("3-3", "3 de trèfle");
		LABELS.put("3-4", "4 de trèfle");
		LABELS.put("3-5", "5 de trèfle");
		LABELS.put("3-6", "6 de trèfle");
		LABELS.put("3-7", "7 de trèfle");
		LABELS.put("3-8", "8 de trèfle");
		LABELS.put("3-9", "9 de trèfle");
		LABELS.put("3-10", "10 de trèfle");
		LABELS.put("3-11", "valet de trèfle");
		LABELS.put("3-12", "dame de trèfle");
		LABELS.put("3-13", "roi de trèfle");
		LABELS.put("3-14", "as de trèfle");
	}
    
    public final static HashMap<String, Integer> BELOTEPOINTS = new HashMap<String, Integer>();
    static {

    	BELOTEPOINTS.put("7", 0);
    	BELOTEPOINTS.put("8", 0);
    	BELOTEPOINTS.put("9", 0);
    	BELOTEPOINTS.put("10", 10);
    	BELOTEPOINTS.put("11", 2);
    	BELOTEPOINTS.put("12", 3);
    	BELOTEPOINTS.put("13", 4);
    	BELOTEPOINTS.put("14", 11);
    }
    
    public final static HashMap<String, Integer> BELOTEASSETPOINTS = new HashMap<String, Integer>();
    static {

    	BELOTEASSETPOINTS.put("7", 0);
    	BELOTEASSETPOINTS.put("8", 0);
    	BELOTEASSETPOINTS.put("9", 14);
    	BELOTEASSETPOINTS.put("10", 10);
    	BELOTEASSETPOINTS.put("11", 20);
    	BELOTEASSETPOINTS.put("12", 3);
    	BELOTEASSETPOINTS.put("13", 4);
    	BELOTEASSETPOINTS.put("14", 11);
    }    
    
    public final static HashMap<String, Integer> CARDCOLOR = new HashMap<String, Integer>();
    static {

    	CARDCOLOR.put("heart", 0);
    	CARDCOLOR.put("spade", 1);
    	CARDCOLOR.put("diamond", 2);
    	CARDCOLOR.put("club", 3);
    	
    }
    
    public static final String CARDSOURCE = "C:/Users/pillon/Dropbox/workspace/belote/src/main/resources/img/cards/";
    
    public static final String UISOURCE = "C:/Users/pillon/Dropbox/workspace/belote/src/main/resources/img/ui/";
    
    
}
