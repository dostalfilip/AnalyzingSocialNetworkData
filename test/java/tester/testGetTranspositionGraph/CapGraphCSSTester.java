package tester.testGetTranspositionGraph;

import graph.CapGraph;
import graph.Graph;
import util.GraphLoader;

public class CapGraphCSSTester {
	/**
	 * It should testin SCC method using test_4.txt input data
	 * right outcomes are according to scc_4.txt
	 * @param args
	 */
	
	public static void main(String[] args) {
		CapGraph test = new CapGraph();
		GraphLoader.loadGraph(test, "./src/test/resources/scc/test_4.txt");
		System.out.println("Graph loaded!");
		
		//System.out.println(test);
	
		System.out.println("------------------------");
		//System.out.println(test);
		System.out.println("------------------------");
		System.out.println(test.getTranspositionGraph(test));
		System.out.println("------------------------");
		
		
		
		
		for(Graph cg : test.getSCCs()){
			System.out.println("*********************************");
			System.out.println(cg);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
