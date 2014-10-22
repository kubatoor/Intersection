package org.intersection.model;

import org.intersection.core.Constants;
import org.intersection.core.IntersectionUtility;
import org.intersection.core.Shape;

public class Circle implements Shape {
	
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius){
		this.center = center;
		this.radius = radius;
	}
	
	/**
	 * @return the center
	 */
	public Point getCenter() {
		return center;
	}
	/**
	 * @param center the center to set
	 */
	public void setCenter(Point center) {
		this.center = center;
	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public boolean doIntersect(Shape shape) {
		if(shape instanceof Polygon)
			return IntersectionUtility.doIntersect(this, (Polygon) shape);
		else if(shape instanceof Line)
			return IntersectionUtility.doIntersect((Line) shape, this);
		else
			throw new UnsupportedOperationException(Constants.UNSUPPORTED_SHAPE);
	}


}
