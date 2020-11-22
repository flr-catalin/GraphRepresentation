package com.catalin.tgc;

import com.catalin.tgc.adjacency.UndirectedAdjacencyList;
import com.catalin.tgc.adjacency.vertex.AbstractVertex;
import com.catalin.tgc.adjacency.vertex.UnweightedVertex;
import com.catalin.tgc.algorithm.DijkstraShortestPath;

/**
 * Demo program for AdjacencyList.
 * 
 * @author Catalin Florea
 */
public class Demo {
	
	public static void main(String[] args) {
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
		
	    System.out.println("Adjacency List:");
	    for (UnweightedVertex vertex : adjacencyList.getVertices()) {
	    	System.out.print(vertex.getLabel().concat(": "));
			for (AbstractVertex adjacencyVertex : adjacencyList.getAdjacentVertices(vertex)) {
				System.out.print(adjacencyVertex.getLabel().concat(" "));
			}
			System.out.println();
		}
	    System.out.println();

	    System.out.println("Dijkstra's Shortest Path:");
	    DijkstraShortestPath<UnweightedVertex> dijkstraShortestPath = new DijkstraShortestPath<UnweightedVertex>(adjacencyList);
	    dijkstraShortestPath.execute(adjacencyList.getVertex("A"));
	    for (UnweightedVertex vertex : adjacencyList.getVertices()) {
			System.out.println(vertex.getLabel() + ": " + dijkstraShortestPath.getDistanceTo(vertex));
		}
	}

}
