# Write your MySQL query statement below
SELECT ROUND(

    (SELECT COUNT(DISTINCT s.player_id)
     FROM Activity s
     INNER JOIN (
         SELECT player_id, MIN(event_date) AS event_date
         FROM Activity
         GROUP BY player_id
     ) a
     ON s.player_id = a.player_id
     WHERE s.event_date = DATE_ADD(a.event_date, INTERVAL 1 DAY)
    )

    /(SELECT COUNT(DISTINCT s.player_id) FROM Activity s)

,2) AS fraction;