package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Edge;
import edu.isu.cs.cs3308.structures.Graph;
import edu.isu.cs.cs3308.structures.Vertex;
import java.util.*;

public abstract class AbstractGraph<V, E> implements Graph<V, E> {
    Map<V, List<Edge<V, E>>> adjMap;

    public AbstractGraph() {
        adjMap = new HashMap<>();
    }

    /**
     * Returns the number of vertices of the graph
     */
    @Override
    public int numVertices() {
        final int[] sum = {0};
        adjMap.values().forEach(v -> {
            sum[0] += v.size();
        });
        return sum[0];
    }

    /**
     * Returns an iteration of all the vertices of the graph
     */
    @Override
    public Iterator<V> vertices() {
        return adjMap.keySet().iterator();
    }

    /**
     * Returns the number of edges of the graph
     */
    @Override
    public int numEdges() {
        return 0;
    }

    /**
     * Returns an iteration of all edges of the graph
     */
    @Override
    public Iterator<Edge<V, E>> edges() {
        List<Edge<V, E>> edges = new ArrayList<>();
        for (List<Edge<V, E>> list : adjMap.values()) {
            edges.addAll(list);
        }
        return edges.iterator();
    }

    /**
     * Returns the edge from vertex u to vertex v, if one exists, otherwise returns null.
     * For an undirected graph, there is no difference between getEdge(u, v) and getEdge(v, u)
     *
     * @param u
     * @param v
     */
    @Override
    public Edge getEdge(V v, V u) {
        if (v == null || u == null) {
            return null;
        }

        if (adjMap.containsKey(v)) {
            for (Edge<V, E> edge : adjMap.get(v)) {
                EdgeImpl temp = (EdgeImpl) edge;
                if (temp.getDest().equals(u)) return edge;
            }
        }
        return null;
    }

    /**
     * Returns an array containing the two endpoint vertices of edge e. If the graph is directed
     * the first vertex is the origin and the second is the destination.
     *
     * @param e
     */
    @Override
    public V[] endVertices(Edge<V, E> e) {
        EdgeImpl<V, E> temp = (EdgeImpl) e;
        V[] ret = (V[])new Object[]{temp.getSrc(), temp.getDest()};

        return ret;
    }

    /**
     * For edge e incident to vertex v, returns the other vertex of the edge; an error occurs
     * if e is not incident to v.
     *
     * @param v
     * @param e
     */
    @Override
    public V opposite(V v, Edge<V, E> e) {
        if (v != null && e != null) {
            EdgeImpl<V, E> temp = (EdgeImpl) e;
            if (temp.getDest().equals(v)) return temp.getSrc();
            else return temp.getDest();
        }
        return null;
    }

    /**
     * Returns the number of outgoing edges from vertex v.
     *
     * @param v
     */
    @Override
    public int outDegree(V v) {
        if (v != null && adjMap.containsKey(v)) {
            return adjMap.get(v).size();
        }
        return 0;
    }

    /**
     * Returns the number of incoming edges to vertex v. For an undirected graph, this returns
     * the same value as does outDegree(v)
     *
     * @param v
     */
    @Override
    public int inDegree(V v) {
        int indegree = 0;
        if (v != null) {
            for (V k : adjMap.keySet()) {
                if (k.equals(v)) {
                    EdgeImpl<V, E> e = new EdgeImpl<>(k, v, null);
                    if (adjMap.get(k).contains(e)) {
                        indegree += 1;
                    }
                }
            }
        }
        return indegree;
    }

    /**
     * Returns an iteration of all outgoing edges from vertex v
     *
     * @param v
     */
    @Override
    public Iterator<Edge<V, E>> outgoingEdges(V v) {
        if (v != null && adjMap.containsKey(v)) {
            return adjMap.get(v).iterator();
        }
        return null;
    }

    /**
     * Returns an iteration of all incoming edges to vertex v. For an undirected graph, this
     * returns the same collection as does outgoingEdges(v)
     *
     * @param v
     */
    @Override
    public Iterator<Edge<V, E>> incomingEdges(Vertex<V, E> v) {
        List<Edge<V, E>> edges = new ArrayList<>();
        if (v != null) {
            for (V k : adjMap.keySet()) {
                if (k.equals(v)) {
                    for (Edge<V, E> edge : adjMap.get(k)) {
                        EdgeImpl temp = (EdgeImpl) edge;
                        if (temp.getDest().equals(v)) edges.add(edge);
                    }
                }
            }
        }
        return edges.iterator();
    }


        /**
         * Creates and returns a new Vertex storing element v
         *
         * @param v
         */
        @Override
        public V insertVertex (V v){
            if (v != null && !adjMap.containsKey(v)) adjMap.put(v, new LinkedList<>());
            return v;
        }

        /**
         * Creates and returns a new Edge from vertex u to vertex v, storing element e; an error occurs
         * if there already exists an edge from u to v
         *
         * @param u
         * @param v
         * @param e
         */
        @Override
        public void insertEdge (V v, V u, E e){
            if (v == null || u == null) return;

            if (adjMap.containsKey(v)) {
                List<Edge<V, E>> edges = adjMap.get(v);
                EdgeImpl<V, E> edge = new EdgeImpl<>(v, u, e);
                if (!edges.contains(edge)) edges.add(edge);
            }
        }

        /**
         * Removes vertex v and all its incident edges from the graph
         *
         * @param v
         */
        @Override
        public void removeVertex (V v){
            if (v != null) {
                if (adjMap.containsKey(v)) adjMap.remove(v);
            }
            List<Edge<V, E>> edges = new ArrayList<>();
            for (List<Edge<V, E>> list : adjMap.values()) {
                for (Edge<V, E> e : list) {
                    EdgeImpl temp = (EdgeImpl) e;
                    if (temp.getDest().equals(v)) edges.add(e);
                }
            }
            for (Edge<V, E> edge : edges) {
                EdgeImpl temp = (EdgeImpl) edge;
                adjMap.get(temp.getSrc()).remove(edge);
            }
        }

        /**
         * Removes edge e from the graph
         *
         * @param e
         */
        @Override
        public void removeEdge (Edge< V, E > e){
            if (e != null) {
                EdgeImpl<V, E> temp = (EdgeImpl) e;
                if (adjMap.containsKey(temp.getSrc())) {
                    adjMap.get(temp.getSrc()).remove(e);
                }
            }
        }
    }
