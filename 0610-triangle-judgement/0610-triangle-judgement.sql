# Write your MySQL query statement below
select x,y,z,CASE
 when  (x<z+y)and (y<z+x) and(z<x+y) 
 THEN 'Yes'
 ELSE 'No'
END as triangle
  from Triangle ;
