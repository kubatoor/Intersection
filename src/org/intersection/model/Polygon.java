package org.intersection.model;

import org.intersection.core.Constants;
import org.intersection.core.IntersectionUtility;
import org.intersection.core.Shape;

public class Polygon implements Shape {
	private Point[] points;
	
	public Polygon(Point[] points) {
		this.points = points;
		
	}

	/**
	 * @return the points
	 */
	public Point[] getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(Point[] points) {
		this.points = points;
	}

	@Override
	public boolean doIntersect(Shape shape) {
		if(shape instanceof Circle)
			return IntersectionUtility.doIntersect((Circle) shape, this);
		else if(shape instanceof Line)
			return IntersectionUtility.doIntersect(this, (Line) shape);
		else
			throw new UnsupportedOperationException(Constants.UNSUPPORTED_SHAPE);
	}
	

}
