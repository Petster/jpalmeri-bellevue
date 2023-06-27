<?php

require('myFunction.php');

if(isset($_SERVER['HTTP_X_REQUESTED_WITH']) && $_SERVER['HTTP_X_REQUESTED_WITH'] == "XMLHttpRequest") {

    $string = $_POST['palin_in'];

    if(checkPalindrome($string) === "Is Palindrome") {
        $output = json_encode(array('success' => true));
    } else {
        $output = json_encode(array('success' => false));
    }
    die($output);
} else {
    echo '<script>alert("Not requested through proper channels.");</script>';
}