package dijkstra;

import java.util.ArrayList;

import calculations.PositionCalc;

/**
 * We can draw a line between nodes to get value of angle. Then it is easy to
 * find the direction to follow in path of route by comparing those angles. This
 * class makes the calculations to find the angles between given 2 points.
 * 
 * @author Savas Aydin
 */
public class Directions {

	public static ArrayList<Double> inclineList = new ArrayList<Double>();
	public static ArrayList<String> directionList = new ArrayList<String>();

	public void direction(ArrayList<Vertex> pathList) {

		for (int i = 0; i < pathList.size(); i++) {

			double xIn = pathList.get(i).getLongitude();
			double yIn = pathList.get(i).getLatitude();

			double x = PositionCalc.calcX(xIn);
			double y = PositionCalc.calcY(yIn);

			if (i > 0) {
				double xInOld = pathList.get(i - 1).getLongitude();
				double yInOld = pathList.get(i - 1).getLatitude();

				double xOld = PositionCalc.calcX(xInOld);
				double yOld = PositionCalc.calcY(yInOld);

				double m = (y - yOld) / (x - xOld);
				double angle = Math.atan(m) * 180 / Math.PI;
				if (angle < 0) {
					angle = 90 - angle;
				}
				if ((yOld > y) && (xOld < x)) {
					angle = -angle;
				}
				if ((yOld > y) && (xOld > x)) {
					angle = 180 + angle;
				}
				inclineList.add(angle);

			}

		}

		for (int j = 0; j < pathList.size(); j++) {
			System.out.print(pathList.get(j) + " ");
			if (j >= 1 & j < Dijkstra.path.size() - 1) {
				if ((inclineList.get(j) - inclineList.get(j - 1)) > 25) {
					System.out.print("Turn Right ");
					directionList.add("Turn Right");
				} else if ((inclineList.get(j) - inclineList.get(j - 1)) < -25) {
					System.out.print("Turn Left  ");
					directionList.add("Turn Left");
				} else {
					System.out.print("Go Straight  ");
					directionList.add("Go Straight");
				}
			}
		}

	}
}
