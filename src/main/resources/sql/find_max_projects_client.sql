SELECT client.NAME, COUNT(project.ID) AS PROJECT_COUNT
FROM client
JOIN project ON project.CLIENT_ID = client.ID
GROUP BY client.NAME
HAVING COUNT(project.ID) = (SELECT MAX(project_count)
FROM (SELECT client.NAME, COUNT(project.ID) AS project_count
FROM client JOIN project ON project.CLIENT_ID = client.ID GROUP BY client.NAME) AS temp);