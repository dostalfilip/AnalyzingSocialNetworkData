package junit.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import graph.CapGraph;

public class CapGraphTestAdvanced {

	CapGraph test;

	@Before
	public void before(){
		test = new CapGraph();	//TODO
		test.addVertex(1);	// is required to has at least one vertex, otherwise it fails
		//test.addVertex(2);
		//test.addVertex(3);
		//test.addVertex(4);
		test.addEdge(1, 2);
		test.addEdge(2, 4);
		test.addEdge(1, 10);
	}
	
	
	@Test
	public void testGetEgonet_NULL(){
		if(!test.getEgonet(0).isEmpty()){
			fail("EgoNet is not empty!");
			//TODO
		}
	}
	
	@Test
	public void testGetEgonet() {
		//TODO
	}

	@Test
	public void testGetSCCs() {
		//TODO
	}

}
