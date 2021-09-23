package com.rectangles.chapman.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.rectangles.chapman.model.Rectangle;


public class RectangleComparisonsTest {

	@Test
	public void getIntersectionTest () {
		Rectangle rectangleA = new Rectangle(-10, 10, 10, -10);
		Rectangle rectangleB = new Rectangle(0, 15, 15, -15);
		assertTrue(RectangleComparisons.getIntersection(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-10, 10, 10, -10);
		rectangleB = new Rectangle(0, 8, 9, -9);
		assertFalse(RectangleComparisons.getIntersection(rectangleA, rectangleB));
	}
	
	@Test
	public void getAdjacencyTest () {
		Rectangle rectangleA = new Rectangle(-10, 10, 10, -10);
		Rectangle rectangleB = new Rectangle(10, 15, 10, -10);
		assertTrue(RectangleComparisons.getAdjacency(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-10, 10, 10, -10);
		rectangleB = new Rectangle(15, 20, 10, -10);
		assertFalse(RectangleComparisons.getAdjacency(rectangleA, rectangleB));

	}
	
	@Test
	public void getContainmentTest () {
		Rectangle rectangleA = new Rectangle(-10, 10, 10, -10);
		Rectangle rectangleB = new Rectangle(-5, 5, 5, -5);
		assertTrue(RectangleComparisons.getContainment(rectangleA, rectangleB));

		rectangleA = new Rectangle(-10, 10, 10, -10);
		rectangleB = new Rectangle(-20, 0, 5, -5);
		assertFalse(RectangleComparisons.getContainment(rectangleA, rectangleB));

	}
}
