package dijkstra;

import java.util.*;

/**
 * 
 * @author Savas Aydin
 */
public class Vertex implements Comparable<Vertex> {

	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	public double longitude, latitude;

	public Vertex(String vertexName, double longitude, double latitude) {
		this.name = vertexName;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

}
