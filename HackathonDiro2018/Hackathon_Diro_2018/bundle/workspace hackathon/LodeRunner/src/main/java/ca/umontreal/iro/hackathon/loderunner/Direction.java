package ca.umontreal.iro.hackathon.loderunner;

import java.util.List;

import sunrise.astar.NodeAStar;

public enum Direction {
    NONE(0), UP(1), LEFT(2), DOWN(3), RIGHT(4);
    
    private final int id;

    Direction(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
    
    public static Direction fromInt(int n) {
        switch(n) {
            case 1:
                return UP;
            case 2:
                return LEFT;
            case 3:
                return DOWN;
            case 4:
                return RIGHT;
        }

        return NONE;
    }
    
    public static int prochaineDirectionAStar(List<NodeAStar> listeDeNoeud, int pos){
    	NodeAStar noeudInitiale = listeDeNoeud.get(pos);
    	NodeAStar noeudFinale = listeDeNoeud.get(pos + 1);
    	double x= noeudInitiale.getPos().getX() -  noeudFinale.getPos().getX();
    	double y= noeudInitiale.getPos().getY() -  noeudFinale.getPos().getY();
    	if(x == 0) {
    		if (y>0) {
    			return 1;
    		}else {
    			return 3;
    		}
    	}else {
    		if (x>0) {
    			return 2;
    		}else {
    			return 4;
    		}
    	}
    	
    }
}
