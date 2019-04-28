package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Vertex;
import java.util.Objects;

public class EdgeImpl<V, E> implements Edge<V, E> {

    private V src;
    private V dest;
    private E element;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EdgeImpl)) return false;
        EdgeImpl<?, ?> edge = (EdgeImpl<?, ?>) o;
        return getSrc().equals(edge.getSrc()) &&
                getDest().equals(edge.getDest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSrc(), getDest());
    }

    public EdgeImpl(V src, V dest, E element) {
        this.src = src;
        this.dest = dest;
        this.element = element;
    }

    public V getSrc() {
        return src;
    }

    public void setSrc(V src) {
        this.src = src;
    }

    public V getDest() {
        return dest;
    }

    public void setDest(V dest) {
        this.dest = dest;
    }

    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Returns the element associated with the edge
     */
    @Override
    public E getElement() {
        return null;
    }

    /**
     * Returns an array of the two endpoints of the edge.
     */
    @Override
    public Vertex[] getEndpoints() {
        return new Vertex[0];
    }
}
