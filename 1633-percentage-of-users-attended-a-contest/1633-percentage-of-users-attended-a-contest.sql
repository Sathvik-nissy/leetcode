

select m.contest_id,round(100*(m.p/t.c),2) as percentage
from(
SELECT contest_id,COUNT(DISTINCT user_id) AS p FROM Register GROUP BY contest_id)m
cross join(select count(user_id)as c from Users)t

order by percentage desc,m.contest_id;


