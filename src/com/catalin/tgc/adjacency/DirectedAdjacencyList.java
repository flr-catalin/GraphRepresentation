package com.catalin.tgc.adjacency;

import java.util.List;

import com.catalin.tgc.adjacency.vertex.AbstractVertex;

/**
 * Implementation of the directed adjacency list.
 * 
 * @author Florea Catalin
 *
 * @param <V> the vertex type
 */
public class DirectedAdjacencyList<V extends AbstractVertex> extends AbstractAdjacencyList<V> {

	/**
	 * Instantiates a directed adjacency list.
	 */
	public DirectedAdjacencyList(Class<V> clazz) {
		super(clazz);
	}

	@Override
	/** {@inheritDoc} */
	public void addEdge(V fromVertex, V toVertex) {
		nullCheck(fromVertex);
		nullCheck(toVertex);
		
		adjacencyHashMap.get(fromVertex).add(toVertex);
	}
	
	@Override
	/** {@inheritDoc} */
	public void removeEdge(V fromVertex, V toVertex) {
		nullCheck(fromVertex);
		nullCheck(toVertex);
		
	    List<V> fromVertexAdjacencies = adjacencyHashMap.get(fromVertex);
	    if (fromVertexAdjacencies != null) {
	    	fromVertexAdjacencies.remove(toVertex);
	    }
	}
	
}
