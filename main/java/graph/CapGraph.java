package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
	
	
	

	/* (non-Javadoc)
	 * @see graph.Graph#addVertex(int)
	 */
	public void addVertex(int num) {
		myArray.add(new Vertex(num));
	}

	/* (non-Javadoc)
	 * @see graph.Graph#addEdge(int, int)
	 */
	public void addEdge(int from, int to) {
		if(!myArray.contains(from)){
			myArray.add(new Vertex(from, to));
		}
		myArray.get(from).setConection(to);
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getEgonet(int)
	 */
	public Graph getEgonet(int center) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getSCCs()
	 */
	public List<Graph> getSCCs() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see graph.Graph#exportGraph()
	 */
	public HashMap<Integer, HashSet<Integer>> exportGraph(){
		HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<Integer, HashSet<Integer>>();
		for(Vertex v : myArray){
			myGraph.put(v.getPosition(), v.getConections());
		}
		
		return myGraph;
	}
}
