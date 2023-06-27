let reset = document.getElementById('resetDatabase');
let create = document.getElementById('createTable');
let drop = document.getElementById('dropTable');
let populate = document.getElementById('populateTable');

reset.addEventListener('click', function() {
    $.ajax({
        type: "POST",
        url: "Database/ResetDatabase.php",
        dataType: "json"
    }).done(function(data) {
            console.log(data);
            if(data.success) {
                swal({
                    title: "Success",
                    text: "Database has been reset to default!",
                    icon: "success",
                }).then(function() {window.location.reload();});
            } else {
                swal({
                    title: "Failed",
                    text: "Error: " + data.error,
                    icon: "error",
                })
            }
        });
})

create.addEventListener('click', function() {
    $.ajax({
        type: "POST",
        url: "Database/JasonCreateTable.php",
        dataType: "json"
    }).done(function(data) {
            console.log(data);
            if(data.success) {
                swal({
                    title: "Success",
                    text: "ToDo Table has been Created!",
                    icon: "success",
                }).then(function() {window.location.reload();});
            } else {
                swal({
                    title: "Failed",
                    text: "Error: " + data.error,
                    icon: "error",
                })
            }
        });
})

drop.addEventListener('click', function() {
    $.ajax({
        type: "POST",
        url: "Database/JasonDropTable.php",
        dataType: "json"
    }).done(function(data) {
            console.log(data);
            if(data.success) {
                swal({
                    title: "Success",
                    text: "ToDo Table has been Dropped!",
                    icon: "success",
                }).then(function() {window.location.reload();});
            } else {
                swal({
                    title: "Failed",
                    text: "Error: " + data.error,
                    icon: "error",
                })
            }
        });
})

populate.addEventListener('click', function() {
    $.ajax({
        type: "POST",
        url: "Database/JasonPopulateTable.php",
        dataType: "json"
    }).done(function(data) {
            console.log(data);
            if(data.success) {
                swal({
                    title: "Success",
                    text: "ToDo Table Populated",
                    icon: "success",
                }).then(function() {window.location.reload();});
            } else {
                swal({
                    title: "Failed",
                    text: "Error: " + data.error,
                    icon: "error",
                })
            }
        });
})