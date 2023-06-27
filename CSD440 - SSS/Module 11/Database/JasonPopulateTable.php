<?php

require('config.php');

$sql = "INSERT INTO baseball_01.todo (title, due_date, description, status, priority) VALUES ('Test Todo', '2022-11-11', 'Get This Done', 0, 1)";
try {
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