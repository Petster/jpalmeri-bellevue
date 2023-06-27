<?php

require('config.php');

$sql = "DROP TABLE IF EXISTS baseball_01.todo";
if($mysqli->query($sql)) {
    echo 'todo table dropped' . '<br/>';
    $mysqli->close();
} else {
    echo "Error: " . $mysqli->error;
}