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
	
	private HashMap<Integer,Vertex> myMap;
	
	/**
	 * Constructor
	 */
	public CapGraph() {
		myMap = new HashMap<Integer,Vertex>();
	}
	
	/**
	 * Add Vertex to the Graph
	 * @param add Vertex 
	 */
	public void addVertex(Vertex v){
		myMap.put(v.getPosition(), v);
	}
	
	/**
	 * @param Integer, add new Vertex(param) to mymap
	 */
	public void addVertex(int num) {
		if(myMap.containsKey(num)){
		}
		else{		
			Vertex tempVertex = new Vertex(num);
			myMap.put(num, tempVertex);						
		}
	}

	public void addEdge(int from, int to) {	
		Vertex tempVertex = myMap.get(from);
		/*
		 * If condition control if vertex with this central vertex is set properly
		 */
		if(!myMap.containsKey(from)){
			tempVertex = new Vertex(from);
		}
		tempVertex.setConection(to);
		myMap.put(from, tempVertex);
	}
	
	public void removeVertex(int num_vertex){
		myMap.remove(num_vertex);
	}
	
	public void removeEdge(int num_vertex,int num_edge){
		Vertex tempVertex = myMap.get(num_vertex);
		HashSet<Integer> tempSet = tempVertex.getConections();
		tempSet.remove(num_edge);
		tempVertex.setConections(tempSet);
		myMap.put(num_vertex, tempVertex);
	}
	

	public CapGraph getEgonet(int center) {
		CapGraph output = new CapGraph();
		for(int n : myMap.get(center).getConections()){
			output.addEdge(center, n);
		}
		return output;
	}

	public List<Graph> getSCCs() {
		ArrayList<Graph> tempMap = new ArrayList<Graph>();
		//TODO THIS NEED TO IMPLEMENT WHOLE NEW ALGORITHM WITH RESERSE MATIC
		return tempMap;	
	}
	
	/**
	 * Export of Vertex
	 * @param integer of center position
	 * @return Vertex of position num
	 */
	public Vertex exportVertex(int num){
		Vertex output = new Vertex(); 
		output = myMap.get(num);
		return output;
	}


	public HashMap<Integer, HashSet<Integer>> exportGraph(){
		HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<Integer, HashSet<Integer>>();
		for(int i : myMap.keySet()){
			Vertex tempVertex = myMap.get(i);			
			myGraph.put(i, tempVertex.getConections());
			}
		
		
		return myGraph;
	}
	
	public boolean isEmpty(){
		return myMap.isEmpty();
	}
	
	/**
	 * return all Vertex from array
	 */
	@Override
	public String toString(){
		String output = "Num of element: " + Integer.toString(myMap.size()) + "\n";
		for(int n : myMap.keySet()){
			output += myMap.get(n).toString() + "\n";
		}
		return output;
	}
}
