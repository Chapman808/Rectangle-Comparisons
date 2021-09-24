package com.rectangles.chapman.utility;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.rectangles.chapman.model.Rectangle;
import com.rectangles.chapman.model.Segment;

/**
 * @author Anthony Chapman
 * @since 9/24/2021
 *
 */
public class RectangleComparisons {


	/**
	 * determines whether two rectangles have one or more intersecting lines, and produces a result 
	 * identifying the points of intersection. Returns an Empty set for no intersections
	 * @param a
	 * @param b
	 * @return
	 */
	public static Set<Point> getIntersection (Rectangle a, Rectangle b) {
		List<Point> intersections = new ArrayList<>();

		intersections.add(getSegmentIntersection(a.getSides().get("Left"), b.getSides().get("Bottom")));
		intersections.add(getSegmentIntersection(a.getSides().get("Left"), b.getSides().get("Top")));
		intersections.add(getSegmentIntersection(a.getSides().get("Right"), b.getSides().get("Bottom")));
		intersections.add(getSegmentIntersection(a.getSides().get("Right"), b.getSides().get("Top")));
		
		intersections.add(getSegmentIntersection(b.getSides().get("Left"), a.getSides().get("Bottom")));
		intersections.add(getSegmentIntersection(b.getSides().get("Left"), a.getSides().get("Top")));
		intersections.add(getSegmentIntersection(b.getSides().get("Right"), a.getSides().get("Bottom")));
		intersections.add(getSegmentIntersection(b.getSides().get("Right"), a.getSides().get("Top")));
		
		Set<Point> deduplicatedIntersections = intersections.stream()
				.filter(intersection -> intersection != null)
				.collect(Collectors.toSet());
		return deduplicatedIntersections;
	}
	

	/**
	 * returns the intersection point of two Segments, if it exists. returns Null otherwise
	 * @param vertical
	 * @param horizontal
	 * @return
	 */
	public static Point getSegmentIntersection(Segment vertical, Segment horizontal) {
		Point v_min = vertical.getMin();
		Point h_min = horizontal.getMin();
		
		if (
				v_min.y <= h_min.y && h_min.y <= (v_min.y + vertical.getLength()) &&
				h_min.x <= v_min.x && v_min.x <= (h_min.x + horizontal.getLength())
		) return new Point(v_min.x, h_min.y);
		return null;
	}


	/**
	 * determines whether a rectangle is wholly contained within another rectangle.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean getContainment (Rectangle a, Rectangle b) {
		//check if both left-right range and top-bottom range of A is within the respective ranges of B
		if (
			a.getLeft()	>=	b.getLeft()		&&
			a.getRight() <=	b.getRight()	&&
			a.getTop() <=	b.getTop()		&&
			a.getBottom() >= b.getBottom()
		) return true;
		//check if both left-right range and top-bottom range of B is within the respective ranges of A
		else if (
			b.getLeft()	>= a.getLeft()		&&
			b.getRight() <=	a.getRight()	&&
			b.getTop() <= a.getTop()		&&
			b.getBottom() >= a.getBottom()
		) return true;
		else return false;
	}
	

	/**
	 * detects whether two rectangles are adjacent. Adjacency is
	 * defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial.
	 * A sub-line share is a share where one side of rectangle A is a line that exists as a set of points
	 * wholly contained on some other side of rectangle B, where partial is one where some line segment on a
	 * side of rectangle A exists as a set of points on some side of Rectangle B.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean getAdjacency (Rectangle a, Rectangle b) {
		if (
			(a.getLeft() == b.getRight() || a.getRight() == b.getLeft()) &&
			(a.getBottom() <= b.getTop() && a.getTop() >= b.getBottom())
		) return true;
		else if (
			(a.getTop() == 	b.getBottom() || a.getBottom() == b.getTop()) &&
			(a.getLeft() <=	b.getTop() && a.getRight() >= b.getBottom())
		) return true;
		return false;
	}
}
