package graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

	//TODO
	public List<Graph> getSCCs() {
		ArrayList<Graph> outputListGraph = new ArrayList<Graph>();
		HashMap<Integer, HashSet<Integer>> graphMap = exportGraph();
		HashSet<Vertex> visited = new HashSet<Vertex>();
		Deque<Vertex> finishStack = new ArrayDeque<Vertex>();
		for(Vertex v : vertexSet){
			if(!visited.contains(v)){

				visitDFS(this, v, visited,
						finishStack,graphMap);
			}
		}
		visited.clear();
		CapGraph temp = getTranspositionGraph(this);
		Vertex v2 = finishStack.pop();
		while(v2 != null){
			
			if(!visited.contains(v2)){
				visitDFS(this, v2, visited,
						finishStack,graphMap);
			}
			
			
			
			
		}
		return outputListGraph;	
	}
	//TODO
	private Deque<Vertex> dFS(CapGraph outputListGraph, Vertex v,
			HashSet<Vertex> visited, Deque<Vertex> finishStack,
			HashMap<Integer, HashSet<Integer>> graphMap){
		
		return null;
	}
	
	//TODO
	private Deque<Vertex> visitDFS(CapGraph outputListGraph, Vertex v,
			HashSet<Vertex> visited, Deque<Vertex> finishStack,
			HashMap<Integer, HashSet<Integer>> graphMap){
		visited.add(v);
		for(int n : graphMap.get(v.getPosition())){
			if(!visited.contains(new Vertex(n))){
				visitDFS(outputListGraph, new Vertex(n), visited,
						finishStack,graphMap); 
			}
			finishStack.add(v);
		}
		return finishStack;
	}

	private CapGraph getTranspositionGraph(CapGraph g){
		CapGraph outputGraph = new CapGraph();
		for(Vertex v : vertexSet){
			outputGraph.addVertex(v.getPosition());
		}
		for(Edge e : edgeSet){
			outputGraph.addEdge(e.getPointB(), e.getPointA());
		}
		return outputGraph;
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
