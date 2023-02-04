CREATE TABLE worker (
  ID serial PRIMARY KEY,
  NAME varchar(1000) NOT NULL CHECK (length(NAME) >= 2),
  BIRTHDAY date NOT NULL CHECK (date_part('year', BIRTHDAY) > 1900),
  LEVEL varchar(7) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
  SALARY integer NOT NULL CHECK (SALARY >= 100 AND SALARY <= 100000)
);

CREATE TABLE client (
  ID serial PRIMARY KEY,
  NAME varchar(1000) NOT NULL CHECK (length(NAME) >= 2)
);

CREATE TABLE project (
  ID serial PRIMARY KEY,
  CLIENT_ID integer REFERENCES client(ID),
  START_DATE date NOT NULL,
  END_DATE date NOT NULL CHECK (END_DATE >= START_DATE)
);
