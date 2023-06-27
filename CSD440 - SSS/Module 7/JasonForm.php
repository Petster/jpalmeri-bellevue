<?php
    $myName = "Jason";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 7</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-red-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <form novalidate action="JasonPost.php" method="POST" class='flex flex-col gap-3 rounded-md p-4 backdrop-filter backdrop-blur-md bg-black bg-opacity-40' >
            <div class='flex flex-row gap-4'>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>First Name</label>
                    <input class='p-2 rounded-md' type='text' name='fname' id='fname'/>
                </div>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>Last Name</label>
                    <input class='p-2 rounded-md' type='text' name='lname' id='lname'/>
                </div>
            </div>
            <div>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>Date of Birth</label>
                    <input class='p-2 rounded-md' type='date' name='dob' id='dob'/>
                </div>
            </div>
            <div>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>Username</label>
                    <input class='p-2 rounded-md' type='text' name='username' id='username'/>
                </div>
            </div>
            <div>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>Email</label>
                    <input class='p-2 rounded-md' type='email' name='email' id='email'/>
                </div>
            </div>
            <div>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>Password</label>
                    <input class='p-2 rounded-md' type='password' name='password' id='password'/>
                </div>
            </div>
            <div>
                <div class='flex flex-col'>
                    <label class='text-center font-bold'>Confirm Password</label>
                    <input class='p-2 rounded-md' type='password' name='confirm_password' id='confirm_password'/>
                </div>
            </div>
            <div class='flex flex-row gap-2'>
                <div class='flex flex-col flex-grow'>
                    <button type='submit' class='px-6 bg-green-400 hover:bg-green-500 text-white font-bold rounded-md py-2'>Submit</button>
                </div>
                <div class='flex flex-col flex-grow'>
                    <button type='reset' class='px-6 bg-red-400 hover:bg-red-500 text-white font-bold rounded-md py-2'>Reset</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>