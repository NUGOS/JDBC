CREATE TABLE worker_project (
ID serial PRIMARY KEY,
WORKER_ID integer REFERENCES worker(ID),
PROJECT_ID integer REFERENCES project(ID)
);
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('John Doe', '1980-01-01', 'Trainee', 500),
('Jane Doe', '1982-02-02', 'Junior', 800),
('Jim Smith', '1983-03-03', 'Middle', 1500),
('Sarah Johnson', '1984-04-04', 'Senior', 6000),
('Tom Brown', '1985-05-05', 'Trainee', 600),
('Emily Davis', '1986-06-06', 'Junior', 700),
('Michael Wilson', '1987-07-07', 'Middle', 1700),
('Ashley Jones', '1988-08-08', 'Senior', 5000),
('Jessica Wilson', '1990-10-10', 'Junior', 900),
('David Anderson', '1989-09-09', 'Trainee', 700);

INSERT INTO client (NAME) VALUES
('Google'),
('Microsoft'),
('Apple'),
('Facebook'),
('Amazon');

INSERT INTO project (CLIENT_ID, START_DATE, END_DATE) VALUES
(1, '2022-01-01', '2022-03-01'),
(2, '2022-02-01', '2022-05-01'),
(3, '2022-03-01', '2022-06-01'),
(4, '2022-04-01', '2022-08-01'),
(1, '2022-05-01', '2022-09-01'),
(2, '2022-06-01', '2022-11-01'),
(3, '2022-07-01', '2022-12-01'),
(4, '2022-08-01', '2023-01-01'),
(1, '2022-09-01', '2023-03-01'),
(2, '2022-10-01', '2023-04-01');

INSERT INTO worker_project (WORKER_ID, PROJECT_ID) VALUES
(1,1),
(7,3),
(5,1),
(6,2),
(8,3),
(2,2),
(3,3),
(9,2),
(4,4),
(10,3),
(1,3),
(2,4),
(3,1),
(4,2),
(5,3),
(6,3),
(7,2),
(8,3),
(9,5),
(10,6),
(1,7),
(2,8),
(3,2),
(4,9),
(5,10),
(6,5),
(7,6),
(8,7),
(9,8),
(10,10);
