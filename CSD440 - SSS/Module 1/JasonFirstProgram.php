<?php
    $myName = "Jason";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 1</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <h1 class='text-9xl'>Hello.</h1>
        <p class='text-2xl'>My Name is <span class='text-purple-500'><?= $myName ?></span></p>
    </div>
</body>
</html>