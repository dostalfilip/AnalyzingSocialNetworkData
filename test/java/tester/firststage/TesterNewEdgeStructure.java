package tester.firststage;

import java.util.HashMap;
import java.util.HashSet;

import graph.CapGraph;
import util.GraphLoader;

public class TesterNewEdgeStructure {

	public static void main(String[] args) {
		CapGraph test = new CapGraph();
		HashMap<Integer, HashSet<Integer>> testHash;

		
		/*Expected
		 * 	1 2
		 *	2 3
		 *	3 4
		 *	4 1
		 */
		
		GraphLoader.loadGraph(test, "./src/test/resources/scc/test_1.txt");
		System.out.println("Graph loaded!");
		testHash = test.exportGraph();

		System.out.println(test.toString());

		
		System.out.print("Test export");
		for(int i:testHash.keySet()){
			System.out.print("\n("+ i + "):");
			for(int n : testHash.get(i)){
				System.out.print(" "+n);
			}
		}
		System.out.println("\n");
		System.out.println(test.getEgonet(2).toString());

		
	}

}