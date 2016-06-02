package graph;

import java.util.HashSet;

/**
 * 
 * @author Filip Dostal
 *
 *	Basic object of Social network data structure
 */
public class Vertex {
	
	private int position;
	private HashSet<Integer> conections;
	
	
	public Vertex(int position, int conection){
		this.position = position;
		conections = new HashSet<Integer>();
		conections.add(conection);
	}
	
	
	/**
	 * Constructor of the Vertex
	 * @param Integer of position
	 */
	public Vertex(int position){
		this.position = position;
		conections = new HashSet<Integer>();
	}
	
	/**
	 * No parameter Constructor
	 */
	public Vertex(){
		conections = new HashSet<Integer>();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * 
	 * @param 	Integer of position
	 * @return	True if is equals to vertex position
	 */
	public boolean isPosition(int position){
		if(this.position == position)
			return true;
		return false;
	}

	public void setConection(int conection) {
		this.getConections().add(conection);
	}
	
	/**
	 * 
	 * @param 	Integer of position
	 * @return	true if is conected
	 */
	public boolean isConected(int to){
		if(getConections().contains(to))
			return true;
		return false;
	}

	public HashSet<Integer> getConections() {
		return conections;
	} 
	
}
