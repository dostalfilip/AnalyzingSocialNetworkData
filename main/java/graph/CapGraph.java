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
	
	
	public boolean containsVertex(Vertex numHash){
		if(vertexSet.contains(numHash)){
			return true;
		}
		return false;
	}
	
	public boolean containsEdge(Edge numHash){
		if(edgeSet.contains(numHash)){
			return true;
		}
		return false;
	}

	/**
	 * This is crucial algorithm whitch creates Egonet´s CapGraph
	 * @param Integer represent center of Egonet
	 */
	public CapGraph getEgonet(int center) {
		CapGraph output = new CapGraph();
		if(!containsVertex(new Vertex(center))){
			return output;
		}
		HashMap<Integer, HashSet<Integer>> tempHash = exportGraph();

		//ArrayList<Vertex> tempArray = new ArrayList<Vertex>();
		//tempArray.add(new Vertex(center));
		output.addVertex(center);
		for(int iVertex : tempHash.get(center)){
			output.addEdge(center, iVertex);
			output.addVertex(iVertex);
			//tempArray.add(new Vertex(iVertex));
		}
		//weeerd part of code 
		//TODO First attempt
/*			for(int iVertex = 0 ; iVertex < tempArray.size() ; iVertex++){
			int position = iVertex +1 ;
			int pointA = tempArray.get(iVertex).getPosition();
			while(position < tempArray.size()){
				
				int pointB = tempArray.get(position).getPosition();
				
				if(edgeSet.contains(new Edge(pointA, pointB))){
					output.addEdge(pointA,pointB);
					if(pointA== 22 && pointB == 8332) System.out.println("true");
				}
				if(edgeSet.contains(new Edge(pointB, pointA))){
					output.addEdge(pointB,pointA);
				}
				position++;
			}
		}*/
		
		//second attempt TROUBLE
		//TODO
		for(Vertex v : output.vertexSet){
			HashSet<Integer> tempEdge = tempHash.get(v.getPosition());
			for(int edge : tempEdge){
				if(output.containsVertex(new Vertex(edge))){
					output.addEdge(v.getPosition(), edge);
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
			myGraph.put(i.getPosition(), temp);
		}
		for(Edge e : edgeSet){
			HashSet<Integer> temp = myGraph.get(e.getPointA());
			temp.add(e.getPointB());
			myGraph.put(e.getPointA(), temp);
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
