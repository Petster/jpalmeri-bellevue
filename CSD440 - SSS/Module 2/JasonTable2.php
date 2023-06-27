<?php
    $myName = "Jason";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 2</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <table>
            <thead>
                <th>Index</th>
                <th>Random</th>
            </thead>
            <tbody>
                <?php for($i = 1; $i < 15; $i++): ?>
                    <?php if($i % 2 == 0): ?>
                        <tr class='p-2 border border-black bg-zinc-300'>
                            <td class='border-r border-black text-center px-6'><?= $i ?></td>
                            <td class='text-center px-16 font-bold p-2'><?= rand() ?></td>
                        </tr>
                    <?php else: ?>
                        <tr class='p-2 border border-black bg-zinc-400'>
                            <td class='border-r border-black text-center px-6'><?= $i ?></td>
                            <td class='text-center px-16 font-bold p-2'><?= rand() ?></td>
                        </tr>
                    <?php endif ?>
                <?php endfor ?>
            </tbody>
        </table>
    </div>
</body>
</html>