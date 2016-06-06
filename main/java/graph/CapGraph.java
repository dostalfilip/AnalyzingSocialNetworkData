package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import graph.particles.Edge;
import graph.particles.Vertex;

/**
 * @author Filip Dostal
 */
public class CapGraph implements Graph {
	
	private HashSet<Vertex> vertexSet;
	private HashSet<Edge> edgeSet;
	
	/**
	 * Constructor
	 */
	public CapGraph() {
		vertexSet = new HashSet<Vertex>();
		edgeSet = new HashSet<Edge>();
	}
	
	/**
	 * @param Integer, add new Vertex(param) to mymap
	 */
	public void addVertex(int num) {	
		vertexSet.add(new Vertex(num));					
	}

	public void addEdge(int from, int to) {	
		edgeSet.add(new Edge(from ,to));
	}

	public CapGraph getEgonet(int center) {
		CapGraph output = new CapGraph();
		for(Vertex v : vertexSet){
			if(v.getPosition() == center){
				output.addVertex(center);
				break;
			}
		}
		if(output.vertexSet.isEmpty()) return output;
		for(Edge e : edgeSet){
			if(e.getPointA() == center){
				output.addEdge(center, e.getPointB());
				output.addVertex(e.getPointB());
			}
		}
		for(Vertex outputVertexA : output.vertexSet){
			for(Edge addEdge : edgeSet){
				if(outputVertexA.getPosition() == addEdge.getPointA() && outputVertexA.getPosition() != center){
					for(Vertex outputVertexB : output.vertexSet){
						if(outputVertexB.getPosition() == addEdge.getPointB()){
							output.addEdge(addEdge.getPointA(), addEdge.getPointB());								
							
						}
					}
				}
			}
		}	
						
		
		
		
		return output;
	}

	public List<Graph> getSCCs() {
		ArrayList<Graph> tempMap = new ArrayList<Graph>();
		//TODO THIS NEED TO IMPLEMENT WHOLE NEW ALGORITHM WITH RESERSE MATIC
		return tempMap;	
	}


	public HashMap<Integer, HashSet<Integer>> exportGraph(){
		HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<Integer, HashSet<Integer>>();
		for(Vertex i : vertexSet){
			HashSet<Integer> temp = new HashSet<Integer>();
			for(Edge e : edgeSet){
				if(e.getPointA() == i.getPosition()){
					temp.add(e.getPointB());
				}
			}
			myGraph.put(i.getPosition(), temp);
		}

		
		
		return myGraph;
	}

	@Override
	public String toString(){
		String output = "All Vertex: " + vertexSet.size() + "\n";
		for(Vertex n : vertexSet){
			output += n.toString() + "\n";
		}
		
		output += "\nAll Edge: " + edgeSet.size() + "\n";
		for(Edge n : edgeSet){
			output += n.toString() + "\n";
		}
		
		return output;
	}
}
