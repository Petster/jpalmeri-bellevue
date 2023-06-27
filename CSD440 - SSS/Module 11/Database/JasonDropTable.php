<?php

require('config.php');

try{
    $sql = "DROP TABLE baseball_01.todo";
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