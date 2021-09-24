package com.rectangles.chapman.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Rectangle {
	
	//directional boundaries of the rectangle e.g. how far in a certain direction a rectangle reaches	
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	private Map<String, Segment> sides;
	
	public Rectangle(int left, int right, int bottom, int top) {
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		this.sides = calculateSideSegments();
	}

	/**
	 * using the directional boundaries of the rectangle, assigns a line segment representing each side of the rectangle. 
	 * This is used in the calculation of intersections between rectangles.
	 */
	private Map<String, Segment> calculateSideSegments() {
		Map<String, Segment> sides = new HashMap<>();
		
		int height = this.top - this.bottom;
		int width = this.right - this.left;

		Point leftSideMinPoint = new Point(this.left, this.bottom);
		Point rightSideMinPoint = new Point(this.right, this.bottom);
		Point bottomSideMinPoint = new Point(this.left, this.bottom);
		Point topSideMinPoint = new Point(this.left, this.top);

		sides.put("Left", new Segment(leftSideMinPoint, height));
		sides.put("Right", new Segment(rightSideMinPoint, height));
		sides.put("Bottom", new Segment(bottomSideMinPoint, width));
		sides.put("Top", new Segment(topSideMinPoint, width));

		return sides;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public int getTop() {
		return top;
	}

	public int getBottom() {
		return bottom;
	}

	public Map<String, Segment> getSides() {
		return sides;
	}
	
	
	
}
