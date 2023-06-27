<?php
    $myName = "Jason";

    $myPalindromes = ['racecar', 'moon', 'noon', 'stats', 'taco cat', 'christmas', 'mom', 'I did, did I', 'Was it a cat I saw', 'my gym', 'no lemon, no melon', 'thomas', 'jason', ];

    require('myFunction.php');
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 4</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <table>
            <thead>
                <th>Word</th>
                <th>Palindrome?</th>
            </thead>
            <tbody>
                <?php foreach($myPalindromes as $key => $val): ?>
                    <?php if(checkPalindrome($val) === "Is Not Palindrome"): ?>
                        <tr class='p-2 border border-black bg-red-300'>
                            <td class='border-r border-black text-center px-16'><?= $val ?></td>
                            <td class='border-r border-black text-center px-16'><?= checkPalindrome($val) ?></td>
                        </tr>
                    <?php else: ?>
                        <tr class='p-2 border border-black bg-zinc-300'>
                            <td class='border-r border-black text-center px-16'><?= $val ?></td>
                            <td class='border-r border-black text-center px-16'><?= checkPalindrome($val) ?></td>
                        </tr>
                    <?php endif ?>
                <?php endforeach ?>
            </tbody>
        </table>
        <div class='mt-6 flex'>
            <div class='flex flex-col gap-2'>
                <label class='text-center underline text-xl font-bold py-2'>Check if Palindrome</label>
                <input id='palin_in' name='palin_in' type="text" class='p-2 bg-white rounded-md' />
                <button id='sub_btn' type='button' class='px-4 bg-green-400 hover:bg-green-500 text-white text-xl font-bold rounded-md'>Check</button>
                <p class="text-red-500 text-center" id="result"></p>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script>
        let btn = document.getElementById('sub_btn');
        let result = document.getElementById('result');

        btn.addEventListener('click', function() {
            $.ajax({
                type: "POST",
                url: "checkPalindrome.php",
                data: $('#palin_in').serialize(),
                dataType: "json"
            }).done(
                function(data) {
                    if(data.success) {
                        result.innerHTML = "Is Palindrome";
                    } else {
                        result.innerHTML = "Is Not Palindrome";
                    }
                }
            );
        })
    </script>
</body>
</html>