package junit.particles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EdgeTest.class, VertexExceptionTest.class, VertexTest.class})
public class AllParticlesTests {

}
