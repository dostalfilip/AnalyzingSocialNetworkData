package junit.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import graph.CapGraph;
import graph.Edge;
import graph.Vertex;



public class CapGraphTestAdvanced {

	CapGraph test;
	HashMap<Integer, HashSet<Integer>> myGraph;
	
	@Before
	public void before(){
		test = new CapGraph();
		test.addVertex(1);
		test.addEdge(1, 2);
		test.addEdge(2, 4);
		test.addEdge(1, 10);
	}
	
	@Test
	public void testAddVertex_ParamVertex(){
		CapGraph test2 = new CapGraph();
		test2.addVertex(1);
		assertTrue(test2.exportGraph().containsKey(1));
	}
	
	@Test
	public void testgetTranspositionGraph(){
		
		test = new CapGraph();
		test.addVertex(1);
		test.addEdge(1, 2);
		test.addEdge(2, 4);
		test.addEdge(1, 10);
		
		assertTrue(test.getVertexSet().contains(new Vertex (1)));
		assertTrue(test.getEdgeSet().contains(new Edge (1,2)));
		assertTrue(test.getEdgeSet().contains(new Edge (2,4)));
		
		

		CapGraph transposeGraph = test.getTranspositionGraph(test);
		assertTrue(transposeGraph.getVertexSet().contains(new Vertex (1)));
		assertTrue(transposeGraph.getEdgeSet().contains(new Edge (2,1)));
		assertTrue(transposeGraph.getEdgeSet().contains(new Edge (4,2)));
	}
	
	@Test
	public void testgetTranspositionGraph2(){
		
		test = new CapGraph();
		test.addVertex(1);
		test.addVertex(3);
		test.addVertex(6);
		test.addEdge(1, 2);
		test.addEdge(2, 4);
		test.addEdge(1, 10);
		test.addEdge(3, 6);
		CapGraph transposeGraph = test.getTranspositionGraph(test);
		assertFalse(test.toString().equals(transposeGraph.toString()));
		
		transposeGraph = transposeGraph.getTranspositionGraph(transposeGraph);
		
		assertTrue(test.toString().equals(transposeGraph.toString()));
	}
	
	@Test
	public void testGetSCCs() {
	
		//TODO
		
		
	}

}
