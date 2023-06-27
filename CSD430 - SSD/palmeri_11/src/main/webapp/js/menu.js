function openMenu() {
    document.getElementById("mobile").classList.remove("hidden");
}
function closeMenu() {
    document.getElementById("mobile").classList.add("hidden");
}

document.getElementById("accountb").addEventListener('click', function() {
    document.getElementById("account").classList.toggle("hidden");
});
