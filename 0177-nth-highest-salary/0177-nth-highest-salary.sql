CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT MAX(salary)
        FROM (
            SELECT salary,
                   DENSE_RANK() OVER(ORDER BY salary DESC) AS rk
            FROM Employee
        ) t
        WHERE rk = N
  );
END