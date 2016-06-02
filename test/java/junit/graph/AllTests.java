package junit.graph;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CapGraphTest.class, CapGraphTestAdvanced.class, VertexTest.class})
public class AllTests {

}
