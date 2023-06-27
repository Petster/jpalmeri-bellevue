<?php

class JasonMyInteger {
    public $myInt;

    function __construct($initital) {
        $this->myInt = $initital;
    }

    function isEven() {
        $check = $this->myInt % 2 == 0;
        if($check) {
            return "True";
        } else {
            return "False";
        }
    }

    function isOdd() {
        $check = $this->myInt % 2 == 1;
        if($check) {
            return "True";
        } else {
            return "False";
        }
    }

    function isPrime() {
        if ($this->myInt == 1) {
            return "False";
        }

        for ($i = 2; $i <= sqrt($this->myInt); $i++){
            if ($this->myInt % $i == 0) {
                return "False";
            }
        }
        return "True";
    }

    function setMyInt($newInt) {
        $this->myInt = $newInt;
    }

    function getMyInt() {
        return $this->myInt;
    }
}

$TestOne = new JasonMyInteger(12);
$TestTwo = new JasonMyInteger(17);

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 6</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center gap-4'>
        <table>
            <thead>
                <th>Value</th>
                <th>Test One</th>
                <th>Test Two</th>
            </thead>
            <tbody>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>Integer</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->getMyInt() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->getMyInt() ?></td>
                </tr>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>isEven</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->isEven() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->isEven() ?></td>
                </tr>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>isOdd</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->isOdd() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->isOdd() ?></td>
                </tr>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>isPrime</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->isPrime() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->isPrime() ?></td>
                </tr>
                <?php $TestOne->setMyInt(46); $TestTwo->setMyInt(71); ?>
                <tr class='p-2 border border-black bg-zinc-300 border-t-4'>
                    <td class='border-r border-black text-center px-16'>Setter</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->getMyInt() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->getMyInt() ?></td>
                </tr>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>isEven</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->isEven() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->isEven() ?></td>
                </tr>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>isOdd</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->isOdd() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->isOdd() ?></td>
                </tr>
                <tr class='p-2 border border-black bg-zinc-300'>
                    <td class='border-r border-black text-center px-16'>isPrime</td>
                    <td class='border-r border-black text-center px-16'><?= $TestOne->isPrime() ?></td>
                    <td class='border-r border-black text-center px-16'><?= $TestTwo->isPrime() ?></td>
                </tr>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</body>
</html>