package junit.particles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
	private Vertex vertexA;
	private Vertex vertexB;

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
		vertexA = new Vertex(positionA);
		vertexB = new Vertex(positionB);
    }
	
	@Test
	public void testVertex_FromArgument(){
		assertNotNull(vertexA);
	}	

	@Test
	public void testGetPosition() {
		assertEquals(positionA, vertexA.getPosition());
	}
	

	@Test
	public void testIsPosition() {
		assertTrue(vertexA.isPosition(positionA));
	}

}

