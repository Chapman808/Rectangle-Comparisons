# rectangle comparisons takehome

## Intersections:

![image](https://user-images.githubusercontent.com/16928672/134570813-2f122251-bf4c-4ba7-be55-cbe61cb774f6.png)

### Assumptions:
1. parallel segments cannot intersect
2. segments can intersect at their terminating points (vertices); 
3. duplicate intersection points (e.g. a vertex of A landing on the same point as a vertex of B, creating two 'intersections' according to our rules) will count as only one intersection

Rectangles A and B intersect at every point that side of A and the two perpendicular sides of B have in common. So A has eight opportunities for intersection:

>A_left and B_top

>A_left and B_bottom

>A_right and B_top

>A_right and B_bottom

>A_top and B_left

>A_top and B_right

>A_bottom and B_left

>A_bottom and B_right

I found that the interseciton of a pair or horizontal and vertical segments can be determined as follows:

![image](https://user-images.githubusercontent.com/16928672/134568217-3b16135b-def1-4491-a00d-37539f86558a.png)

a and b being the minimum point of each segment A and B, respectively (and a_x is the x coordinate of a). 'i' is the intersection point, if it exists.

Here, A and B do not intersect:

![image](https://user-images.githubusercontent.com/16928672/134568528-5791a4fd-fb13-4e33-b101-88ae422836fe.png)

## Containment

### Assumptions:
1. a contained rectangle can partially or fully share sides with its container
2. identical rectangles 'contain' eachother
3. a rectangle will be both contained and intersect with its container if it shares any sides 


## Adjacency

### Assumptions:
1. Adjacent rectangles cannot overlap; internal adjacency does not count, such as pictured:

![image](https://user-images.githubusercontent.com/16928672/134569226-f01e06b8-a14c-489d-9d16-ff3e45d0fb37.png)
