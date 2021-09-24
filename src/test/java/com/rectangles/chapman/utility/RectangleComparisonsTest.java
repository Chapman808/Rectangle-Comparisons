package com.rectangles.chapman.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.rectangles.chapman.model.Rectangle;
import com.rectangles.chapman.model.Segment;


public class RectangleComparisonsTest {

	@Test
	public void getIntersectionTest () {
		
		Rectangle rectangleA = new Rectangle(-10, 10, -10, 10);
		Rectangle rectangleB = new Rectangle(0, 15, -15, 15);
		Set<Point> expectedIntersections = new HashSet<>();
			expectedIntersections.add(new Point(0, -10));
			expectedIntersections.add(new Point(0, 10));
		assertEquals(expectedIntersections, RectangleComparisons.getIntersection(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-5, 5, -5, 5);
		rectangleB = new Rectangle(0, 10, -10, 0);
		expectedIntersections = new HashSet<>();
		expectedIntersections.add(new Point(0, -5));
		expectedIntersections.add(new Point(5, 0));
		assertEquals(expectedIntersections, RectangleComparisons.getIntersection(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-5, 5, -5, 5);
		rectangleB = new Rectangle(0, 10, -5, 5);
		expectedIntersections = new HashSet<>();
		expectedIntersections.add(new Point(0, -5));
		expectedIntersections.add(new Point(0, 5));
		expectedIntersections.add(new Point(5, -5));
		expectedIntersections.add(new Point(5, 5));
		assertEquals(expectedIntersections, RectangleComparisons.getIntersection(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-5, 5, -5, 5);
		rectangleB = new Rectangle(0, 10, -5, 0);
		expectedIntersections = new HashSet<>();
		expectedIntersections.add(new Point(0, -5));
		expectedIntersections.add(new Point(5, -5));
		expectedIntersections.add(new Point(5, 0));
		assertEquals(expectedIntersections, RectangleComparisons.getIntersection(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-5, 5, -5, 5);
		rectangleB = new Rectangle(-5, 5, -5, 5);
		expectedIntersections = new HashSet<>();
		expectedIntersections.add(new Point(-5, -5));
		expectedIntersections.add(new Point(-5, 5));
		expectedIntersections.add(new Point(5, -5));
		expectedIntersections.add(new Point(5, 5));
		assertEquals(expectedIntersections, RectangleComparisons.getIntersection(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-5, 5, -5, 5);
		rectangleB = new Rectangle(10, 20, -5, 5);
		assertTrue(RectangleComparisons.getIntersection(rectangleA, rectangleB).isEmpty());

	}
	
	@Test
	public void getLineIntersectionTest () {
		Segment vert = new Segment(new Point(0, 0), 10);
		Segment hor = new Segment(new Point(0,  10), 10);
		Point expectedIntersection = new Point (0, 10);
		assertEquals(expectedIntersection, RectangleComparisons.getSegmentIntersection(vert, hor));
		
		vert = new Segment(new Point(0, 0), 10);
		hor = new Segment(new Point(0,  15), 10);
		expectedIntersection = null;
		assertEquals(expectedIntersection, RectangleComparisons.getSegmentIntersection(vert, hor));
		
		vert = new Segment(new Point(0, 0), 10);
		hor = new Segment(new Point(10,  15), 10);
		expectedIntersection = null;
		assertEquals(expectedIntersection, RectangleComparisons.getSegmentIntersection(vert, hor));
	}
	
	@Test
	public void getAdjacencyTest () {
		Rectangle rectangleA = new Rectangle(-10, 10, -10, 10);
		Rectangle rectangleB = new Rectangle(10, 15, -10, 10);
		assertTrue(RectangleComparisons.getAdjacency(rectangleA, rectangleB));
		
		rectangleA = new Rectangle(-10, 10, -10, 10);
		rectangleB = new Rectangle(15, 20, -10, 10);
		assertFalse(RectangleComparisons.getAdjacency(rectangleA, rectangleB));

		// 'internal' adjacency should fail
		rectangleA = new Rectangle(-10, 10, -10, 10);
		rectangleB = new Rectangle(0, 10, -5, 5);
		assertFalse(RectangleComparisons.getAdjacency(rectangleA, rectangleB));
	}
	
	@Test
	public void getContainmentTest () {
		Rectangle rectangleA = new Rectangle(-10, 10, -10, 10);
		Rectangle rectangleB = new Rectangle(-5, 5, -5, 5);
		assertTrue(RectangleComparisons.getContainment(rectangleA, rectangleB));
		
		//equal rectangles should count as contained
		rectangleA = new Rectangle(-10, 10, -10, 10);
		rectangleB = new Rectangle(-10, 10, -10, 10);
		assertTrue(RectangleComparisons.getContainment(rectangleA, rectangleB));

		rectangleA = new Rectangle(-10, 10, -10, 10);
		rectangleB = new Rectangle(-20, 0, -5, 5);
		assertFalse(RectangleComparisons.getContainment(rectangleA, rectangleB));

	}
}
