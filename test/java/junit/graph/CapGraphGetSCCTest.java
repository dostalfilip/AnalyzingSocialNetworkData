package junit.graph;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import graph.CapGraph;

public class CapGraphGetSCCTest {

	CapGraph testGraph;
	
	@Before
	public void before(){
		testGraph = new CapGraph();
	}
	
	@Test
	public void testGetSCCs_NotNull() {
		assertTrue("Object Pointing to null",!(testGraph.getSCCs() == null));
	}
	//TODO 
}
