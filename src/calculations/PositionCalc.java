package calculations;

/**
 * PositionCalc class is a class to convert GPS coordinates in decimal form to a
 * position value to be displayed on the map
 * 
 * @author Magnus Bergqvist
 */
public class PositionCalc {

	public static int calcX(double longitude) {

		double xIn = longitude;

		double xSteps = (xIn - 11.9310) * 10000; // xIn minus west-most
													// longitude

		double xCalc = xSteps * 8.461;// <xSteps times no.of pixels
										// per0.0001degree
		int x = (int) xCalc; // <--round it and use as x-position

		return x;
	}

	public static int calcY(double latitude) {

		double yIn = latitude;

		double ySteps = (yIn - 57.70291) * 100000;
		double yCalc = ySteps * 1.583;
		int y = 796 - (int) yCalc;

		return y;
	}
}
