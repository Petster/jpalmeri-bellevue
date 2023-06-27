<?php
    $data;

    if (isset($_GET['clearData'])) {
        $data = null;
        header('location: JasonJSON.php');
    }

    if($_SERVER["REQUEST_METHOD"] == "POST") {
        if ( isset( $_POST[ 'submitForm' ] ) ) {
            $counter = 0;

            $inputData = array(
                "fname" => $_POST['fname'],
                "lname" => $_POST['lname'],
                "company" => $_POST['company'],
                "email" => $_POST['email'],
                "phone" => $_POST['phone'],
                "street" => $_POST['street'],
                "city" => $_POST['city'],
                "state" => $_POST['state'],
                "zipcode" => $_POST['zipcode'],
            );

            foreach($inputData as $key => $val) {
                if($val == "") {
                    $val = "Error: ".$key." was Empty on Submission";
                    $inputData[$key] = $val;
                    $counter++;
                }
            }

            if($counter === 0) {
                $data = json_encode(array('data' => $inputData));
            } else {
                $data = json_encode(array('data' => $inputData, 'error' => true));
            }
        }
    }

    if(!empty($data)) {
        $data = json_decode($data, true);
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 10</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-orange-100 mx-auto flex flex-col min-h-screen sm:break-words md:break-normal'>
    <div class='w-2/3 mx-auto flex flex-col gap-4 flex-grow content-center items-center justify-center'>
        <?php if(!empty($data)): ?>
            <div class='w-2/3 flex flex-col gap-3 rounded-md p-4 backdrop-filter backdrop-blur-md bg-black bg-opacity-40 text-white'>
                <p><strong>Full Name:</strong><br/> <?= $data['data']['fname']." ".$data['data']['lname'] ?></p>
                <p><strong>Company:</strong><br/> <?= $data['data']['company'] ?></p>
                <p><strong>Email:</strong><br/> <?= $data['data']['email'] ?></p>
                <p><strong>Phone #:</strong><br/> <?= $data['data']['phone'] ?></p>
                <p><strong>Address:</strong><br/> <?= $data['data']['street'] . "<br/>" . $data['data']['city'] . ", " . $data['data']['state'] . " " . $data['data']['zipcode'] ?></p>
                <a href='JasonJSON.php?clearData=true' class='w-full bg-blue-400 hover:bg-blue-500 text-white font-bold rounded-md px-6 py-2'>Clear Data</a>
            </div>
            <?php if(isset($data['error'])): ?>
                <p class='text-2xl font-bold text-red-500'>There was an error in your submission!</p>
            <?php endif ?>
        <?php else: ?>
            <form novalidate action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST" class='flex flex-col gap-3 rounded-md p-4 backdrop-filter backdrop-blur-md bg-black bg-opacity-40' >
                <div class='flex flex-row gap-4'>
                    <div class='flex flex-col'>
                        <label class='font-bold'>First Name</label>
                        <input class='p-2 rounded-md' type='text' name='fname' id='fname'/>
                    </div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>Last Name</label>
                        <input class='p-2 rounded-md' type='text' name='lname' id='lname'/>
                    </div>
                </div>
                <div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>Company</label>
                        <input class='p-2 rounded-md' type='text' name='company' id='company'/>
                    </div>
                </div>
                <div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>Email</label>
                        <input class='p-2 rounded-md' type='email' name='email' id='email'/>
                    </div>
                </div>
                <div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>Phone Number</label>
                        <input class='p-2 rounded-md' type='tel' name='phone' id='phone' pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"/>
                    </div>
                </div>
                <div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>Street Address</label>
                        <input class='p-2 rounded-md' type='text' name='street' id='street'/>
                    </div>
                </div>
                <div class='flex flex-row gap-4'>
                    <div class='flex flex-col'>
                        <label class='font-bold'>City</label>
                        <input class='p-2 rounded-md' type='text' name='city' id='city'/>
                    </div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>State / Providence</label>
                        <input class='p-2 rounded-md' type='text' name='state' id='state'/>
                    </div>
                </div>
                <div>
                    <div class='flex flex-col'>
                        <label class='font-bold'>Postal /Zip Code</label>
                        <input class='p-2 rounded-md' type='text' name='zipcode' id='zipcode'/>
                    </div>
                </div>
                <div class='flex flex-row gap-2'>
                    <div class='flex flex-col flex-grow'>
                        <button name="submitForm" type='submit' class='px-6 bg-green-400 hover:bg-green-500 text-white font-bold rounded-md py-2'>Submit</button>
                    </div>
                    <div class='flex flex-col flex-grow'>
                        <button type='reset' class='px-6 bg-red-400 hover:bg-red-500 text-white font-bold rounded-md py-2'>Reset</button>
                    </div>
                </div>
            </form>
        <?php endif ?>
    </div>
</body>
</html>