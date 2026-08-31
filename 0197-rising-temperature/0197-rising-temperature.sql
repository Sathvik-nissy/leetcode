# Write your MySQL query statement below
select s.id as Id from Weather s inner  join Weather sc  ON s.recordDate = DATE_ADD(sc.recordDate, INTERVAL 1 DAY) where sc.temperature  < s.temperature ;