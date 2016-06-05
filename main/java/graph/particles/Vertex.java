package graph.particles;

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
	
	/**
	 * Constructor
	 * @param Central Vertex position
	 * @param One integer(Vertex)conection
	 */
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

	/**
	 * 
	 * @return integer central position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param set central vertex position
	 */
	public void setPosition(int position) {
		if(position == this.position){
			//	throw new IllegalArgumentException("Same possition is already assigned");			
		}
		else{
			this.position = position;			
		}
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
		if(isConected(conection)){			
			//	throw new IllegalArgumentException("Same conection is already assigned");
			// related to VertexException test
		}
		else{
			conections.add(conection);			
		}
	}
	
	/**
	 * 
	 * @param 	Integer of position
	 * @return	true if"to" is conected
	 */
	public boolean isConected(int to){
		if(getConections().contains(to))
			return true;
		return false;
	}

	/**
	 * 
	 * @return HashSet<Integer> all of connection integer to central vertex
	 */
	public HashSet<Integer> getConections() {
		return conections;
	} 
	
	/**
	 * 
	 * @param overwrite HashSet by the other hashSet
	 */
	public void setConections(HashSet<Integer> conections) {
		this.conections = conections;
	} 
	
	@Override
	public String toString(){
		String output = "Position: (" + Integer.toString(getPosition()) + ") Conections: ";
		for(int i : getConections()){
			output +=  Integer.toString(i) + ". ";
		}
		output += "---END";
		return output;
	}
	
}
