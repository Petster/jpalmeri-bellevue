<?php

require('./fpdf/wordwrap.php');

require('./Database/config.php');

$error = "";

$todo = mysqli_query($mysqli, 'SELECT * FROM baseball_01.todo');

if(!empty($todo)) {
    while($row = mysqli_fetch_array($todo)) {
        $rows[] = $row;
    }
} else {
    $rows = [];
}

if($_SERVER["REQUEST_METHOD"] == "POST") {
    if ( isset( $_POST[ 'submitForm' ] ) ) {
        $pdf = new PDF();
        $pdf->AddPage();
        $pdf->SetFont('Arial','B',24);

        // About

        $pdf->Write(5, "To-Do List Database");
        $pdf->Ln(12);
        $pdf->SetFont('Arial','B',18);
        $pdf->Write(5, "Database Fields");
        $pdf->Ln(12);

        $width_cell=array(10, 30, 20, 30, 45);
        $pdf->SetFillColor(193,229,252);
        $pdf->SetFont('Arial','B',16);
        $pdf->Cell($width_cell[0], 10, 'id', 1, 0, 'C', true);
        $pdf->Cell($width_cell[4], 10, 'Title', 1, 0, 'C', true);
        $pdf->Cell($width_cell[1], 10, 'Due Date', 1, 0, 'C', true);
        $pdf->Cell($width_cell[3], 10, 'Priority', 1, 0, 'C', true);
        $pdf->Cell($width_cell[4], 10, 'Description', 1, 0, 'C', true);
        $pdf->Cell($width_cell[3], 10, 'Status', 1, 1, 'C', true);

        $pdf->SetFont('Arial','',12);
        $pdf->Ln(6);
        $pdf->Write(5, 'id: the primary key, unique identifier of a to-do item');
        $pdf->Ln(6);
        $pdf->Write(5, 'data type: int');

        $pdf->Ln(12);
        $pdf->Write(5, 'title: gives each to-do item a unique name');
        $pdf->Ln(6);
        $pdf->Write(5, 'data type: string');

        $pdf->Ln(12);
        $pdf->Write(5, 'due date: when the to-do item is due');
        $pdf->Ln(6);
        $pdf->Write(5, 'data type: date');

        $pdf->Ln(12);
        $pdf->Write(5, 'priority: how important the to-do item is (higher is lower priority)');
        $pdf->Ln(6);
        $pdf->Write(5, 'data type: int');

        $pdf->Ln(12);
        $pdf->Write(5, 'description: details about the to-do item');
        $pdf->Ln(6);
        $pdf->Write(5, 'data type: string');

        $pdf->Ln(12);
        $pdf->Write(5, 'status: incomplete or complete');
        $pdf->Ln(6);
        $pdf->Write(5, 'data type: boolean');

        // Header
        $pdf->Ln(12);
        $width_cell=array(10, 30, 20, 30, 45);
        $pdf->SetFillColor(193,229,252);
        $pdf->SetFont('Arial','B',16);
        $pdf->Cell($width_cell[0], 10, 'id', 1, 0, 'C', true);
        $pdf->Cell($width_cell[4], 10, 'Title', 1, 0, 'C', true);
        $pdf->Cell($width_cell[1], 10, 'Due Date', 1, 0, 'C', true);
        $pdf->Cell($width_cell[3], 10, 'Priority', 1, 0, 'C', true);
        $pdf->Cell($width_cell[4], 10, 'Description', 1, 0, 'C', true);
        $pdf->Cell($width_cell[3], 10, 'Status', 1, 1, 'C', true);

        // Rows
        $pdf->SetFont('Arial','B',10);
        foreach($rows as $items) {
            $pdf->Cell($width_cell[0], 10, $items['id'], 1, 0, 'C', false);
            $pdf->Cell($width_cell[4], 10, $items['title'], 1, 0, 'C', false);
            $pdf->Cell($width_cell[1], 10, $items['due_date'], 1, 0, 'C', false);
            $pdf->Cell($width_cell[3], 10, $items['priority'], 1, 0, 'C', false);
            $pdf->Cell($width_cell[4], 10, $items['description'], 1, 0, 'C', false);
            $pdf->Cell($width_cell[3], 10, $items['status'], 1, 1, 'C', false);
        }

        $pdf->Output();
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
    <title>Module 11</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class='bg-green-100 min-h-screen flex'>
    <div class='flex flex-col flex-grow content-center items-center justify-center'>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST" class='flex flex-col gap-3 rounded-md p-4 backdrop-filter backdrop-blur-md bg-black bg-opacity-40'>
            <div class='flex flex-row gap-2'>
                    <div class='flex flex-col flex-grow'>
                        <button name="submitForm" type='submit' class='px-6 bg-green-400 hover:bg-green-500 text-white font-bold rounded-md py-2'>Generate PDF</button>
                    </div>
                </div>
        </form>
    </div>
</body>
</html>