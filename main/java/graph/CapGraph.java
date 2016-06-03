package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import graph.particles.Vertex;

/**
 * @author Filip Dostal
 * 
 * For the warm up assignment, you must implement your Graph in a class
 * named CapGraph.  Here is the stub file.
 *
 */
public class CapGraph implements Graph {
	
	private ArrayList<Vertex> myArray;

	
	/**
	 * Constructor
	 */
	public CapGraph() {
		myArray = new ArrayList<Vertex>();
	}

	public void addVertex(int num) {
		myArray.add(new Vertex(num));
	}

	public void addEdge(int from, int to) {	
		if(!myArray.contains(new Vertex(from)) || myArray.isEmpty()){
			myArray.add(new Vertex(from));
		}
		Vertex tempVertex = myArray.get(from);
		tempVertex.setConection(to);
		myArray.add(from, tempVertex);
	}
	
	public void removeVertex(int num_vertex){
		//TODO
	}
	
	public void removeEdge(int num_vertex,int num_edge){
		//TODO
	}
	

	public CapGraph getEgonet(int center) {
		CapGraph output = new CapGraph();

		//TODO
		
		return output;
	}

	public List<Graph> getSCCs() {
		// TODO Auto-generated method stub
		return null;
	}


	public HashMap<Integer, HashSet<Integer>> exportGraph(){
		HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<Integer, HashSet<Integer>>();
		for(Vertex v : myArray){
			HashSet<Integer> tempSet = v.getConections();
			myGraph.put(v.getPosition(), tempSet);
		}
		
		return myGraph;
	}
	
	public boolean isEmpty(){
		return myArray.isEmpty();
	}
}
