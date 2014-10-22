package org.intersection.core;
import java.util.Scanner;

import org.intersection.model.Circle;
import org.intersection.model.Line;
import org.intersection.model.Point;
import org.intersection.model.Polygon;

public class Client {
	
	private static final Scanner scanner = new Scanner(System.in);
	private static final String EOL = System.getProperty("line.separator");
	public static void main(String[] args) {
		
		printWelcomeString();
		String input = (scanner.nextLine());
		callSelection(input);
	}

	private static void printWelcomeString() {
		StringBuilder builder = new StringBuilder("Hi.Welcome to the Intersection application")
		.append(EOL)
		.append("Please provide your input")
		.append(EOL)
		.append("Please select from the following options.Type the corresponding number")
		.append(EOL)
		.append("(1) Check intersection of Circle and Line")
		.append(EOL)
		.append("(2) Check intersection of Circle and Polygon")
		.append(EOL)
		.append("(3) Check intersection of Line and Polygon")
		.append(EOL)
		.append("(4) Exit");
		System.out.println(builder.toString());
		
	}

	private static void callSelection(String input) {
		switch(input){
		case "1": callCircleLineIntersection();
		          break;
		case "2": callCirclePolygonIntersection();
		          break;
		case "3": callLinePolygonIntersection();
		          break;
		case "4": break;
		default : System.out.print("Invalid selection.");
		          tryAgain();
		}
		
	}

	private static void tryAgain() {
		System.out.println("Try again");
		String input = (scanner.nextLine());
		callSelection(input);
		
	}

	private static void callLinePolygonIntersection() {
		
		Line line = constructLine();
		Polygon polygon = constructPolygon();
		if(line.doIntersect(polygon))
			log(Constants.LINE_POLYGON_INTERSECT);
		else
			log(Constants.LINE_POLYGON_DONOT_INTERSECT);
	}

	private static void callCirclePolygonIntersection() {
		Polygon polygon = constructPolygon();
		Circle circle = constructCircle();
		if(circle.doIntersect(polygon))
			log(Constants.CIRCLE_POLYGON_INTERSECT);
		else
			log(Constants.CIRCLE_POLYGON_DONOT_INTERSECT);
	}

	private static void callCircleLineIntersection() {
		Circle circle = constructCircle();
		Line line = constructLine();
		if(circle.doIntersect(line))
			log(Constants.LINE_CIRCLE_INTERSECT);
		else
			log(Constants.LINE_CIRCLE_DONOT_INTERSECT);
	}

	private static Line constructLine() {
		String[] points;
		do {
			System.out.println("Provide the 2 points of the line in the format "+Constants.TWO_POINT_FORMAT);
			points = scanner.nextLine().split(",");
		} while (!Validator.validatePoints(points, 2));
		double X1 = Double.parseDouble(points[0]);
		double Y1 = Double.parseDouble(points[1]);
		double X2 = Double.parseDouble(points[2]);
		double Y2 = Double.parseDouble(points[3]);
		Point pointA = new Point(X1, Y1);
		Point pointB = new Point(X2, Y2);
		return new Line(pointA, pointB);
	}

	private static Circle constructCircle() {
		String[] point;
		do {
			System.out.println("Enter the center for circle in the format "+Constants.POINT_FORMAT);
			point = scanner.nextLine().split(",");
		} while (!Validator.validatePoints(point,1));
		double X = Double.parseDouble(point[0]);
		double Y = Double.parseDouble(point[1]);
		Point center = new Point(X, Y);
		double radius = 0.0;
		String input = null;
		do {
			System.out.println("Enter the radius of circle");
			input = scanner.nextLine();
		} while(!Validator.validateDouble(input));
		radius = Double.parseDouble(input);
		return new Circle(center, radius);
	}
	
	private static Polygon constructPolygon(){
		String[] strPoints;
		int noOfPoints;
		System.out.println("Enter the number of points of the Polygon");
		noOfPoints = Integer.parseInt(scanner.nextLine());
		do {
			System.out.println("Enter the various points of the Polygon in the format "+Constants.POLY_POINT_FORMAT);
			strPoints = scanner.nextLine().split(",");
					
			} while (!Validator.validatePoints(strPoints, noOfPoints));
		
		Point[] points = new Point[noOfPoints];
		for(int i = 0 ; i < strPoints.length ; i++){
			if((i%2) == 0){
				double X = Double.parseDouble(strPoints[i]);
				double Y = Double.parseDouble(strPoints[i+1]);
				Point point = new Point(X,Y);
				points[(i/2)] = point;
			}
		}
		return new Polygon(points);
		
	}
	
	private static void log(String str){
		System.out.println(str);
	}
	
	

}
