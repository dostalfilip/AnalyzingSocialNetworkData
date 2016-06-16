package graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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
		/**
		 * output init
		 */
		ArrayList<Graph> outputListGraph = new ArrayList<Graph>();
		final HashMap<Integer, HashSet<Integer>> exportGraph = exportGraph();
		/**
		 * 1
		 */
		HashSet<Vertex> visited = new HashSet<Vertex>();
		Deque<Vertex> finish = new ArrayDeque<Vertex>();
		
		for(Integer vertexPosition : exportGraph.keySet()){
			Vertex currVertex = new Vertex(vertexPosition);
			if(!visited.contains(currVertex)){
				finish = dfsVisit(currVertex,visited , finish);
			}
		}
		
		/**
		 * 2
		 */
		
		CapGraph reverseGraph = getTranspositionGraph(this);
		/**
		 * 3
		 */
		/*System.out.println("Celkovy pocet vertexu: " + exportGraph.size());
		System.out.println("Visited size: " + visited.size());
		System.out.println("Finish size: " + finish.size());
		System.out.println(finish.size() == visited.size());
		/**
		 * return
		 */
		visited.clear();
		while(!finish.isEmpty()){
			CapGraph currNew = new CapGraph();
			Vertex currVertex = finish.poll();				
			if(!visited.contains(currVertex)){
				
				HashSet<Integer> output = new HashSet<Integer>();
				output = dfsVisitreverse(reverseGraph, currVertex, output);
				
				for(int i : output){
					if(!visited.contains(new Vertex(i))){	
						visited.add(new Vertex (i));
						currNew.addVertex(i);						
					}
				}
				if(currNew.vertexSet.size()>0){
					outputListGraph.add(currNew);
				}
			}												
		}
		
		return outputListGraph;	
	}
	
	private Deque<Vertex> dfsVisit(Vertex v, HashSet<Vertex> visited, Deque<Vertex> finishStack){
		visited.add(v);
		
		for(int vertexPosition : exportGraph().get(v.getPosition())){
			Vertex currVertex = new Vertex(vertexPosition);
		
			if(!visited.contains(currVertex)){
				dfsVisit(currVertex, visited, finishStack);
			}

			finishStack.add(currVertex);								
			
			//System.out.println(currVertex);
		}
		return finishStack;
	}
 
	private HashSet<Integer> dfsVisitreverse(CapGraph currGraph, Vertex v , HashSet<Integer> output) {
		
		
		for(int n : exportGraph(currGraph).get(v.getPosition())){
			
			if(!output.contains(n)){
				output.add(n);

				for (int i : dfsVisitreverse(currGraph, new Vertex(n), output)){
					if(!output.contains(i)){
						output.add(i);
					}
				}
			}
			
		}
		return output;
	}
	
	/*		
	private Deque<Vertex> dfsreverse(CapGraph outputListGraph, Deque<Vertex> infinishStack){
		HashSet<Vertex> visited = new HashSet<Vertex>();
		Deque<Vertex> finishStack = new ArrayDeque<Vertex>();
		while(!infinishStack.isEmpty()){
			Vertex v = infinishStack.pop();
			if(!visited.contains(v)){
				dfsVisitreverse(outputListGraph, v, visited, finishStack);
			}
		}
		return finishStack;
	}
	
	
	private Deque<Vertex> dfs(CapGraph outputListGraph){
		HashSet<Vertex> visited = new HashSet<Vertex>();
		Deque<Vertex> finishStack = new ArrayDeque<Vertex>();
		for(Vertex v : vertexSet){
			if(!visited.contains(v)){
				dfsVisit(outputListGraph, v, visited, finishStack);
			}
		}
		return finishStack;
	}
	
	

	}*/

	public CapGraph getTranspositionGraph(CapGraph g){
		CapGraph outputGraph = new CapGraph();
		for(Vertex v : g.vertexSet){
			outputGraph.addVertex(v.getPosition());
			//System.out.println(v);
		}
		for(Edge e : g.edgeSet){
			outputGraph.addEdge(e.getPointB(), e.getPointA());
			//System.out.println(e);
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
