<?php

require('config.php');

try {
    $sql = "CREATE TABLE baseball_01.todo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,title VARCHAR(255),due_date DATE,description VARCHAR(255),status BOOLEAN,priority INT)";
    if($mysqli->query($sql)) {
        $output = json_encode(array('success' => true));
        die($output);
    } else {
        $output = json_encode(array('success' => false, 'error' => $mysqli->error));
        die($output);
    }
} catch (exception $e) {
    $output = json_encode(array('success' => false, 'error' => $e->getMessage()));
    die($output);
}
