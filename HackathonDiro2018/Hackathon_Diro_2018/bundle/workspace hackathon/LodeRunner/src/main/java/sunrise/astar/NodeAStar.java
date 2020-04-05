package sunrise.astar;

import sunrise.vector.Vector2d;

public class NodeAStar {
	
	private final int MOV_COST = 1;
	
	private NodeAStar parent = null;
	private Vector2d pos;
	
	private double fScore = 0,gScore = 255,hScore = MOV_COST;

	public NodeAStar(Vector2d pos) {
		this.pos = pos;
	}
	
	public NodeAStar getParent() {
		return parent;
	}

	public void setParent(NodeAStar parent) {
		this.parent = parent;
	}

	public double getFScore() {
		return fScore;
	}

	public void calcFScore() {
		this.fScore = gScore + hScore;
	}

	public double getGScore() {
		return gScore;
	}
	
	public void setGScore(double gScore) {
		this.gScore = gScore;
	}

	public double getHScore() {
		return hScore;
	}
	
	public void setHScore(double hScore) {
		this.hScore = hScore;
	}

	public Vector2d getPos() {
		return pos;
	}

	public void setPos(Vector2d pos) {
		this.pos = pos;
	}
	
	public boolean equals(Object obj) {
		 if(this == obj)
		      return true;
		    
		    if(obj == null)
		      return false;
		    
		    if(!(obj instanceof NodeAStar))
		      return false;
		NodeAStar n  = (NodeAStar) obj;
		if(pos.equals(n.getPos()))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return pos.hashCode();
	}
	
	@Override
	public String toString() {
		return pos.toString();
		}
	}
