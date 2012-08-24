package dijkstra;

/**
 * @author Savas Aydin
 */
public class Edge {
	public final Vertex target;
	public final int weight;

	public Edge(Vertex targetVertex, int distance) {
		this.target = targetVertex;
		this.weight = distance;
	}
}
