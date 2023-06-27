<?php

function checkPalindrome($string) {
    $string = strtolower(str_replace(' ', '', $string));
    if(strrev($string) == $string) {
        return "Is Palindrome";
    } else {
        return "Is Not Palindrome";
    }
}