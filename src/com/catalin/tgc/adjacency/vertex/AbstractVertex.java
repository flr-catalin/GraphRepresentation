package com.catalin.tgc.adjacency.vertex;

/**
 * Abstract vertex implementation.
 * 
 * @author Florea Catalin
 */
public abstract class AbstractVertex {

	/**
	 * Protected constructor.
	 */
	protected AbstractVertex() {
		super();
	}

	/**
	 * Gets the label of the vertex.
	 */
	public abstract String getLabel();

	/**
	 * Sets the label of the vertex
	 */
	public abstract void setLabel(String label);
	
}
