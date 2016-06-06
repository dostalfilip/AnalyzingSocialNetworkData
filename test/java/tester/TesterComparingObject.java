package tester;

import graph.particles.Edge;
import graph.particles.Vertex;

public class TesterComparingObject {

	public static void main(String[] args) {
/*		Vertex vA = new Vertex(0);
		Vertex vB = new Vertex(0);

		System.out.println(vA.equals(vB));
		System.out.println(vA.hashCode() == vB.hashCode());*/
		
		Edge eA = new Edge(0, 1);
		Edge eB = new Edge(0, 1);

		System.out.println(eA.equals(eB));
		System.out.println(eA.hashCode() == eB.hashCode());
		
	}

}
