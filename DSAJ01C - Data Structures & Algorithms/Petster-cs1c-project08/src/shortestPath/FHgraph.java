package shortestPath;

import java.util.*;

/**
 * Represents a vertex in the graph.
 *
 * @param <E> the type of data stored in the vertex
 */
class FHvertex<E> {
    public static Stack<Integer> keyStack = new Stack<Integer>();
    public static final int KEY_ON_DATA = 0, KEY_ON_DIST = 1;
    public static int keyType = KEY_ON_DATA;
    public static final double INFINITY = Double.MAX_VALUE;

    public HashSet<Pair<FHvertex<E>, Double>> adjList = new HashSet<Pair<FHvertex<E>, Double>>();
    public E data;
    public double dist;
    public FHvertex<E> nextInPath; // for client-specific info

    /**
     * Creates a vertex with the specified data, setting the distance to source
     * as INFINITY to indicate it's unknown, and nextInPath as null.
     *
     * @param x the object being represented
     */
    public FHvertex(E x) {
        data = x;
        dist = INFINITY;
        nextInPath = null;
    }

    public FHvertex() {
        this(null);
    }

    /**
     * Adds a neighbor vertex and the corresponding cost to the adjacency list.
     *
     * @param neighbor the neighbor vertex to add
     * @param cost     the cost associated with the neighbor vertex
     */
    public void addToAdjList(FHvertex<E> neighbor, double cost) {
        adjList.add(new Pair<FHvertex<E>, Double>(neighbor, cost));
    }

    /**
     * Adds a neighbor vertex and the corresponding cost to the adjacency list.
     * This method is overloaded to accept an integer cost and convert it to double.
     *
     * @param neighbor the neighbor vertex to add
     * @param cost     the cost associated with the neighbor vertex
     */
    public void addToAdjList(FHvertex<E> neighbor, int cost) {
        addToAdjList(neighbor, (double) cost);
    }

    /**
     * Checks if this vertex is equal to the specified object.
     * The equality is based on the key type specified by keyType.
     *
     * @param rhs the object to compare for equality
     * @return true if the specified object is equal to this vertex, false otherwise
     */
    public boolean equals(Object rhs) {
        FHvertex<E> other = (FHvertex<E>) rhs;
        switch (keyType) {
            case KEY_ON_DIST:
                return (dist == other.dist);
            case KEY_ON_DATA:
            default:
                return (data.equals(other.data));
        }
    }

    /**
     * Returns the hash code value for this vertex.
     * The hash code is based on the key type specified by keyType.
     *
     * @return the hash code value for this vertex
     */
    public int hashCode() {
        switch (keyType) {
            case KEY_ON_DIST:
                Double d = dist;
                return d.hashCode();
            case KEY_ON_DATA:
            default:
                return data.hashCode();
        }
    }

    /**
     * Prints the adjacency list of this vertex.
     */
    public void showAdjList() {
        Iterator<Pair<FHvertex<E>, Double>> iter;
        Pair<FHvertex<E>, Double> pair;

        System.out.print("Adj List for " + data + ": ");
        for (iter = adjList.iterator(); iter.hasNext(); ) {
            pair = iter.next();
            System.out.print(pair.first.data + "("
                    + String.format("%3.1f", pair.second)
                    + ") ");
        }
        System.out.println();
    }

    public static boolean setKeyType( int whichType )
    {
        switch (whichType)
        {
            case KEY_ON_DATA:
            case KEY_ON_DIST:
                keyType = whichType;
                return true;
            default:
                return false;
        }
    }
    public static void pushKeyType() { keyStack.push(keyType); }
    public static void popKeyType() { keyType = keyStack.pop(); };
}

/**
 * Represents an edge in a graph, connecting a source vertex to a destination vertex.
 * The edge has a cost associated with it.
 *
 * @param <E> the type of elements in the vertices
 */
class FHedge<E> implements Comparable<FHedge<E>> {
    FHvertex<E> source; // The source vertex of the edge
    FHvertex<E> dest; // The destination vertex of the edge
    double cost; // The cost of the edge

    /**
     * Constructs an FHedge object with the specified source, destination, and cost.
     *
     * @param src  the source vertex of the edge
     * @param dst  the destination vertex of the edge
     * @param cst  the cost of the edge
     */
    FHedge(FHvertex<E> src, FHvertex<E> dst, Double cst) {
        source = src;
        dest = dst;
        cost = cst;
    }

    /**
     * Constructs an FHedge object with the specified source, destination, and cost.
     * The cost is provided as an integer and converted to double.
     *
     * @param src  the source vertex of the edge
     * @param dst  the destination vertex of the edge
     * @param cst  the cost of the edge as an integer
     */
    FHedge(FHvertex<E> src, FHvertex<E> dst, Integer cst) {
        this(src, dst, cst.doubleValue());
    }

