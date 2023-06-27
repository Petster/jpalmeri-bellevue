<?php

require('config.php');

$todo = mysqli_query($mysqli, 'SELECT * FROM baseball_01.todo');

if(!empty($todo)) {
    while($row = mysqli_fetch_array($todo)) {
        $rows[] = $row;
    }
} else {
    $rows = [];
}

$mysqli->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 8</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <table>
            <thead>
                <th>id</th>
                <th>title</th>
                <th>due_date</th>
                <th>description</th>
                <th>status</th>
                <th>priority</th>
            </thead>
            <tbody>
                <?php foreach($rows as $items): ?>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'><?= $items['id'] ?></td>
                        <td class='border-r border-black text-center px-16'><?= $items['title'] ?></td>
                        <td class='border-r border-black text-center px-16'><?= $items['due_date'] ?></td>
                        <td class='border-r border-black text-center px-16'><?= $items['description'] ?></td>
                        <td class='border-r border-black text-center px-16'><?= $items['status'] ?></td>
                        <td class='border-r border-black text-center px-16'><?= $items['priority'] ?></td>
                    </tr>
                <?php endforeach ?>
            </tbody>
        </table>
    </div>
</body>
</html>