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
			if(!finish.contains(currVertex)){
				finish = dfsVisit(currVertex,visited , finish);
			}
		}
 
		
		
		///2
		///3
		
		
		
		visited.clear();
		while(!finish.isEmpty()){
			//System.out.println("vstupni kontrola" + finish.peek());
			CapGraph currNew = new CapGraph();
			Vertex currVertex = finish.poll();				
			if(!visited.contains(currVertex)){
				
				HashSet<Integer> outputAllDuplexVertex = new HashSet<Integer>();
				outputAllDuplexVertex = dfsVisitreverse(getTranspositionGraph(this), currVertex, outputAllDuplexVertex);
				
				System.out.println(outputAllDuplexVertex);
				for(int i : outputAllDuplexVertex){
					System.out.println("integer i pred" + i);
					if(!visited.contains(new Vertex(i))){	
						System.out.println("integer i po" + i);
						currNew.addVertex(i);		
						visited.add(new Vertex (i));
					}
					System.out.println("-------++++-------");
				}
		
				if(currNew.vertexSet.size()>0){
					outputListGraph.add(currNew);
					//System.out.println(currVertex);
				}
			}												
		}
		
		return outputListGraph;	
	}
	
	private Deque<Vertex> dfsVisit(Vertex v, HashSet<Vertex> visited, Deque<Vertex> finishStack){
		if(visited.contains(v)){
			return finishStack;
		}
		visited.add(v);
		Vertex currVertex;
		for(int vertexPosition : exportGraph().get(v.getPosition())){
			currVertex = new Vertex(vertexPosition);
		
			if(!visited.contains(currVertex)){
				//dfsVisit(currVertex, visited, finishStack);
			//System.out.println("adding to finish" + currVertex);
			//if(!finishStack.contains(currVertex)){
			}
			
			finishStack.add(currVertex);												
			//}
			
			//System.out.println(currVertex);
		}
		return finishStack;
	}
 
	private HashSet<Integer> dfsVisitreverse(CapGraph currGraph, Vertex v , HashSet<Integer> output ) {
		for(int n : exportGraph(currGraph).get(v.getPosition())){
			if(!output.contains(n)){
				output.add(n);
				dfsVisitreverse(currGraph, new Vertex(n), output);
				}
		}
		return output;
	}

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
