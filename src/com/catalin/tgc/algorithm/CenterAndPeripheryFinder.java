package com.catalin.tgc.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.catalin.tgc.adjacency.AbstractAdjacencyList;
import com.catalin.tgc.adjacency.vertex.AbstractVertex;

/**
 * Implementation of the center and periphery finder.
 * 
 * @author Florea Catalin
 *
 * @param <V> the vertex type
 */
public class CenterAndPeripheryFinder<V extends AbstractVertex> extends DijkstraShortestPath<V> {

	/** The eccentricity map. */
	private Map<V, Integer> eccentricityMap;
	
	/**
	 * Instantiates a center and periphery finder.
	 */
	public CenterAndPeripheryFinder(AbstractAdjacencyList<V> adjacencyList) {
		super(adjacencyList);
		this.eccentricityMap = new HashMap<>();
	}

	/**
	 * Finds the center of a graph.
	 */
	public Set<V> findCenter() {
		Set<V> center = new HashSet<>();
		
		processEccentricityMap(super.adjacencyList.getVertices());
		Integer minimumEccentricity = findMinimumDistance(eccentricityMap);
		
		for (V vetrex : eccentricityMap.keySet()) {
			if (eccentricityMap.get(vetrex) == minimumEccentricity) {
				center.add(vetrex);
			}
		}
		
		return center;
	}
	
	/**
	 * Finds the periphery of a graph.
	 */
	public Set<V> findPeriphery() {
		Set<V> periphery = new HashSet<>();
		
		processEccentricityMap(super.adjacencyList.getVertices());
		Integer maximumEccentricity = findMaximumDistance(eccentricityMap);
		
		for (V vetrex : eccentricityMap.keySet()) {
			if (eccentricityMap.get(vetrex) == maximumEccentricity) {
				periphery.add(vetrex);
			}
		}
		
		return periphery;
	}

	/**
	 * Processes the eccentricity map, if not processed already.
	 */
	private void processEccentricityMap(Set<V> vertices) {
		if (!eccentricityMap.isEmpty()) {
			return;
		}
		
		for (V vertex : vertices) {
			super.executeInternal(vertex);
			
			Integer maximumDistance = findMaximumDistance(super.distanceMap);
			eccentricityMap.put(vertex, maximumDistance);
		}
	}
	
	/**
	 * Finds the maximum distance from a distance map.
	 */
	private Integer findMaximumDistance(Map<V, Integer> map) {
		Integer maximumDistance = Integer.MIN_VALUE;
		
		for (Integer distance : map.values()) {
			if (distance > maximumDistance) {
				maximumDistance = distance;
			}
		}
		
		return maximumDistance;
	}
	
	/**
	 * Finds the minimum distance from a distance map.
	 */
	private Integer findMinimumDistance(Map<V, Integer> map) {
		Integer minimumDistance = Integer.MAX_VALUE;
		
		for (Integer distance : map.values()) {
			if (distance < minimumDistance) {
				minimumDistance = distance;
			}
		}
		
		return minimumDistance;
	}

}
