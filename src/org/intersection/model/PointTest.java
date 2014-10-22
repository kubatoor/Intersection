package org.intersection.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testHashCode() {
		Point point = new Point(2, 4);
		assertEquals(3, point.hashCode());
	}

}
