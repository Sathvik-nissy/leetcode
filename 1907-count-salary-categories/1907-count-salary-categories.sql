# Write your MySQL query statement below
#select sum(income<20000) as LowSalary ,sum(income between 20000 and 50000) as AverageSalary,sum(income >50000) as HighSalary from Accounts;


SELECT 'Low Salary' AS category,
       SUM(income < 20000) AS accounts_count
FROM Accounts

UNION ALL

SELECT 'Average Salary',
       SUM(income BETWEEN 20000 AND 50000)
FROM Accounts

UNION ALL

SELECT 'High Salary',
       SUM(income > 50000)
FROM Accounts;