package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Vertex;

import java.util.List;

public class DiVertex<V, E> implements Vertex<V, E> {

    private V element;
    List<Edge<V, E>> outgoing;

    public DiVertex(V element){
        this.element = element;
    }

    /**
     * Returns the element associated with this vertex
     */
    @Override
    public V getElement() {
        return null;
    }

    /**
     * Returns the list of incoming edges of this vertex
     */
    @Override
    public List<Edge<V, E>> getIncoming() {
        return null;
    }

    /**
     * Returns the list of outgoing edges of this vertex
     */
    @Override
    public List<Edge<V, E>> getOutgoing() {
        return outgoing;
    }
}
