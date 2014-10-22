package org.intersection.core;
import static org.junit.Assert.*;

import org.intersection.model.Circle;
import org.intersection.model.Line;
import org.intersection.model.Point;
import org.intersection.model.Polygon;
import org.junit.Test;


public class IntersectionUtilityTest {
	
	private static final Point origin = new Point(0,0);
	@Test
	public void testGetIntersectionPoint(){
		Line lineA = new Line(1, 0);
		Line lineB = new Line(-1,0);
		Point intPoint = IntersectionUtility.getIntersectionPoint(lineA, lineB);
		assertEquals(origin, intPoint);
		
		lineA = new Line(1.5, 2);
		lineB = new Line(1.6666666666666667, 3);
		intPoint = IntersectionUtility.getIntersectionPoint(lineA, lineB);
		if((intPoint.getPointX() - (-6)) > Constants.EPSILON ||
		((intPoint.getPointY()) - (-7)) > Constants.EPSILON) {
			fail("Assertion failed");
		}
		
		lineA = new Line(1.5,2);
		lineB = new Line(1.5, 4);
		intPoint = IntersectionUtility.getIntersectionPoint(lineA, lineB);
		assertNull(intPoint);
	}
	
	@Test
	public void testDoIntersectLineCircle(){
		Line lineA = new Line(new Point(0,4), new Point(-4,6));
		Point center = new Point(4, 4);
		Circle circle = new Circle(center, 6.0);
		assertTrue(IntersectionUtility.doIntersect(lineA, circle));
		//tangent line intersection
		lineA = new Line(new Point(-8.16,-4),new Point(-3.02, -4));
		center = new Point(-4,-7.0);
		circle = new Circle(center,3.0);
		assertTrue(IntersectionUtility.doIntersect(lineA, circle));
		
		lineA = new Line(new Point(-8.16,-4),new Point(-3.02, -4));
		center = new Point(-4,-7.01);
		circle = new Circle(center,3.0);
		assertFalse(IntersectionUtility.doIntersect(lineA, circle));
		
	
	}
	
	@Test
	public void testIsOnLineSegment(){
		Point pointA = new Point(-2,0);
		Point pointB = new Point(-44,0);
		Point pointC = new Point(-3,0);
		assertTrue(IntersectionUtility.isOnLineSegment(pointA, pointB, pointC));
		
		pointA = new Point(-2,0);
		pointB = new Point(-44,0);
		pointC = new Point(-3,2);
		assertFalse(IntersectionUtility.isOnLineSegment(pointA, pointB, pointC));
		
		pointA = new Point(4,0);
		pointB = new Point(0,4);
		pointC = new Point(2,2);
		assertTrue(IntersectionUtility.isOnLineSegment(pointA, pointB, pointC));
		
		pointA = new Point(-3,-0.1);
		pointB = new Point(0,4);
		pointC = new Point(2,2);
		assertFalse(IntersectionUtility.isOnLineSegment(pointA, pointB, pointC));
	
	}
	
	@Test
	public void testDoIntersectLinePolygon(){
		Line line = new Line(new Point(-4,-4), new Point(-4, 4));
		Point[] points = {new Point(-4, -4),new Point(3, 2),new Point(-3, 2)};
		Polygon polygon = new Polygon(points);
		assertTrue(IntersectionUtility.doIntersect(polygon, line));
		
		Line line1 = new Line(new Point(-2,-4), new Point(1.5, -4));
		Point[] points1 = {new Point(2, -1),new Point(4, -1),new Point(4, -5),new Point(2,-5)};
		Polygon polygon1 = new Polygon(points1);
		assertFalse(IntersectionUtility.doIntersect(polygon1, line1));
		
		line1 = new Line(new Point(-2,-4), new Point(2, -4));
		Point[] points2 = {new Point(2, -1),new Point(4, -1),new Point(4, -5),new Point(2,-5)};
		polygon1 = new Polygon(points2);
		assertTrue(IntersectionUtility.doIntersect(polygon1, line1));
		
	}
	
	@Test
	public void testDoIntersectPolygonCircle(){
		Point center = new Point(4, 4);
		Circle circle = new Circle(center, 6.0);
		Point[] points = {new Point(-4, -4),new Point(3, 2),new Point(-3, 2)};
		Polygon polygon = new Polygon(points);
		//assertTrue(IntersectionUtility.doIntersect(circle, polygon));
		
		center = new Point(4, -4);
		circle = new Circle(center, 2.0);
		Point[] points1 = {new Point(-2, -2),new Point(-3,-4),new Point(-5, -4), new Point(-4, -2)};
		polygon = new Polygon(points1);
		assertFalse(IntersectionUtility.doIntersect(circle, polygon));
		
		center = new Point(4, -4);
		circle = new Circle(center, 2.0);
		Point[] points2 = {new Point(-2, -2),new Point(-3,-4),new Point(-5, -4), new Point(-4, -2)};
		polygon = new Polygon(points2);
		assertFalse(IntersectionUtility.doIntersect(circle, polygon));
	}
	
	@Test
	public void testDistanceBetweenPoints(){
		
		Point pointA = new Point(2, 2);
		Point pointB = new Point(6, 7);
		assertEquals(6.40, IntersectionUtility.distBtwPoints(pointA, pointB), Constants.EPSILON);
		
		pointA = new Point(4,-4);
		pointB = new Point(-3,-4);
		assertEquals(7.0, IntersectionUtility.distBtwPoints(pointA, pointB), Constants.EPSILON);
        
		
	}
	
	

}
