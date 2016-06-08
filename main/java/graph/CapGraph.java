package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
		if(!vertexSet.contains(new Vertex(num)))
		vertexSet.add(new Vertex(num));					
	}

	public void addEdge(int from, int to) {	
		if(!edgeSet.contains(new Edge(from, to)))
		edgeSet.add(new Edge(from ,to));
	}

	/**
	 * This is crucial algorithm whitch creates Egonet´s CapGraph
	 * @param Integer represent center of Egonet
	 */
	public CapGraph getEgonet(int center) {
		HashMap<Integer, HashSet<Integer>> tempHash = exportGraph();	
		CapGraph output = new CapGraph();
				
		if(!vertexSet.contains((new Vertex(center)))){
			return output;
		}
		else{
			output.addVertex(center);
		}

		for(int iVertex : tempHash.get(center)){
			output.addEdge(center, iVertex);
			output.addVertex(iVertex);			
		}

		for(Vertex v : output.vertexSet){
			for(int edge : tempHash.get(v.getPosition())){
				if(output.vertexSet.contains((new Vertex(edge)))){
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
