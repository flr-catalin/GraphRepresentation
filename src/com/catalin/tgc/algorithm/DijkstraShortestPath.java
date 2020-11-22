package com.catalin.tgc.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.catalin.tgc.adjacency.AbstractAdjacencyList;
import com.catalin.tgc.adjacency.vertex.AbstractVertex;

/**
 * Implementation of Dijkstra's shortest path algorithm.
 * 
 * @author Florea Catalin
 *
 * @param <V> the vertex type
 */
public class DijkstraShortestPath<V extends AbstractVertex> {
	
	/** The set of settled vertices. */
	private Set<V> settled;
	
	/** The linked list of unsettled vertices. */
	private LinkedList<V> unsettled;
	
	/** The adjacency list */
	protected AbstractAdjacencyList<V> adjacencyList;
	
	/** The distance map */
	protected Map<V, Integer> distanceMap;

	/**
	 * Instantiates a Dijkstra shortest path object.
	 */
	public DijkstraShortestPath(AbstractAdjacencyList<V> adjacencyList) {
		super();
		
		this.adjacencyList = adjacencyList;
		this.settled = new HashSet<>();
		this.unsettled = new LinkedList<>();
		this.distanceMap = new HashMap<>();
	}
	
	/**
	 * Executes the algorithm from the given vertex.
	 */
	public void execute(V fromVertex) {
		nullCheck(fromVertex);
		
		unsettled.add(fromVertex);
		
		while (settled.size() != adjacencyList.getVertices().size()) {
			V vertex = unsettled.remove();
			settled.add(vertex);
			processNeighbours(vertex);
		}
	}
	
	/**
	 * Gets the distance to the given vertex.
	 */
	public Integer getDistanceTo(V toVertex) {
		nullCheck(toVertex);
		
		return distanceMap.get(toVertex);
	}
	
	/**
	 * Processes the neighbours of the given vertex.
	 */
	private void processNeighbours(V vertex) {
		Integer edgeDistance = Integer.valueOf(1);
		Integer distance = Integer.valueOf(-1);
		
		for (V neighbour : adjacencyList.getAdjacentVertices(vertex)) {
			if (!settled.contains(neighbour)) {
				distance = distanceMap.getOrDefault(vertex, Integer.valueOf(0)) + edgeDistance;
				
				if (distance < distanceMap.getOrDefault(neighbour, Integer.valueOf(Integer.MAX_VALUE))) {
					distanceMap.put(neighbour, distance);
				}
				
				unsettled.add(neighbour);
			}
		}
	}
	
	/**
	 * Null check implementation.
	 * @throws IllegalArgumentException if the vertex is null.
	 */
	private void nullCheck(V vertex) {
		if (Objects.isNull(vertex)) {
			throw new IllegalArgumentException("null value not allowed.");
		}
	}
	
	/**
	 * Same as execute, but first resets the instance.
	 */
	protected void executeInternal(V vertex) {
		this.settled = new HashSet<>();
		this.unsettled = new LinkedList<>();
		this.distanceMap = new HashMap<>();
		
		execute(vertex);
	}
	
}
