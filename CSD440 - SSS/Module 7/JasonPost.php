<?php

$errors = array();

if(!empty($_POST)) {
  $inputFields = array(
        "fname" => $_POST['fname'],
        "lname" => $_POST['lname'],
        "dob" => $_POST['dob'],
        "username" => $_POST['username'],
        "email" => $_POST['email'],
        "password" => $_POST['password'],
        "confirm_password" => $_POST['confirm_password'],
    );

    foreach($inputFields as $key => $val) {
        if(empty($val)) {
            array_push($errors, "Error: " . $key . " field was empty");
        }
    }

    if(!empty($inputFields['password']) && !empty($inputFields['confirm_password'])) {
        if($inputFields['password'] !== $inputFields['confirm_password']) {
            array_push($errors, "Error: Password's do not Match!");
        }
    }
} else {
    $inputFields = array();
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 7 - Results</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <a href="./JasonForm.php" class='p-4 absolute hover:underline font-bold text-lg'>Back to Form</a>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <?php if(!empty($inputFields)): ?>
            <table>
                <thead>
                    <th>Field</th>
                    <th>Raw Input</th>
                </thead>
                <tbody>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>First Name</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['fname'])) ? $inputFields['fname'] : "<span class='text-red-500 font-bold'> First Name was Empty</span>" ?></td>
                    </tr>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>Last Name</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['lname'])) ? $inputFields['lname'] : "<span class='text-red-500 font-bold'> Last Name was Empty</span>" ?></td>
                    </tr>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>Date of Birth</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['dob'])) ? $inputFields['dob'] : "<span class='text-red-500 font-bold'> Date of Birth was Empty</span>" ?></td>
                    </tr>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>Username</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['username'])) ? $inputFields['username'] : "<span class='text-red-500 font-bold'> Username was Empty</span>" ?></td>
                    </tr>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>Email</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['email'])) ? $inputFields['email'] : "<span class='text-red-500 font-bold'> Email was Empty</span>" ?></td>
                    </tr>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>Password</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['password'])) ? $inputFields['password'] : "<span class='text-red-500 font-bold'> Password was Empty</span>" ?></td>
                    </tr>
                    <tr class='p-2 border border-black bg-zinc-300'>
                        <td class='border-r border-black text-center px-16'>Confirm Password</td>
                        <td class='border-r border-black text-center px-16'><?= (!empty($inputFields['confirm_password'])) ? $inputFields['confirm_password'] : "<span class='text-red-500 font-bold'> Confirm Password was Empty</span>" ?></td>
                    </tr>
                </tbody>
            </table>
            <?php if(!empty($errors)): ?>
                <?php foreach($errors as $val): ?>
                    <p class='text-red-500 font-bold text-lg'><?= $val ?></p>
                <?php endforeach ?>
            <?php else: ?>
                <p class='text-green-500 font-bold text-lg'>There were no Errors in your submission!</p>
            <?php endif ?>
        <?php else: ?>
            <h1 class='text-xl font-bold text-red-500'>The Post Request Was Empty.</h1>
        <?php endif ?>
    </div>
</body>
</html>