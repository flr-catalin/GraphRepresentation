package com.catalin.tgc.adjacency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.catalin.tgc.adjacency.vertex.AbstractVertex;

/**
 * Abstract adjacency list implementation.
 * 
 * @author Florea Catalin
 *
 * @param <V> the vertex type
 */
public abstract class AbstractAdjacencyList<V extends AbstractVertex> {
	
	private Class<V> clazz;
	
	/** The adjacency hash map */
	public Map<V, List<V>> adjacencyHashMap;

	/**
	 * Protected constructor.
	 */
	protected AbstractAdjacencyList(Class<V> clazz) {
		super();
		this.clazz = clazz;
		this.adjacencyHashMap = new HashMap<>();
	}

	/**
	 * Adds a vertex to the adjacency list.
	 */
	public void addVertex(String label) {
		nullCheck(label);
		
		V genericVertex = instantiate();
		genericVertex.setLabel(label);
		
		adjacencyHashMap.putIfAbsent(genericVertex, new ArrayList<>());
	}
	
	/**
	 * Adds a vertex to the adjacency list.
	 */
	public void addVertex(V vertex) {
		nullCheck(vertex);
		adjacencyHashMap.putIfAbsent(vertex, new ArrayList<>());
	}
	
	/**
	 * Gets the vertex that has the given label.
	 */
	public V getVertex(String label) {
		V vertex = instantiate();
		vertex.setLabel(label);
		
		return vertex;
	}
	
	/**
	 * Removes a vertex from the adjacency list.
	 */
	public void removeVertex(String label) {
		nullCheck(label);
		
		V genericVertex = instantiate();
		genericVertex.setLabel(label);
		
		adjacencyHashMap.values().stream().forEach(e -> e.remove(genericVertex));
		adjacencyHashMap.remove(genericVertex);
	}
	 
	/**
	 * Removes a vertex from the adjacency list.
	 */
	public void removeVertex(V vertex) {
		nullCheck(vertex);
		adjacencyHashMap.values().stream().forEach(e -> e.remove(vertex));
		adjacencyHashMap.remove(vertex);
	}
	
	/**
	 * Gets the vertices of the adjacency list.
	 */
	public Set<V> getVertices() {
		return adjacencyHashMap.keySet();
	}

	/**
	 * Gets the adjacent vertices of a vertex.
	 */
	public List<V> getAdjacentVertices(V vertex) {
		nullCheck(vertex);
	    return adjacencyHashMap.get(vertex);
	}

	/**
	 * Adds an edge to the adjacency list.
	 */
	public abstract void addEdge(V fromVertex, V toVertex);
	
	/**
	 * Removes an edge from the adjacency list.
	 */
	public abstract void removeEdge(V fromVertex, V toVertex);
	
	/**
	 * Adds an edge to the adjacency list.
	 */
	public void addEdge(String fromLabel, String toLabel) {
		nullCheck(fromLabel);
		nullCheck(toLabel);
		
		V fromVertex = instantiate();
		fromVertex.setLabel(fromLabel);
		
		V toVertex = instantiate();
		toVertex.setLabel(toLabel);
		
		addEdge(fromVertex, toVertex);
	}
	
	/**
	 * Removes an edge from the adjacency list.
	 */
	public void removeEdge(String fromLabel, String toLabel) {
		nullCheck(fromLabel);
		nullCheck(toLabel);
		
		V fromVertex = instantiate();
		fromVertex.setLabel(fromLabel);
		
		V toVertex = instantiate();
		toVertex.setLabel(toLabel);
		
		removeEdge(fromVertex, toVertex);
	}
	
	/**
	 * Null check implementation.
	 * @throws IllegalArgumentException if the vertex is null.
	 */
	protected void nullCheck(Object vertex) {
		if (Objects.isNull(vertex)) {
			throw new IllegalArgumentException("null value not allowed.");
		}
	}
	
	/**
	 * Creates an object of type <V>
	 */
	private V instantiate() {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
