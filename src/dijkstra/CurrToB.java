package dijkstra;

import java.util.List;
import calculations.*;
import reader.Reader;

/**
 * This class is to find closest vertex from current position.
 * 
 * @author Savas Aydin
 */
public class CurrToB {

	/**
	 * This variables are comprised to used in Converter method.
	 */
	public static int total = 0;
	public static double min = 999999.0;
	public static int indexOfVertex;
	public static double distanceToClosestVertex;

	public static void setStartTargetFromCurr(Vertex startV, Vertex endV) {
		Dijkstra.implementationDijkstra(startV); // v1=source vertex
		{
			List<Vertex> path = Dijkstra.getShortestPathTo(endV);
			System.out.println("Path: " + path);
			System.out.println("Distance to "
					+ endV
					+ ": "
					+ (endV.minDistance + DistanceCalc.distanceToClosest(
							Double.parseDouble(Reader.gpsData.longitude),
							Double.parseDouble(Reader.gpsData.latitude),
							Dijkstra.path.get(0))));

		}
	}

	public void Converter(double longit, double latit, Vertex targetVertex) {

		for (int i = 0; i < Dijkstra.allVertexList.size(); i++) {
			double xIn = Dijkstra.allVertexList.get(i).getLongitude();
			double yIn = Dijkstra.allVertexList.get(i).getLatitude();

			int x = PositionCalc.calcX(xIn);

			int y = PositionCalc.calcY(yIn);

			int xCurr = PositionCalc.calcX(longit);
			int yCurr = PositionCalc.calcY(latit);

			int xDif = x - xCurr;
			int yDif = y - yCurr;

			total = (int) Math.sqrt(Math.abs((xDif * xDif) + (yDif * yDif)));

			if (total < min) {
				min = total;
				indexOfVertex = i;
			}
		}

		setStartTargetFromCurr(Dijkstra.allVertexList.get(indexOfVertex),
				targetVertex);

	}

}