    /**
     * Constructs an FHedge object with null source, destination, and a default cost of 1.0.
     */
    FHedge() {
        this(null, null, 1.0);
    }

    /**
     * Compares this edge to another edge based on their costs.
     *
     * @param rhs  the other FHedge object to compare to
     * @return -1 if this edge has a lower cost, 1 if it has a higher cost, or 0 if they have the same cost
     */
    @Override
    public int compareTo(FHedge<E> rhs) {
        return Double.compare(cost, rhs.cost);
    }
}

/**
 * Represents a graph data structure with vertices and edges.
 *
 * @param <E> the type of elements in the vertices
 */
public class FHgraph<E> {
    protected HashSet<FHvertex<E>> vertexSet; // The set of vertices in the graph

    /**
     * Constructs an empty FHgraph object.
     */
    public FHgraph() {
        vertexSet = new HashSet<>();
    }

    /**
     * Constructs an FHgraph object with the specified edges.
     *
     * @param edges an array of edges to be added to the graph
     */
    public FHgraph(FHedge<E>[] edges) {
        this();
        int numEdges = edges.length;

        for (int k = 0; k < numEdges; k++)
            addEdge(edges[k].source.data, edges[k].dest.data, edges[k].cost);
    }

    /**
     * Adds an edge to the graph between the specified source and destination vertices with the given cost.
     *
     * @param source the source vertex of the edge
     * @param dest   the destination vertex of the edge
     * @param cost   the cost of the edge
     */
    public void addEdge(E source, E dest, double cost) {
        FHvertex<E> src = addToVertexSet(source);
        FHvertex<E> dst = addToVertexSet(dest);
        src.addToAdjList(dst, cost);
    }

    /**
     * Adds an edge to the graph between the specified source and destination vertices with the given cost.
     * The cost is provided as an integer and converted to double.
     *
     * @param source the source vertex of the edge
     * @param dest   the destination vertex of the edge
     * @param cost   the cost of the edge as an integer
     */
    public void addEdge(E source, E dest, int cost) {
        addEdge(source, dest, (double) cost);
    }

    /**
     * Adds a vertex with the specified data to the vertex set.
     *
     * @param x the data of the vertex to be added
     * @return the reference to the added vertex
     */
    public FHvertex<E> addToVertexSet(E x) {
        FHvertex<E> retVal, vert;
        boolean successfulInsertion;
        Iterator<FHvertex<E>> iter;

        FHvertex.pushKeyType();
        FHvertex.setKeyType(FHvertex.KEY_ON_DATA);

        retVal = new FHvertex<>(x);
        successfulInsertion = vertexSet.add(retVal);

        if (successfulInsertion) {
            FHvertex.popKeyType();
            return retVal;
        }

        for (iter = vertexSet.iterator(); iter.hasNext(); ) {
            vert = iter.next();
            if (vert.equals(retVal)) {
                FHvertex.popKeyType();
                return vert;
            }
        }

        FHvertex.popKeyType();
        return null;
    }

    /**
     * Displays the adjacency table of the graph.
     */
    public void showAdjTable() {
        Iterator<FHvertex<E>> iter = vertexSet.iterator();

        System.out.println("------------------------");
        while (iter.hasNext())
            iter.next().showAdjList();
        System.out.println();
    }

    /**
     * Returns a shallow copy of the vertex set of the graph.
     *
     * @return the copy of the vertex set
     */
    public HashSet<FHvertex<E>> getVertSet() {
        return (HashSet<FHvertex<E>>) vertexSet.clone();
    }
    /**
     * Clears the graph by removing all vertices and edges.
     */
    public void clear() {
        vertexSet.clear();
    }

    /**
     * Sets the graph using the provided list of edges.
     * Clears the existing graph and adds new vertices and edges based on the input.
     *
     * @param edges the list of edges to set the graph with
     */
    public void setGraph(ArrayList<FHedge<E>> edges) {
        clear();

        int numEdges = edges.size();
        for (int k = 0; k < numEdges; k++) {
            addEdge(edges.get(k).source.data, edges.get(k).dest.data, edges.get(k).cost);
        }
    }

