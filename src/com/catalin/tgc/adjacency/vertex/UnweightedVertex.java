package com.catalin.tgc.adjacency.vertex;

/**
 * The basic vertex implementation.
 * Comes with a label.
 * 
 * @author Florea Catalin
 */
public class UnweightedVertex extends AbstractVertex {
	
	/** The label of the vertex. */
    private String label;
    
    /**
     * Instantiates an unweighted vertex.
     */
    public UnweightedVertex() {
		super();
	}

	/**
     * Instantiates a vertex.
     * @param label the label of the vertex
     */
    public UnweightedVertex(String label) {
        this.label = label;
    }

    /** {@inheritDoc} */
	public String getLabel() {
		return label;
	}

	/** {@inheritDoc} */
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	/** {@inheritDoc} */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	/** {@inheritDoc} */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnweightedVertex other = (UnweightedVertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
    
}