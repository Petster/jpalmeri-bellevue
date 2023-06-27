DROP DATABASE IF EXISTS baseball_01;
CREATE DATABASE baseball_01;
DROP USER IF EXISTS 'student1'@'localhost';
CREATE USER 'student1'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL ON *.* TO 'student1'@'localhost' WITH GRANT OPTION;
USE baseball_01;

CREATE TABLE todo (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    due_date DATE,
    description VARCHAR(255),
    status BOOLEAN,
    priority INT
);

INSERT INTO todo (title, due_date, description, status, priority) VALUES ('Test Todo', '2022-11-11', 'Get This Done', 0, 1);
