package edu.isu.cs.cs3308.structures;

import java.util.List;

/**
 * Interface defining the basic operations of a graph vertex
 */
public interface Vertex<V, E> {

    /** Returns the element associated with this vertex */
    V getElement();

    /** Reutrns the list of outgoing edges of this vertex */
    List<Edge<V, E>> getOutgoing();

    /** Reutrns the list of incoming edges of this vertex */
    List<Edge<V, E>> getIncoming();


}
