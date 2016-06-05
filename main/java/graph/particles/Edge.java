package graph.particles;

/**
 * 
 * @author Filip Dostal
 *
 */
public class Edge {

	private int[] bridge;
	
	public Edge(int pointA, int pointB){
		bridge = new int[2];
		bridge[0] = pointA;
		bridge[1] = pointB;
	}

	public int getPointA() {
		return bridge[0];
	}
	
	public int getPointB() {
		return bridge[1];
	}
	
	@Override
	public String toString(){
		String output = "Bridge: (" + getPointA() + ")-" + "(" + getPointB() + ")";
		return output;
	}
}
