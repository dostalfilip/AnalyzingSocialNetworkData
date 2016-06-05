package junit.graph;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import graph.CapGraph;
import graph.particles.Vertex;



public class CapGraphTestAdvanced {

	CapGraph test;
	HashMap<Integer, HashSet<Integer>> myGraph;
	
	@Before
	public void before(){
		test = new CapGraph();
		test.addEdge(1, 2);
		test.addEdge(2, 4);
		test.addEdge(1, 10);
	}
	
	@Test
	public void testAddVertex_ParamVertex(){
		test.addVertex(99);
		test.addEdge(99, 50);
		myGraph = test.exportGraph();
		assertTrue(myGraph.get(99).contains(50));
	}
	
	
	
	@Test
	public void testGetEgonet_NULL(){
		assertTrue(test.getEgonet(1) != null);
	}
	
	@Test
	public void testGetEgonet_Positive() {
		//TODO
	}
	
	@Test
	public void testGetEgonet_Negative() {
		//TODO
	}
	

	@Test
	public void testGetSCCs() {
		//TODO
	}

}
