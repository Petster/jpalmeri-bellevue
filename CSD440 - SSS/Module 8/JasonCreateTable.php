<?php

require('config.php');

$sql = "DROP DATABASE IF EXISTS baseball_01";
if($mysqli->query($sql)) {
    echo 'Baseball_01 database dropped.' . '<br/>';
    $sql = "CREATE DATABASE baseball_01";
    if($mysqli->query($sql)) {
        echo 'Baseball_01 database created.' . '<br/>';
        $sql = "DROP USER IF EXISTS 'student1'@'localhost'";
        if($mysqli->query($sql)) {
            echo 'student1 user removed.' . '<br/>';
            $sql = "CREATE USER 'student1'@'localhost' IDENTIFIED BY 'pass'";
            if($mysqli->query($sql)) {
                echo 'student1 user created.' . '<br/>';
                $sql = "GRANT ALL ON *.* TO 'student1'@'localhost' WITH GRANT OPTION";
                if($mysqli->query($sql)) {
                    echo 'student1 permission granted.' . '<br/>';
                    $sql = "CREATE TABLE baseball_01.todo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,title VARCHAR(255),due_date DATE,description VARCHAR(255),status BOOLEAN,priority INT)";
                    if($mysqli->query($sql)) {
                        echo 'todo table created.' . '<br/>';
                        $sql = "CREATE TABLE todo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,title VARCHAR(255),due_date DATE,description VARCHAR(255),status BOOLEAN,priority INT)";
                        $mysqli->close();
                    } else {
                        echo "Error: " . $mysqli->error;
                    }
                } else {
                    echo "Error: " . $mysqli->error;
                }
            } else {
                echo "Error: " . $mysqli->error;
            }
        } else {
            echo "Error: " . $mysqli->error;
        }
    } else {
        echo "Error: " . $mysqli->error;
    }
} else {
    echo "Error: " . $mysqli->error;
}

