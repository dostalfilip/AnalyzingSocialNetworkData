package tester.firststage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import graph.CapGraph;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class TesterSCCSample {

	public static void main(String[] args) {
		CapGraph test = new CapGraph();
		
		// input data
		int[] vertices = {32,50,44,25,65,18,23};
		int[] edges = {3250,3244,4450,1844,1823,2318,2325,2523,2565,6523};
		
		for(int i : vertices){
			test.addVertex(i);
		}
		
		for(int i : edges){
			int a = Integer.valueOf(Integer.toString(i).substring(0, 2));
			int b = Integer.valueOf(Integer.toString(i).substring(2, 4));
			test.addEdge(a, b);
		}
		
		//budou nasledovat 4 testy
		//obecny test ok
		//dfs
		//traspose ok
		//dfsreverte
		
		//obecný test ok
		for(Vertex v : test.getVertexSet()){
			//System.out.println(v);
		}
		
		for(Edge e : test.getEdgeSet()){
			//System.out.println(e);
		}
		System.out.println("");
		//transpose ok
		CapGraph testTranspose = new CapGraph();
		testTranspose = test.getTranspositionGraph(test);
		
		for(Vertex v : testTranspose.getVertexSet()){
			//System.out.println(v);
		}
		
		for(Edge e : testTranspose.getEdgeSet()){
			System.out.println(e);
		}
		//dfs
		System.out.println("");
		Deque<Vertex> vysledek = test.dfs(test, test.getVertexSet());
		Deque<Vertex> vysledek2 = test.dfs(test, test.getVertexSet());
		while(!vysledek.isEmpty()){
			System.out.println(vysledek.poll());
		}
		
		//dfsreverse
		HashSet<Vertex> visited = new HashSet<Vertex>();
		while(!vysledek2.isEmpty()){
			ArrayDeque<Vertex> finish = new ArrayDeque<Vertex>();
			if(!visited.contains(vysledek2.peekLast())){
				System.out.println("peekLast"+ vysledek2.peekLast());
				test.dfsVisit(testTranspose,vysledek2.pollLast(),visited,finish);
				System.out.println("New Vertex: ");
				while(!finish.isEmpty()){
					System.out.println(finish.poll());
				}	
			}
			System.out.println("peekLastNakonci"+ vysledek2.peekLast());
			vysledek2.pollLast();
		}
	}
}
