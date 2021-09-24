package com.rectangles.chapman.main;

import java.util.Random;

import com.rectangles.chapman.model.Rectangle;
import com.rectangles.chapman.utility.RectangleComparisons;

public class Application {

public static void main(String[] args) {
		
		Rectangle a = getRandomRectangle(5);
		Rectangle b = getRandomRectangle(5);

		System.out.println("\nRectangle Comparisons:\n\n");
		System.out.printf("Rectangle A: %s\n", a);
		System.out.printf("Rectangle B: %s\n\n", b);

		System.out.printf("Intersections: %s\n", RectangleComparisons.getIntersection(a, b));
		System.out.printf("Containment: %s\n", RectangleComparisons.getContainment(a, b));
		System.out.printf("Adjacencies: %s", RectangleComparisons.getAdjacency(a, b));

	}

	
	/**
	 * creates a randomly generated rectangle of a size between 0 and range.
	 * @param range
	 * @return
	 */
	private static Rectangle getRandomRectangle(int range) {
		Random rm = new Random();
		int left = rm.nextInt(range);
		int right = left + rm.nextInt(range);
		int bottom = rm.nextInt(range);
		int top = bottom + rm.nextInt(range);
		
		return new Rectangle(left, right, bottom, top);
	}

}
