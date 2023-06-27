<?php

require_once('config.php');

try {
    $sql = "DROP DATABASE IF EXISTS baseball_01";
    if($mysqli->query($sql)) {
        $sql = "CREATE DATABASE baseball_01";
        if($mysqli->query($sql)) {
            $sql = "DROP USER IF EXISTS 'student1'@'localhost'";
            if($mysqli->query($sql)) {
                $sql = "CREATE USER 'student1'@'localhost' IDENTIFIED BY 'pass'";
                if($mysqli->query($sql)) {
                    $sql = "GRANT ALL ON *.* TO 'student1'@'localhost' WITH GRANT OPTION";
                    if($mysqli->query($sql)) {
                        $sql = "CREATE TABLE baseball_01.todo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,title VARCHAR(255),due_date DATE,description VARCHAR(255),status BOOLEAN,priority INT)";
                        if($mysqli->query($sql)) {
                            $sql = "INSERT INTO baseball_01.todo (title, due_date, description, status, priority) VALUES ('Test Todo', '2022-11-11', 'Get This Done', 0, 1)";
                            if($mysqli->query($sql)) {
                                $output = json_encode(array('success' => true));
                                die($output);
                            } else {
                                $output = json_encode(array('success' => false, 'error' => $mysqli->error));
                                die($output);
                            }
                        } else {
                            $output = json_encode(array('success' => false, 'error' => $mysqli->error));
                            die($output);
                        }
                    } else {
                        $output = json_encode(array('success' => false, 'error' => $mysqli->error));
                        die($output);
                    }
                } else {
                    $output = json_encode(array('success' => false, 'error' => $mysqli->error));
                    die($output);
                }
            } else {
                $output = json_encode(array('success' => false, 'error' => $mysqli->error));
                die($output);
            }
        } else {
            $output = json_encode(array('success' => false, 'error' => $mysqli->error));
            die($output);
        }
    } else {
        $output = json_encode(array('success' => false, 'error' => $mysqli->error));
        die($output);
    }
} catch (exception $e) {
    $output = json_encode(array('success' => false, 'error' => $e->getMessage()));
    die($output);
}