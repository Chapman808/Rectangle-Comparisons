# Rectangle Comparisons

## Description

This project makes various comparisons between two rectangles: Intersections, Containment, and Adjacency. 

## Usage

Compile with maven or use the pre-compiled JAR file. Run with Java from the command line. Two random rectangles will be generated, and each property will be calculated. 
The application will print the following to the command line:

1. The left, right, top, and bottom boundaries of rectangles A and B.
2. Whether or not the rectangles A and B intersect, and a list of all intersection points if so.
3. Whether or not the rectangles are adjacent.
4. Whether or not A or B fully contains the other.

## Intersections:

![image](https://user-images.githubusercontent.com/16928672/134570813-2f122251-bf4c-4ba7-be55-cbe61cb774f6.png)

### determine whether two rectangles have one or more intersecting lines and produce a result identifying the points of intersection.

### Assumptions:
1. parallel segments cannot intersect, even if they share common points (or else adjecent sides would have infinite points of intersection).
2. segments can intersect at their terminating points (vertices); 
3. duplicate intersection points (e.g. a vertex of A landing on the same point as a vertex of B, creating two 'intersections' according to our rules) will count as only one intersection

Rectangles A and B intersect at every point that a side of A and the two perpendicular sides of B have in common. So A has eight opportunities for intersection (but can't actually have more than four in total, since duplicates don't count):

>A_left and B_top  
>A_left and B_bottom  
>A_right and B_top  
>A_right and B_bottom  
>A_top and B_left  
>A_top and B_right  
>A_bottom and B_left  
>A_bottom and B_right

I found that the intersection of a pair or horizontal and vertical segments can be determined as follows:

![image](https://user-images.githubusercontent.com/16928672/134568217-3b16135b-def1-4491-a00d-37539f86558a.png)

a and b being the minimum point (on their respective axis) of each segment A and B (and a_x is the x coordinate of a). 'i' is the intersection point, if it exists.

Here, A and B do not intersect:

![image](https://user-images.githubusercontent.com/16928672/134568528-5791a4fd-fb13-4e33-b101-88ae422836fe.png)

## Containment

### determine whether a rectangle is wholly contained within another rectangle.

### Assumptions:
1. a contained rectangle can partially or fully share sides with its container
2. identical rectangles 'contain' eachother
3. a rectangle will be both contained and intersect with its container if it shares any sides 

Determining containment is much easier than intersections. We only need to ensure that all sides of A are closer or as close to the center of B than the corresponding side of B, and vice versa. 

Rectangle A is contained in B if the following conditional is true:

> A.left >= B.left AND  
> A.right <= B.right AND  
> A.top <= B.top AND  
> A.bottom >= B.bottom

directions left, right, top, and bottom represent the positions of a rectangle's boundaries in each direction, as shown:

![image](https://user-images.githubusercontent.com/16928672/134574042-f2d13ac1-2edc-47ba-aacd-57f4bee9912d.png)

## Adjacency

### Detect whether two rectangles are adjacent. Adjacency is defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial. A sub-line share is a share where one side of rectangle A is a line that exists as a set of points wholly contained on some other side of rectangle B, where partial is one where some line segment on a side of rectangle A exists as a set of points on some side of Rectangle B.

### Assumptions:
1. Adjacent rectangles cannot overlap; internal adjacency does not count, such as pictured:

![image](https://user-images.githubusercontent.com/16928672/134574096-62e358d6-5258-4967-a375-33396116994d.png)

Within the assumptions sepecified, adjacency is fairly simple to determine. The following conditions must be met for rectangle A to be adjacent to rectangle B:

1. a directional boundary of A must be equal to the opposite directional boundary of B (e.g. A.left == B.right) AND
2. A and B's positions must overlap on the perpendicular axis to the adjacency found.
    - for rectangles adjacent on the X axis, A and B must share at least one point on the Y axis
    - for rectangles adjacent on the Y axis, A and B must share at least one point on the X axis

![image](https://user-images.githubusercontent.com/16928672/134587861-3a3a595a-bfec-4d28-9abd-473339990ffd.png)

Rectangle A is adjacent to Rectangle B if either of the following conditionals are true:

> (A.left == B.right OR  A.right == B.left) AND  
> (A.top >= B.bottom AND A.bottom <= B.top)

OR

> (A.top == B.bottom OR  A.bottom == B.top) AND  
> (A.right >= B.left AND A.left <= B.right)

In each of the above conditionals, it is determined that A and B have and equal boundary on opposite sides (e.g. A.left == B.right). Then, it is determines that A and B share some space on the perpendicular axis in which the adjacency exists.
