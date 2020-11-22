package com.catalin.tgc;

import java.util.Set;

import com.catalin.tgc.adjacency.UndirectedAdjacencyList;
import com.catalin.tgc.adjacency.vertex.AbstractVertex;
import com.catalin.tgc.adjacency.vertex.UnweightedVertex;
import com.catalin.tgc.algorithm.CenterAndPeripheryFinder;
import com.catalin.tgc.algorithm.DijkstraShortestPath;

/**
 * Demo program for AdjacencyList.
 * 
 * @author Catalin Florea
 */
public class Demo {
	
	public static void main(String[] args) {
		
		// Create the graph.
		UndirectedAdjacencyList<UnweightedVertex> adjacencyList = new UndirectedAdjacencyList<>(UnweightedVertex.class);
		
		adjacencyList.addVertex("A");
		adjacencyList.addVertex("B");
		adjacencyList.addVertex("C");
		adjacencyList.addVertex("D");
		adjacencyList.addVertex("E");
		adjacencyList.addVertex("F");
		adjacencyList.addVertex("G");
		adjacencyList.addVertex("H");
		
		adjacencyList.addEdge("A", "B");
		adjacencyList.addEdge("A", "F");
		adjacencyList.addEdge("A", "G");
		adjacencyList.addEdge("B", "C");
		adjacencyList.addEdge("C", "D");
		adjacencyList.addEdge("D", "F");
		adjacencyList.addEdge("D", "E");
		adjacencyList.addEdge("E", "F");
		adjacencyList.addEdge("E", "H");
		adjacencyList.addEdge("G", "H");
		
		// Print the adjacency list.
	    System.out.println("Adjacency List:");
	    for (UnweightedVertex vertex : adjacencyList.getVertices()) {
	    	System.out.print(vertex.getLabel().concat(": "));
			for (AbstractVertex adjacencyVertex : adjacencyList.getAdjacentVertices(vertex)) {
				System.out.print(adjacencyVertex.getLabel().concat(" "));
			}
			System.out.println();
		}
	    System.out.println();

	    // Print the shortest distances from "B" to every vertex
	    DijkstraShortestPath<UnweightedVertex> dijkstraShortestPath = new DijkstraShortestPath<UnweightedVertex>(adjacencyList);
	    System.out.println("Dijkstra's Shortest Path:");
	    dijkstraShortestPath.execute(adjacencyList.getVertex("B"));
	    for (UnweightedVertex vertex : adjacencyList.getVertices()) {
			Integer distanceTo = dijkstraShortestPath.getDistanceTo(vertex);
			if (distanceTo == null) {
				continue;
			}
			
			System.out.println(vertex.getLabel() + ": " + distanceTo);
		}
	    System.out.println();

	    // Print the center of the graph.
	    CenterAndPeripheryFinder<UnweightedVertex> finder = new CenterAndPeripheryFinder<>(adjacencyList);
	    System.out.println("Center: ");
	    Set<UnweightedVertex> center = finder.findCenter();
	    for (UnweightedVertex vertex : center) {
			System.out.print(vertex.getLabel() + " ");
		}
	    System.out.println("\n");
	    
	    // Print the periphery of the graph.
	    System.out.println("Periphery:");
	    Set<UnweightedVertex> periphery = finder.findPeriphery();
	    for (UnweightedVertex vertex : periphery) {
			System.out.print(vertex.getLabel() + " ");
		}
	    System.out.println("\n");
	    
	}

}
