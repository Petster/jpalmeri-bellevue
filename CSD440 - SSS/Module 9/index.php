<?php
    $myName = "Jason";

    require_once('./Database/config.php');

    $error = "";

    try {
        $todo = mysqli_query($mysqli, 'SELECT * FROM baseball_01.todo');

        if(!empty($todo)) {
            while($row = mysqli_fetch_array($todo)) {
                $rows[] = $row;
            }
        } else {
            $rows = [];
        }
    } catch (Exception $e) {
        $error = 'Could not find Todo table. Please click the above "Reset Database" button';
    }


    //delete todo item
    if (isset($_GET['del_item'])) {
        $id = $_GET['del_item'];

        mysqli_query($mysqli, "DELETE FROM baseball_01.todo WHERE id=".$id);
        header('location: index.php');
    }

    //complete todo item
    if (isset($_GET['complete_item'])) {
        $id = $_GET['complete_item'];

        mysqli_query($mysqli, "UPDATE baseball_01.todo SET status = 1 WHERE id=".$id);
        header('location: index.php');
    }

    //update todo item
    if (isset($_GET['update_item'])) {
        $id = $_GET['update_item'];
        $newTodo = $_GET['todo_item'];
        $newPrio = $_GET['prio'];

        mysqli_query($mysqli, "UPDATE baseball_01.todo SET description = '".$newTodo."', priority = ".$newPrio." WHERE id=".$id);
        header('location: index.php');
    }

    if($_SERVER["REQUEST_METHOD"] == "POST") {
        if ( isset( $_POST[ 'addTodo' ] ) ) {
            if(!empty($_POST['title']) && !empty($_POST['due_date']) && !empty($_POST['priority']) && !empty($_POST['description'])) {
                //var_dump($_POST);

                $inputData = array(
                    "title" => $_POST['title'],
                    "due_date" => date('Y-m-d', strtotime($_POST['due_date'])),
                    "priority" => $_POST['priority'],
                    "description" => $_POST['description'],
                    "status" => 0
                );

                $stmt = $mysqli->prepare("INSERT INTO baseball_01.todo (title, due_date, description, status, priority) VALUES (?, ?, ?, ?, ?)");
                $stmt->bind_param("sssss", $inputData['title'], $inputData['due_date'], $inputData['description'], $inputData['status'], $inputData['priority']);

                try {
                    $stmt->execute();
                    header("Location: index.php");
                } catch (exception $e) {
                    header("Location: index.php");
                    $error =  $e->getMessage();
                }
            } else {
                $error = "Error: one or more fields were empty!";
            }
        }
    }

    $mysqli->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 9</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="css/global.css">
