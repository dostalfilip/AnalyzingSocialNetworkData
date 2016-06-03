package vertex;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import graph.particles.Vertex;

@RunWith(Parameterized.class)
public class VertexTest {
	private Vertex vertex;
	
	private int positionA;
	private int positionB;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
			{ 0, 8 }, { 1, 2 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 6 }, { 6, 8 }  
		});
	}
	
    public VertexTest(int positionA, int positionB) {
		this.positionA = positionA;
		this.positionB = positionB;
	}
	
	@Before
    public void prepare() {
    	vertex = new Vertex(positionA);
    }

	@Test
	public void testVertex_NonArgument() {
		Vertex vertex = new Vertex();
		assertNotNull(vertex);
	}
	
	@Test
	public void testVertex_FromArgument(){
		Vertex vertex = new Vertex(positionA);
		assertNotNull(vertex);
	}
	
	@Test
	public void testVertex_BothArgument(){
		Vertex vertex = new Vertex(positionA, positionB);
		assertTrue(vertex.getPosition() == positionA && vertex.isConected(positionB));
	}
	

	@Test
	public void testGetPosition() {
		assertEquals(positionA, vertex.getPosition());
	}

	@Test
	public void testSetPosition() {
		vertex.setPosition(positionA+1);
		assertEquals(positionA + 1, vertex.getPosition());
	}
	

	@Test
	public void testIsPosition() {
		assertTrue(vertex.isPosition(positionA));
	}

	@Test
	public void testIsConected() {
		vertex.setConection(positionB);
		assertTrue(vertex.isConected(positionB));
	}

	@Test
	public void testgetConections() {
		HashSet<Integer> temp = vertex.getConections();
		vertex.setConection(positionB);
		assertTrue(temp.contains(positionB));
	}
	
	
}

