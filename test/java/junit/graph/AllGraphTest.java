package junit.graph;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.graph.CapGraphTest;

@RunWith(Suite.class)
@SuiteClasses({CapGraphGetSCCTest.class, CapGraphTest.class,
		CapGraphTestAdvanced.class})
public class AllGraphTest {

}
