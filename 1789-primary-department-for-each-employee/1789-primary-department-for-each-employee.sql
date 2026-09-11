# Write your MySQL query statement below
select employee_id,department_id  from Employee where primary_flag='Y' OR  employee_id in (select employee_id from Employee group by employee_id having (count(department_id)=1));

# Write your MySQL query statement below



/*SELECT
    employee_id,
    department_id
FROM Employee e
GROUP BY employee_id
HAVING COUNT(employee_id) = 1 
UNION ALL
SELECT
    employee_id,
    department_id
FROM Employee e
WHERE primary_flag = 'Y'*/