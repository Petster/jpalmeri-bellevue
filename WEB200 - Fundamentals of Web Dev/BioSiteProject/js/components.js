"use strict";

const createNav = () => {
    let nav = document.querySelector('.navbar');
    
    nav.innerHTML = `
    <a href="index.html" id="homelink" class="navbar-brand d-flex me-auto">Josh</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsingNavbar3">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse" id="collapsingNavbar3">
        <ul class="nav navbar-nav ms-auto justify-content-end">
            <li class="nav-item">
                <a class="nav-link" id="home-link" href="index.html">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="aboutlink" href="about.html">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="hobbylink" href="hobby.html">Hobby</a>
            </li>
        </ul>
    </div>
    `;
}

const createFooter = () => {
    let foot = document.querySelector('.footer');
    let date =  new Date().getFullYear();

    foot.innerHTML = `
    <span class="text-white text-center">&copy; Designed and Developed By <a class="text-white" href="https://petstergaming.com/" target="_blank">Jason Palmeri</a> | ` + date  + `</span>
    `;
}

createNav();
createFooter();