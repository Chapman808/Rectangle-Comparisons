package com.rectangles.chapman.model;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Anthony Chapman
 * @since 9/24/2021
 *
 */
public class RectangleTest {

	private Rectangle rect;
	
	@Before
	public void setup () {
		rect = new Rectangle (-10, 10, -10, 10);
	}
	@Test 
	public void createRectange_Expect_CorrectSides () {
		assertEquals(-10, rect.getLeft());
		assertEquals(10, rect.getRight());
		assertEquals(-10, rect.getBottom());
		assertEquals(10, rect.getTop());
	}
	
	@Test
	public void createRectangle_Expect_SideSegmentsInitializedCorrectly () {
		Segment leftSide = rect.getSides().get("Left");
		assertEquals(new Point(-10, -10), leftSide.getMin());
		assertEquals(20, leftSide.getLength());
		
		Segment rightSide = rect.getSides().get("Right");
		assertEquals(new Point(10, -10), rightSide.getMin());
		assertEquals(20, rightSide.getLength());
		
		Segment bottomSide = rect.getSides().get("Bottom");
		assertEquals(new Point(-10, -10), bottomSide.getMin());
		assertEquals(20, bottomSide.getLength());
		
		Segment topSide = rect.getSides().get("Top");
		assertEquals(new Point(-10, 10), topSide.getMin());
		assertEquals(20, topSide.getLength());
	}
}