    /**
     * Applies Dijkstra's algorithm to find the shortest path from the specified vertex to all other vertices,
     * excluding the vertices in the provided excludeList.
     *
     * @param x           the starting vertex
     * @param excludeList the list of vertices to exclude from the path
     * @return true if the algorithm is successful, false otherwise
     */
    public boolean dijkstra(E x, ArrayList<E> excludeList) {
        ArrayList<FHvertex<E>> vertToAvoid = new ArrayList<>();
        FHvertex<E> w, s, v;
        Pair<FHvertex<E>, Double> edge;
        Iterator<FHvertex<E>> iter;
        Iterator<Pair<FHvertex<E>, Double>> edgeIter;
        Double costVW;
        Deque<FHvertex<E>> partiallyProcessedVerts = new LinkedList<FHvertex<E>>();

        for (E cities : excludeList) {
            if (getVertexWithThisData(cities) != null) {
                vertToAvoid.add(getVertexWithThisData(cities));
            }
        }

        s = getVertexWithThisData(x);
        if (s == null) {
            return false;
        }

        // Initialize the vertex list and place the starting vertex in the partially processed vertices queue
        for (iter = vertexSet.iterator(); iter.hasNext(); ) {
            iter.next().dist = FHvertex.INFINITY;
        }

        s.dist = 0;
        partiallyProcessedVerts.addLast(s);

        // Outer Dijkstra's algorithm loop
        while (!partiallyProcessedVerts.isEmpty()) {
            v = partiallyProcessedVerts.removeFirst();

            // Inner Dijkstra's algorithm loop: for each vertex adjacent to v, lower its distance
            // to s if possible
            for (edgeIter = v.adjList.iterator(); edgeIter.hasNext(); ) {
                edge = edgeIter.next();
                w = edge.first;
                costVW = edge.second;
                if (v.dist + costVW < w.dist && !vertToAvoid.contains(w)) {
                    w.dist = v.dist + costVW;
                    w.nextInPath = v;

                    // w now has an improved distance, so add w to the partially processed vertices queue
                    partiallyProcessedVerts.addLast(w);
                }
            }
        }
        return true;
    }

    /**
     * Finds the shortest path from vertex x1 to vertex x2 using Dijkstra's algorithm,
     * excluding the vertices in the provided citiesToAvoid list.
     *
     * @param x1           the starting vertex
     * @param x2           the destination vertex
     * @param citiesToAvoid the list of vertices to avoid in the path
     * @return true if a path is found and printed, false otherwise
     */
    public boolean showShortestPath(E x1, E x2, ArrayList<E> citiesToAvoid) {
        FHvertex<E> start, stop, vert;
        Stack<FHvertex<E>> pathStack = new Stack<FHvertex<E>>();

        start = getVertexWithThisData(x1);
        stop = getVertexWithThisData(x2);
        if (start == null || stop == null) {
            return false;
        }

        // Run Dijkstra's algorithm
        dijkstra(x1, citiesToAvoid);

        if (stop.dist == FHvertex.INFINITY) {
            System.out.println("No path exists.");
            return false;
        }

        for (vert = stop; vert != start; vert = vert.nextInPath) {
            pathStack.push(vert);
        }
        pathStack.push(vert);

        System.out.println("Cost of shortest path from " + x1
                + " to " + x2 + ": " + stop.dist);
        while (true) {
            vert = pathStack.pop();
            if (pathStack.empty()) {
                System.out.println(vert.data);
                break;
            }
            System.out.print(vert.data + " -> ");
        }
        return true;
    }

    /**
     * Applies Dijkstra's algorithm to find the shortest distances from the specified vertex to all other vertices,
     * excluding the vertices in the provided citiesToAvoid list.
     *
     * @param x            the starting vertex
     * @param citiesToAvoid the list of vertices to avoid
     * @return true if the algorithm is successful, false otherwise
     */
    public boolean showDistancesTo(E x, ArrayList<E> citiesToAvoid) {
        Iterator<FHvertex<E>> iter;
        FHvertex<E> vert;

        if (!dijkstra(x, citiesToAvoid)) {
            return false;
        }

        for (iter = vertexSet.iterator(); iter.hasNext(); ) {
            vert = iter.next();
            System.out.println(vert.data + " " + vert.dist);
        }
        System.out.println();
        return true;
    }

    /**
     * Retrieves the vertex with the specified data from the graph.
     *
     * @param x the data of the vertex to retrieve
     * @return the vertex with the specified data, or null if not found
     */
    protected FHvertex<E> getVertexWithThisData(E x) {
        FHvertex<E> searchVert, vert;
        Iterator<FHvertex<E>> iter;

        // Save sort key for the client
        FHvertex.pushKeyType();
        FHvertex.setKeyType(FHvertex.KEY_ON_DATA);

        // Build vertex with data = x for the search
        searchVert = new FHvertex<E>(x);

        // Search for the vertex in the vertex set
        for (iter = vertexSet.iterator(); iter.hasNext(); ) {
            vert = iter.next();
            if (vert.equals(searchVert)) {
                FHvertex.popKeyType();
                return vert;
            }
        }

        FHvertex.popKeyType();
        return null; // Not found
    }
}