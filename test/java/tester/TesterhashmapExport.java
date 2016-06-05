package tester;

import java.util.HashMap;
import java.util.HashSet;

import graph.CapGraph;
import util.GraphLoader;

public class TesterhashmapExport {


		public static void main(String[] args) {
			CapGraph test = new CapGraph();
			HashMap<Integer, HashSet<Integer>> testHash;

			
			/*Expected
			 * 	1 2
			 *	2 3
			 *	3 4
			 *	4 1
			 */
			
			GraphLoader.loadGraph(test, "./src/test/resources/scc/test_8.txt");
			System.out.println("Graph loaded!");
			testHash = test.exportGraph();

			System.out.println(test.toString());
			
			
			System.out.println("Compare with HashMap");
			for(int n : testHash.keySet()){
				System.out.print("Center Vertex v bodu : " + n + " Poèet Conectu: " + testHash.get(n).size() + "\n");
				for(int v : testHash.get(n)){
					System.out.print(v + ", ");
				}
				System.out.println(".");
			}

		}

}
