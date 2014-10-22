package org.intersection.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {

	
	@Test
	public void testConstructorWithPointAndSlope(){
		Point point = new Point(0, 2);
		Line line = new Line(point, Double.POSITIVE_INFINITY);
		assertEquals(Double.POSITIVE_INFINITY, line.getSlope(), 0.0001);
	}

}
