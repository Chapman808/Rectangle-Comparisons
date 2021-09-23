# rectangles-takehome

## Intersections:


![image](https://user-images.githubusercontent.com/16928672/134567052-6a20fb07-a5e5-43fa-834f-4bc0ce7614d2.png)

### Assumptions:
1. parallel segments cannot intersect
2. all segments are perpendicular or parallel
3. segments can intersect at their terminating points

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

