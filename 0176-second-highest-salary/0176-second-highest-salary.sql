# Write your MySQL query statement below
with ranked_salaries as (select id,salary,
dense_rank() over(order by salary desc) as ranks
from Employee)
select 
max(CASE
    WHEN ranks=2 THEN salary
    ELSE null
END) AS SecondHighestSalary
from ranked_salaries;