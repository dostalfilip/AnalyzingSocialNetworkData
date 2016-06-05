package junit.graph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import graph.CapGraph;
import util.GraphLoader;

public class CapGraphTest {
	CapGraph test; 
	 HashMap<Integer,HashSet<Integer>> myGraph;
	
	@Before
	public void before(){
		test = new CapGraph();
		GraphLoader.loadGraph(test, "./src/test/resources/scc/test_1.txt");
		/*
		 * 	1 2
		 *	2 3
		 *	3 4
		 *	4 1
		 * 
		 */
		
	}
	
	@Test
	public void testAddVertex_FromGraphLoader() {
		myGraph = test.exportGraph();
		assertTrue(myGraph.containsKey(2) && myGraph.containsKey(3) &&
				myGraph.containsKey(4) && myGraph.containsKey(1)  );
	}
	
	@Test
	public void testAddEdge_FromGraphLoader() {
		myGraph = test.exportGraph();
		assertTrue(myGraph.get(1).contains(2));
		assertTrue(myGraph.get(2).contains(3));
		assertTrue(myGraph.get(3).contains(4));
		assertTrue(myGraph.get(4).contains(1));
	}
	

	@Test
	public void testExportGraph() {
		myGraph = test.exportGraph();
		assertNotNull(myGraph);
	}

	@Test
	public void testAddVertex() {
		test.addVertex(5);
		myGraph = test.exportGraph();
		assertTrue(myGraph.containsKey(5));
	}

	@Test
	public void testAddEdge() {
		test.addEdge(0, 5);
		myGraph = test.exportGraph();
		assertTrue(myGraph.get(0).contains(5));
	}


	@Test
	public void testRemoveVertex() {
		test.removeVertex(4);
		myGraph = test.exportGraph();
		assertFalse(myGraph.containsKey(4));
	}
	
	@Test
	public void testRemoveEdge() {
		test.removeEdge(4, 1);
		myGraph = test.exportGraph();
		assertFalse(myGraph.get(4).contains(1));
	}
	
}
