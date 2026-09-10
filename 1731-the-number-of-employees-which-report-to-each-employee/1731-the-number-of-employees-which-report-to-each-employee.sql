# Write your MySQL query statement below
select a.employee_id,a.name,count(*) as reports_count,round(avg(p.age),0) as average_age from Employees a join Employees p where a.employee_id=p.reports_to group by a.employee_id order by a.employee_id;





