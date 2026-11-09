# Write your MySQL query statement below
with improved_score as(select student_id, subject,
first_value(score) over(partition by student_id,subject order by exam_date) as first_score, 
last_value(score) over(partition by student_id,subject order by exam_date rows between unbounded preceding and unbounded following) as latest_score
from Scores)
select distinct * from improved_score
where latest_score > first_score
order by student_id,subject;
