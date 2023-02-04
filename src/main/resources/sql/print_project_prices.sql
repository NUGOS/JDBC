SELECT 'Project ' || project.id AS NAME,
       sum(worker.salary) * extract(month from age(end_date, start_date)) AS PRICE
FROM project
         JOIN worker_project ON project.id = worker_project.project_id
         JOIN worker ON worker.id = worker_project.worker_id
GROUP BY project.id
ORDER BY PRICE DESC;