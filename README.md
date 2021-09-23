# rectangle comparisons takehome

## Intersections:

![image](https://user-images.githubusercontent.com/16928672/134570813-2f122251-bf4c-4ba7-be55-cbe61cb774f6.png)

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

### Assumptions:
1. a contained rectangle can partially or fully share sides with its container
2. identical rectangles 'contain' eachother
3. a rectangle will be both contained and intersect with its container if it shares any sides 

Determining adjacency is much easier than intersections. We only need to ensure that all sides of A are closer or as close to the center of B than the corresponding side of B, and vice versa. 
Rectangle A is contained in B if the following conditional is true:

> A.left >= B.right AND  
> A.right <= B.right AND  
> A.top <= B.top AND  
> A.bottom >= B.bottom

directions left, right, top, and bottom represent the positions of a rectangle's boundaries in each direction, as shown:

![image](https://user-images.githubusercontent.com/16928672/134574042-f2d13ac1-2edc-47ba-aacd-57f4bee9912d.png)

## Adjacency

### Assumptions:
1. Adjacent rectangles cannot overlap; internal adjacency does not count, such as pictured:

![image](https://user-images.githubusercontent.com/16928672/134574096-62e358d6-5258-4967-a375-33396116994d.png)

