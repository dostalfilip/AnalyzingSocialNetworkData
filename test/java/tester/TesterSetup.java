package tester;

import graph.CapGraph;
import graph.particles.Vertex;
import util.GraphLoader;

/**
 * 
 * @author Filip Dostal
 *
 *	Tester setup class
 */
public class TesterSetup {

	public static void main(String[] args) {
		System.out.println("Looding Graph");
		CapGraph test = new CapGraph();
		try{
		GraphLoader.loadGraph(test, "./src/test/resources/facebook_1000.txt");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
		try{
        Vertex vertex = new Vertex(0);
        vertex.setPosition(0);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
