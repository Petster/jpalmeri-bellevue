<?php
    $myName = "Jason";

    require('myFunction.php');

    $myCustomers = array();

    for($i = 0; $i < 10; $i++) {
        $name = randomName();
        $name = explode(" ", $name);
        array_push($myCustomers, array(
                "fname"=>$name[0],
                "lname"=>$name[1],
                "age"=>rand(10,30),
                "phone"=>rand(100,999) . "-" . rand(100,999) . "-" . rand(1000,9999)
            )
        );
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 5</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center gap-4'>
        <div>
            <h1 class='text-center text-2xl underline font-bold'>Original Array</h1>
            <table>
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Phone Number</th>
                </thead>
                <tbody>
                    <?php $age10 = array_keys(array_column($myCustomers, 'age'), 10); ?>
                    <?php $age20 = array_keys(array_column($myCustomers, 'age'), 20); ?>
                    <?php $age30 = array_keys(array_column($myCustomers, 'age'), 30); ?>
                    <?php foreach($myCustomers as $key => $val): ?>
                        <tr class='p-2 border border-black bg-zinc-300'>
                            <td class='border-r border-black text-center px-16'><?= $val['fname'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['lname'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['age'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['phone'] ?></td>
                        </tr>
                    <?php endforeach ?>
                </tbody>
            </table>
        </div>
        <div class='flex flex-row gap-4'>
            <div class='flex flex-col'>
                <p class='text-xl text-center font-bold underline'>People age 10:</p>
                <?php if(!empty($age10)): ?>
                    <?php foreach($age10 as $key => $val): ?>
                        <p class='text-center'><?= $myCustomers[$val]['fname'] . " " . $myCustomers[$val]['lname'] ?></p>
                    <?php endforeach ?>
                <?php else: ?>
                    <p class='text-center'>No one is aged 10.</p>
                <?php endif ?>
            </div>
            <div class='flex flex-col'>
                <p class='text-xl text-center font-bold underline'>People age 20:</p>
                <?php if(!empty($age20)): ?>
                    <?php foreach($age20 as $key => $val): ?>
                        <p class='text-center'><?= $myCustomers[$val]['fname'] . " " . $myCustomers[$val]['lname'] ?></p>
                    <?php endforeach ?>
                <?php else: ?>
                    <p class='text-center'>No one is aged 20.</p>
                <?php endif ?>
            </div>
            <div class='flex flex-col'>
                <p class='text-xl text-center font-bold underline'>People age 30:</p>
                <?php if(!empty($age30)): ?>
                    <?php foreach($age30 as $key => $val): ?>
                        <p class='text-center'><?= $myCustomers[$val]['fname'] . " " . $myCustomers[$val]['lname'] ?></p>
                    <?php endforeach ?>
                <?php else: ?>
                    <p class='text-center'>No one is aged 30.</p>
                <?php endif ?>
            </div>
        </div>
        <div>
            <h1 class='text-center text-2xl underline font-bold'>Sort by Firstname Ascending</h1>
            <table>
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Phone Number</th>
                </thead>
                <tbody>
                    <?php
                        $columns = array_column($myCustomers, 'fname');
                        array_multisort($columns, SORT_ASC, $myCustomers);
                    ?>
                    <?php foreach($myCustomers as $key => $val): ?>
                        <tr class='p-2 border border-black bg-zinc-300'>
                            <td class='border-r border-black text-center px-16'><?= $val['fname'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['lname'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['age'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['phone'] ?></td>
                        </tr>
                    <?php endforeach ?>
                </tbody>
            </table>
        </div>
        <div>
            <h1 class='text-center text-2xl underline font-bold'>Sort by Age Descending</h1>
            <table>
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Phone Number</th>
                </thead>
                <tbody>
                    <?php
                        $columns = array_column($myCustomers, 'age');
                        array_multisort($columns, SORT_DESC, $myCustomers);
                    ?>
                    <?php foreach($myCustomers as $key => $val): ?>
                        <tr class='p-2 border border-black bg-zinc-300'>
                            <td class='border-r border-black text-center px-16'><?= $val['fname'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['lname'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['age'] ?></td>
                            <td class='border-r border-black text-center px-16'><?= $val['phone'] ?></td>
                        </tr>
                    <?php endforeach ?>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</body>
</html>