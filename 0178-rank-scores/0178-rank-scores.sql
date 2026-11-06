# Write your MySQL query statement below
with ranked_scores as (select score,
dense_rank() over(order by score desc) as 'rank'
from Scores)
select * from ranked_scores;