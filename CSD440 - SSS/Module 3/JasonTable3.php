<?php
    $myName = "Jason";

    require('myFunction.php');

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 3</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <table>
            <thead>
                <th>Random 1</th>
                <th>Random 2</th>
                <th>Sum</th>
            </thead>
            <tbody>
                <?php for($i = 1; $i < 15; $i++): ?>
                    <?php $rand1 = rand(1, 200); $rand2 = rand(1, 400); ?>
                    <?php if($i % 2 == 0): ?>
                        <tr class='p-2 border border-black bg-zinc-300'>
                            <td class='border-r border-black text-center px-16'><?= $rand1 ?></td>
                            <td class='border-r border-black text-center px-16'><?= $rand2 ?></td>
                            <td class='border-r border-black text-center px-16'><?= sumOf($rand1, $rand2) ?></td>
                        </tr>
                    <?php else: ?>
                        <tr class='p-2 border border-black bg-zinc-100'>
                            <td class='border-r border-black text-center px-16'><?= $rand1 ?></td>
                            <td class='border-r border-black text-center px-16'><?= $rand2 ?></td>
                            <td class='border-r border-black text-center px-16'><?= sumOf($rand1, $rand2) ?></td>
                        </tr>
                    <?php endif ?>
                <?php endfor ?>
            </tbody>
        </table>
    </div>
</body>
</html>