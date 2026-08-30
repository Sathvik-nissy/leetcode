# Write your MySQL query statement below
select  Visits.customer_id,count(*)  as count_no_trans   
from Visits  left join Transactions on Visits.visit_id=Transactions.visit_id 
where Transactions.transaction_id is null  
group by Visits.customer_id 
order by count_no_trans ;

-- SELECT customer_id,COUNT(visit_id) AS count_no_trans
-- FROM Visits 
-- WHERE visit_id NOT IN(
--     SELECT DISTINCT visit_id
--     FROM Transactions
-- )
-- GROUP BY customer_id;
