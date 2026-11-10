# Write your MySQL query statement below
with cte as(select player_id,
min(event_date) over(partition by player_id order by event_date) as first_login
from Activity)
select * from cte
group by player_id;