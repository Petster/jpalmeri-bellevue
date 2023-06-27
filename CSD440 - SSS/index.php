<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSD 440 - Server Side Development Projects</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-blue-100 min-h-sreen p-4'>
    <h1 class='text-2xl text-bold text-center mx-auto mb-4'>CSD 440 - Server Side Development Projects</h1>
    <div class='flex flex-col gap-4 mx-auto' id='modules'>

    </div>

    <script>
        for(let x = 1; x < 13; x++) {
            document.getElementById('modules').innerHTML += `
                <div class='flex flex-grow w-full bg-green-200 hover:bg-green-300'>
                    <a class='text-2xl text-center mx-auto p-2 rounded-sm flex flex-grow content-center items-center justify-center' href='Module ${x}'>Module ${x}</a>
                </div>
            `
        }
    </script>

</body>
</html>