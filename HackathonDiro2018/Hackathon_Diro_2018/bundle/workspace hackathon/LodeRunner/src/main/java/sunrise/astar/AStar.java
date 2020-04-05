package sunrise.astar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import sunrise.astar.*;

public class AStar {
	
	
	public static List<NodeAStar> search(Graph graph, NodeAStar start, NodeAStar goal){
		
		PriorityQueue<NodeAStar> openList = new PriorityQueue<NodeAStar>((n1,n2) -> (int) (n1.getFScore() - n2.getFScore()));
		HashSet<NodeAStar> closedList = new HashSet<NodeAStar>();
		
		start.setParent(null);
		start.setGScore(0);
		openList.add(start);
		
		while (!openList.isEmpty()) {
			NodeAStar q = openList.poll();
			
			if(q.equals(goal))
				return constructPath(start,q);
			
			@SuppressWarnings("unused")
			HashSet<Edge> m = graph.getEdgesFrom(q);
			
			for(Edge e : graph.getEdgesFrom(q)) {
				NodeAStar successor = e.getnFin();
				if (closedList.contains(successor))
					continue;
				
				double t_gScore = q.getGScore() + e.getValuePath();
				
				if(t_gScore < successor.getGScore()) {
					successor.setGScore(t_gScore);
					successor.setHScore(Math.abs(goal.getPos().getY() - successor.getPos().getY()));
					successor.calcFScore();
					
					successor.setParent(q);
					if(!openList.contains(successor)) {
						openList.add(successor);
					}
				}
				
			}

		}
		return null;
	}

	private static List<NodeAStar> constructPath(NodeAStar start, NodeAStar goal) {
		ArrayList<NodeAStar> path = new ArrayList<>();
		Stack<NodeAStar> stackNode = new Stack<NodeAStar>();
		NodeAStar t = goal;
		
		while(true){
			stackNode.add(t);
			if(t.getParent() != null) {
				t = t.getParent();
				continue;
			}
			break;
		}
		
		while(!stackNode.isEmpty()) {
			path.add(stackNode.pop());
		}
		
		return path;
	}
	
	
}

