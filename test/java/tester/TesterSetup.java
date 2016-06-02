package tester;

import graph.CapGraph;
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
		GraphLoader.loadGraph(test, "./src/test/resources/facebook_1000.txt");
	}
}