</head>
<body class='bg-purple-100 mx-auto flex flex-col min-h-screen sm:break-words md:break-normal'>
    <header class='h-16 flex flex-row content-center items-center justify-center backdrop-filter backdrop-blur-md bg-black bg-opacity-40'>
        <nav>
            <ul class='flex flex-row gap-4'>
                <li class='hover:underline cursor-pointer' id='resetDatabase'>Reset Database</li>
                <li class='hover:underline cursor-pointer' id='dropTable'>Drop Table</li>
                <li class='hover:underline cursor-pointer' id='createTable'>Create Table</li>
                <li class='hover:underline cursor-pointer' id='populateTable'>Populate Table</li>
            </ul>
        </nav>
    </header>
    <div class='w-2/3 mx-auto flex flex-col gap-4 flex-grow content-center items-center justify-center'>
        <div class='min-w-full flex flex-col gap-3 rounded-md p-4 backdrop-filter backdrop-blur-md bg-black bg-opacity-40'>
            <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" class='flex flex-col gap-2'>
                <div class='flex flex-row gap-4 content-center items-center justify-center'>
                    <div>
                        <div class='flex flex-col'>
                            <label class='text-center font-bold'>To-Do Title</label>
                            <input class='p-2 rounded-md' type='text' name='title' id='title'/>
                        </div>
                    </div>
                    <div>
                        <div class='flex flex-col'>
                            <label class='text-center font-bold'>Due Date</label>
                            <input class='p-2 rounded-md' type='date' name='due_date' id='due_date'/>
                        </div>
                    </div>
                    <div>
                        <div class='flex flex-col'>
                            <label class='text-center font-bold'>Priority</label>
                            <input class='p-2 rounded-md resize-none' type='number' name='priority' id='priority'>
                        </div>
                    </div>
                </div>
                <div>
                    <div class='flex flex-col'>
                        <label class='text-center font-bold'>To-Do Description</label>
                        <textarea rows='4' class='p-2 rounded-md resize-none' name='description' id='description'></textarea>
                    </div>
                </div>
                <div>
                    <div class='flex flex-row gap-2'>
                        <div class='flex flex-col flex-grow'>
                            <button name="addTodo" type='submit' class='px-6 bg-green-400 hover:bg-green-500 text-white font-bold rounded-md py-2'>Submit</button>
                        </div>
                        <div class='flex flex-col flex-grow'>
                            <button type='reset' class='px-6 bg-red-400 hover:bg-red-500 text-white font-bold rounded-md py-2'>Reset</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div id='todoContainer' class='flex flex-col min-w-full gap-4 overflow-auto' style='max-height: 500px;'>
        <div class='flex flex-row flex-grow justify-between w-full gap-4'>
            <div class='flex flex-grow w-full'>
                <input id='search' class='w-full p-2 rounded-md' type='text' onkeyup="filter()" placeholder='search by name' />
            </div>
        </div>
        <?php if(isset($rows)): ?>
            <?php
                array_multisort(array_column($rows, 'status'), SORT_ASC, array_column($rows, 'priority'), SORT_ASC, $rows);
            ?>
            <?php foreach($rows as $item): ?>
                <div id='<?= $item["title"] ?>' class='colItem flex flex-col min-w-full flex-grow rounded-md p-4 backdrop-filter backdrop-blur-md <?= $item['status'] == 1 ? "bg-purple-400" : "bg-black" ?> bg-opacity-40'>
                    <div class='flex flex-row flex-grow justify-between'>
                        <p class='font-bold text-lg'><?= $item['title'] ?></p>
                        <p id="displayPrio<?= $item['id'] ?>" class='font-bold text-lg'>Priority: <?= $item['priority'] ?></p>
                        <p id="editPrio<?= $item['id'] ?>" class='font-bold text-lg hidden'>Priority: <input id="prioinput<?= $item['id'] ?>" class='w-12 text-center' min='1' max='100' type='number' value="<?= $item['priority'] ?>" /></p>
                        <p class='font-bold text-lg'><?= date('m/d/Y', strtotime($item['due_date'])) ?></p>
                    </div>
                    <div class='border-b border-black'></div>
                    <div id="display<?= $item['id'] ?>" class='flex flex-col p-4'>
                        <p><?= $item['description'] ?></p>
                    </div>
                    <div id="edit<?= $item['id'] ?>" class='flex flex-col p-4 hidden'>
                        <textarea id="textarea<?= $item['id'] ?>" class='p-2'><?= $item['description'] ?></textarea>
                    </div>
                    <div class='border-b border-black'></div>
                    <div class='flex flex-row flex-grow justify-between p-2'>
                        <?php if($item['status'] == 0): ?>
                            <div id="editdiv<?= $item['id'] ?>" onclick="editHandler(<?= $item['id'] ?>)" class='flex items-center justify-center bg-blue-500 hover:bg-blue-900 hover:text-white cursor-pointer p-2 rounded-full h-10 w-10'>
                                <i id="button<?= $item['id'] ?>" class="fa-solid fa-pencil"></i>
                            </div>
                            <div id="savediv<?= $item['id'] ?>" onclick="saveHandler(<?= $item['id'] ?>)" class='hidden flex items-center justify-center bg-blue-500 hover:bg-blue-900 hover:text-white cursor-pointer p-2 rounded-full h-10 w-10'>
                                <i id="savebutton<?= $item['id'] ?>" class="fa-solid fa-floppy-disk"></i>
                            </div>
                        <?php else: ?>
                            <div class='flex items-center justify-center bg-zinc-500 hover:bg-zinc-900 hover:text-white cursor-pointer p-2 rounded-full h-10 w-10'>
                                <i class="fa-solid fa-pencil"></i>
                            </div>
                        <?php endif ?>
                        <a href="index.php?del_item=<?= $item['id'] ?>">
                            <div class='flex items-center justify-center bg-red-500 hover:bg-red-900 hover:text-white cursor-pointer p-2 rounded-full h-10 w-10'>
                                <i class="fa-solid fa-trash"></i>
                            </div>
                        </a>
                        <?php if($item['status'] == 1): ?>
                            <div class='flex items-center justify-center bg-zinc-500 hover:bg-zinc-900 hover:text-white cursor-pointer p-2 rounded-full h-10 w-10'>
                                <i class="fa-solid fa-check"></i>
                            </div>
                        <?php else: ?>
                            <a href="index.php?complete_item=<?= $item['id'] ?>">
                                <div class='flex items-center justify-center bg-green-500 hover:bg-green-900 hover:text-white cursor-pointer p-2 rounded-full h-10 w-10'>
                                    <i class="fa-solid fa-check"></i>
                                </div>
                            </a>
                        <?php endif ?>
                    </div>
                </div>
            <?php endforeach ?>
        <?php else: ?>
            <p class='text-center'>No Available Todo Items</p>
            <?php if($error !== ""): ?>
                <p class='text-center text-red-500 font-bold'>Error: <?= $error ?></p>
            <?php endif ?>
        <?php endif ?>
        </div>
    </div>
    <footer class='h-8 flex flex-col content-center items-center justify-center backdrop-filter backdrop-blur-md bg-black bg-opacity-40'>
        <p class='text-center'>&copy; Jason Palmeri</p>
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="./js/ajaxRequests.js"></script>
    <script src="./js/index.js"></script>
</body>
</html>