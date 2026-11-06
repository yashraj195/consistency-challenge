# Write your MySQL query statement below
with avg_years as (select p.project_id,
sum(e.experience_years) over(partition by p.project_id) as avrg_years,
count(e.employee_id) over(partition by p.project_id) as no_of_employee
from project p
join employee e
on p.employee_id= e.employee_id)
select project_id,
ROUND(avrg_years * 1.0 / no_of_employee, 2) AS average_years
from avg_years
group by project_id;