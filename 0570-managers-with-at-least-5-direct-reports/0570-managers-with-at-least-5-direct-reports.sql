# Write your MySQL query statement below
select  c.name from Employee c join Employee d on c.id=d.managerId   group by c.name,c.id  having count(d.managerId)>=5;