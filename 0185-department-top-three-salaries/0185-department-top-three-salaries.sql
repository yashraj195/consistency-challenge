# Write your MySQL query statement below
with top_three as (select e.id as e_id,e.name as ename,e.salary,d.id as d_id,d.name as dname,
dense_rank() over(partition by d.id order by e.salary desc) as high_salary
from Employee e
join Department d
on e.departmentId= d.id
)
select dname as Department,ename as Employee, salary as Salary
from top_three
where high_salary <=3;