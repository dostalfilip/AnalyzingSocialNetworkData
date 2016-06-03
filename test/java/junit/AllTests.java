package junit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.graph.CapGraphTest;
import junit.graph.CapGraphTestAdvanced;
import junit.graph.EdgeTest;
import vertex.VertexExceptionTest;
import vertex.VertexTest;

@RunWith(Suite.class)
@SuiteClasses({CapGraphTest.class, CapGraphTestAdvanced.class,
	VertexTest.class, VertexExceptionTest.class,
	EdgeTest.class})
public class AllTests {

}
