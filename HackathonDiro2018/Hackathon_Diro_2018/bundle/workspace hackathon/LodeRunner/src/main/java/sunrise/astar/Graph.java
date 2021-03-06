package sunrise.astar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import sunrise.GameEntity;
import sunrise.astar.*;
import sunrise.vector.*;

public class Graph {

	HashMap<NodeAStar,LinkedHashSet<Edge>> graph;
	
	public Graph() {
		graph = new HashMap<NodeAStar,LinkedHashSet<Edge>>();
	}
	
	public Graph(GameEntity[][] map) {
		graph = new HashMap<NodeAStar,LinkedHashSet<Edge>>();
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				int[] edges = map[i][j].getCost();
					if(j-1 >= 0){
						addEdge(new NodeAStar(new Vector2d(i,j-1)),new Edge(new NodeAStar(new Vector2d(i,j)),edges[2]));
					}
					
					if(i-1 >= 0){
						addEdge(new NodeAStar(new Vector2d(i- 1,j)),new Edge(new NodeAStar(new Vector2d(i,j)),edges[1]));
					}
					
					if(j+1 < map[0].length){
						addEdge(new NodeAStar(new Vector2d(i,j+1)),new Edge(new NodeAStar(new Vector2d(i,j)),edges[0]));
					}
					
					if(i+1 < map.length){
						addEdge(new NodeAStar(new Vector2d(i+1,j)),new Edge(new NodeAStar(new Vector2d(i,j)),edges[3]));
					}
					
				}
			}
		System.out.println("VEFED");
		}
		
	
	public void addNode(NodeAStar n) {
		graph.putIfAbsent(n, new LinkedHashSet<Edge>());
	}
	
	public void addEdge(NodeAStar n, Edge edge) {
		addNode(n);
		graph.get(n).add(edge);
	}
	
	public LinkedHashSet<Edge> getEdgesFrom(NodeAStar n) {
		return graph.get(n);
	}
	
	public NodeAStar getNodeAtPos(Vector2d pos) {
	    Iterator<Entry<NodeAStar, LinkedHashSet<Edge>>> i = graph.entrySet().iterator();
	    while(i.hasNext()) {
	    	Entry<NodeAStar, LinkedHashSet<Edge>> next = i.next();
	    	
	    	for(Edge e : next.getValue()) {
	    		if(e.getnFin().getPos().equals(pos))
	    			return e.getnFin();
	    	}
	    }
	    return null;
	}
}
