package tester.testGetTranspositionGraph;


import graph.CapGraph;
import graph.Edge;
import graph.Vertex;

public class testGetTransposition {

	public static void main(String[] args) {
		CapGraph test = new CapGraph();
		test.addVertex(1);
		test.addEdge(1, 2);
		test.addEdge(2, 4);
		test.addEdge(1, 10);
		
		
		CapGraph testTransposition = test.getTranspositionGraph(test);
		testTransposition = testTransposition.getTranspositionGraph(testTransposition);
		
		
		for(Vertex i : testTransposition.getVertexSet()){
			System.out.println(i);
		}
		for(Edge i : testTransposition.getEdgeSet()){
			System.out.println(i);
		}

	}

}
