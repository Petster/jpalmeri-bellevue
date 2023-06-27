let globalEdit = "";
let globalPrio = 1;

function filter() {
    let input = document.getElementById("search");
    let filter = input.value.toUpperCase();
    let row = document.getElementById("todoContainer");
    let col = row.getElementsByClassName("colItem");

    for(let i = 0; i < col.length; i++) {
    let txtValue = col[i].id;
    if(txtValue.toUpperCase().indexOf(filter) > -1) {
        col[i].style.display = "";
    } else {
        col[i].style.display = "none";
    }
    }
}

const editHandler = (id) => {
    let display = document.getElementById("display"+id);
    let edit = document.getElementById("edit"+id);
    let textarea = document.getElementById("textarea"+id);
    let prioinput = document.getElementById("prioinput"+id);
    let button = document.getElementById("button"+id);
    let editdiv = document.getElementById("editdiv"+id);
    let savediv = document.getElementById("savediv"+id);
    let displayPrio = document.getElementById("displayPrio"+id);
    let editPrio = document.getElementById("editPrio"+id);

    globalEdit = document.getElementById("textarea"+id).value;
    globalPrio = document.getElementById("prioinput"+id).value;

    display.classList.toggle('hidden');
    edit.classList.toggle('hidden');
    editdiv.classList.toggle('hidden');
    savediv.classList.toggle('hidden');
    displayPrio.classList.toggle('hidden');
    editPrio.classList.toggle('hidden');

    textarea.addEventListener('input', function(e) {
        globalEdit = e.target.value;
    })
    prioinput.addEventListener('input', function(e) {
        globalPrio = e.target.value;
    })
}

const saveHandler = (id) => {
    window.location.href = 'index.php?update_item='+id+'&todo_item='+globalEdit+'&prio='+globalPrio;
}