package com.rectangles.chapman.model;

import java.awt.Point;

/**
 * @author Anthony Chapman
 * @since 9/24/2021
 *
 */
public class Segment {
	private Point min;
	private int length;
	
	public Segment(Point min, int length) {
		this.min = min;
		this.length = length;
	}

	public Point getMin() {
		return min;
	}

	public int getLength() {
		return length;
	}
	
	
}
