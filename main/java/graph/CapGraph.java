package graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import java.util.Set;


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

	public List<Graph> getSCCs(){
		List<Graph> scc = new ArrayList<Graph>();

				Deque<Vertex> vysledek2 = new ArrayDeque<Vertex>();
				vysledek2 = dfs(this, getVertexSet());
				
				//dfsreverse
				HashSet<Vertex> visited = new HashSet<Vertex>();
				
				while(!vysledek2.isEmpty()){
					CapGraph curr = new CapGraph();
					ArrayDeque<Vertex> finish = new ArrayDeque<Vertex>();
					if(!visited.contains(vysledek2.peekLast())){

						dfsVisit(getTranspositionGraph(this),vysledek2.pollLast(),visited,finish);
System.out.println("---------------");
						while(!finish.isEmpty()){
							visited.add(finish.peek());
							System.out.println(finish.peek());
							curr.addVertex(finish.poll().getPosition());
							
						}
System.out.println("**************");
						if(!curr.getVertexSet().isEmpty()){
							scc.add(curr);							
						}
					}
					else{
						vysledek2.pollLast();	
					}
				}

				
				
				
		return scc;
	}

	
	public Deque<Vertex> dfs(Graph graph, HashSet<Vertex> vertices){
		ArrayDeque<Vertex> finish = new ArrayDeque<Vertex>();
		HashSet<Vertex> visited = new HashSet<Vertex>();
		for(Vertex curr : vertices){
			if(!visited.contains(curr) && curr!= null){
				dfsVisit(graph, curr, visited, finish);
			}
		}
		return finish;	
	}

	public void dfsVisit(Graph graph, Vertex v, Set<Vertex> visited, ArrayDeque<Vertex> finish){
		visited.add(v);
		for(int i : graph.exportGraph().get(v.getPosition())){
			if(!visited.contains(new Vertex(i))){
				dfsVisit(graph, new Vertex(i), visited, finish);
			}
		}
		finish.add(v);			
	}


	public CapGraph getTranspositionGraph(CapGraph g){
		CapGraph outputGraph = new CapGraph();
		for(Vertex v : g.vertexSet){
			outputGraph.addVertex(v.getPosition());
		}
		for(Edge e : g.edgeSet){
			outputGraph.addEdge(e.getPointB(), e.getPointA());
		}
		return outputGraph;
	}

	public HashMap<Integer, HashSet<Integer>> exportGraph(){
		HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<Integer, HashSet<Integer>>();
		for(Vertex i : vertexSet){
			/**
			 * init hashSet
			 */
			HashSet<Integer> temp = new HashSet<Integer>();
			myGraph.put(i.getPosition(), temp);
		}
		for(Edge e : edgeSet){
			/**
			 * add items to HashSet
			 */
			HashSet<Integer> temp = myGraph.get(e.getPointA());
			temp.add(e.getPointB());
			myGraph.put(e.getPointA(), temp);
		}
		return myGraph;
	}

	public HashMap<Integer, HashSet<Integer>> exportGraph(CapGraph currGraph){
		HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<Integer, HashSet<Integer>>();
		for(Vertex i : currGraph.vertexSet){
			HashSet<Integer> temp = new HashSet<Integer>();
			myGraph.put(i.getPosition(), temp);
		}
		for(Edge e : currGraph.edgeSet){
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
	
	public HashSet<Vertex> getVertexSet(){
		return vertexSet;
	}
	
	public HashSet<Edge> getEdgeSet(){
		return edgeSet;
	}


	
}
