package junit.vertex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;

import graph.particles.Vertex;

/**
 * interesting github repository that using the throw exception Assert
 * https://github.com/kolorobot/unit-testing-demo/tree/master/src/test/java/com/github/kolorobot/exceptions 
 * @author Filip Dostal
 *
 */
public class VertexExceptionTest {

    
    /**
     * This code testing throwing of IlegalArgumentException
     */
    @Test
    public void testSetPosition_IllegalArgumentException() {
        try {
           Vertex vertex = new Vertex(0);
           vertex.setPosition(0);
           Assert.fail("Expected exception to be thrown");
        } catch (IllegalArgumentException e) {
            assertThat(e)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Same possition is already assigned");
        }
    }
    
    /**
     * this code testing throwing of IllegalArgumentException
     */
    @Test
    public void testSetConection_IllegalArguiment(){
        try {
            Vertex vertex = new Vertex(0,5);
            vertex.setConection(5);
            Assert.fail("Expected exception to be thrown");
         } catch (IllegalArgumentException e) {
             assertThat(e)
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessage("Same conection is already assigned");
         }
    }

}


