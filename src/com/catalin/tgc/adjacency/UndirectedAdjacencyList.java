package com.catalin.tgc.adjacency;

import java.util.List;

import com.catalin.tgc.adjacency.vertex.AbstractVertex;

/**
 * Implementation of the undirected adjacency list.
 * 
 * @author Florea Catalin
 *
 * @param <V> the vertex type
 */
public class UndirectedAdjacencyList<V extends AbstractVertex> extends AbstractAdjacencyList<V> {

	/**
	 * Instantiates an undirected adjacency list.
	 */
	public UndirectedAdjacencyList(Class<V> clazz) {
		super(clazz);
	}

	/** {@inheritDoc} */
	public void addEdge(V fromVertex, V toVertex) {
		nullCheck(fromVertex);
		nullCheck(toVertex);
		
		adjacencyHashMap.get(fromVertex).add(toVertex);
		adjacencyHashMap.get(toVertex).add(fromVertex);
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

	    List<V> toVertexAdjacencies = adjacencyHashMap.get(toVertex);
	    if (toVertexAdjacencies != null) {
	    	toVertexAdjacencies.remove(fromVertex);
	    }
	}

}
