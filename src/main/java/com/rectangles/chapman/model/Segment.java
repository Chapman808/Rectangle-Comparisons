package com.rectangles.chapman.model;

import java.awt.Point;

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
