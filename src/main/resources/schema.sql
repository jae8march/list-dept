DROP DATABASE IF EXISTS departments;
CREATE DATABASE departments ENCODING 'UTF8';

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS dept;

CREATE TABLE dept(
                     dept_id BIGSERIAL NOT NULL PRIMARY KEY,
                     dept_name VARCHAR(255) NOT NULL UNIQUE,
                     dept_phone_number VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE employee (
                          employee_id BIGSERIAL NOT NULL PRIMARY KEY,
                          employee_name VARCHAR(255) NOT NULL,
                          employee_birth DATE NOT NULL,
                          employee_email VARCHAR(30) NOT NULL UNIQUE,
                          employee_room BIGINT,
                          dept_id BIGSERIAL,
                          FOREIGN KEY (dept_id) REFERENCES dept(dept_id)
                              ON UPDATE CASCADE
                              ON DELETE SET NULL
);

-- -- TEST DATA, OPTIONAL

-- INSERT INTO dept VALUES (1, 'first name of department', 120123456789);
-- INSERT INTO employee VALUES (1, 'first name of employee', '01-01-2000', 'qwe@qwe.com', 202, 1);
-- INSERT INTO employee VALUES (2, 'second name of employee', '01-01-2000', 'qweqwe@qwe.com', 203, 1);

