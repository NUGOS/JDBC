SELECT 'Project ' || project.id as NAME, extract(month from age(end_date, start_date)) as MONTH_COUNT
FROM project
WHERE extract(month from age(end_date, start_date)) = (SELECT max(extract(month from age(end_date, start_date)))
FROM project);