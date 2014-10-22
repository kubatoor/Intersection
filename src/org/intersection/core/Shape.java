package org.intersection.core;

public interface Shape {
	boolean doIntersect(Shape shape) throws UnsupportedOperationException;
}
