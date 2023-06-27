<?php

require('config.php');

$sql = "INSERT INTO baseball_01.todo (title, due_date, description, status, priority) VALUES ('Test Todo', '2022-11-11', 'Get This Done', 0, 1)";
if($mysqli->query($sql)) {
    echo 'Inserted Data into todo table' . '<br/>';
    $mysqli->close();
} else {
    echo "Error: " . $mysqli->error;
}