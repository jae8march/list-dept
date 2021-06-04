DROP DATABASE IF EXISTS departments;
CREATE DATABASE departments ENCODING 'UTF8';

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS dept;

CREATE TABLE dept(
                     dept_name VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
                     dept_phone_number VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE employee (
                          employee_name VARCHAR(255) NOT NULL,
                          employee_birth DATE NOT NULL,
                          employee_email VARCHAR(30) NOT NULL UNIQUE PRIMARY KEY,
                          employee_room BIGINT,
                          dept_name VARCHAR(255),
                          FOREIGN KEY (dept_name) REFERENCES dept(dept_name)
                              ON UPDATE CASCADE
                              ON DELETE SET NULL
);

-- -- TEST DATA, OPTIONAL

-- INSERT INTO dept VALUES ('first name of department', 120123456789);
-- INSERT INTO employee VALUES ('first name of employee', '01-01-2000', 'qwe@qwe.com', 202, 'first name of department');
-- INSERT INTO employee VALUES ('second name of employee', '01-01-2000', 'qweqwe@qwe.com', 203, 'first name of department');

