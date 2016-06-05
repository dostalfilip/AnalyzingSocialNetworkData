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
		test.addVertex(new Vertex(99,50));
		myGraph = test.exportGraph();
		assertTrue(myGraph.get(99).contains(50));
	}
	
	
	
	@Test
	public void testGetEgonet_NULL(){
		assertTrue(test.getEgonet(1) != null);
	}
	
	@Test
	public void testGetEgonet_Positive() {
		test.addEdge(2, 6);
		CapGraph testEgoNet = test.getEgonet(2);
		myGraph = testEgoNet.exportGraph();
		
		
		//System.out.println(test.toString());
		//System.out.println(testEgoNet.toString());
		
		assertTrue(test.exportVertex(2).toString().equals(testEgoNet.exportVertex(2).toString()));
		
	}
	
	@Test
	public void testGetEgonet_Negative() {
		test.addEdge(2, 6);
		CapGraph testEgoNet = new CapGraph();
		testEgoNet = test.getEgonet(2);

		//System.out.println(test.toString());
		//System.out.println(testEgoNet.toString());
		
		test.addEdge(2, 7);
		testEgoNet.addEdge(2, 9);
		
		//System.out.println(test.toString());
		//System.out.println(testEgoNet.toString());
		
		assertTrue(!test.exportVertex(2).toString().equals(testEgoNet.exportVertex(2).toString()));
	}
	

	@Test
	public void testGetSCCs() {
		//TODO
	}

}
