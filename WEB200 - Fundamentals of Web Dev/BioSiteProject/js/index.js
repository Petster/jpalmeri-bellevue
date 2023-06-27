"use strict";
//Hobby Selection
let game = $('#hobbygame');
let yt = $('#hobbyyt');
let art = $('#hobbyart');
let gamedesc = $('#hobbygamedesc');
let ytdesc = $('#hobbyytdesc');
let artdesc = $('#hobbyartdesc');

let gameT = false;
let ytT = false;
let artT = false;

let pointers = document.getElementById('hobby').querySelectorAll('div.pointer');
const tiles = ['hobbygame', 'hobbyyt', 'hobbyart'];
const tileD = ['hobbygamedesc', 'hobbyytdesc', 'hobbyartdesc']

for(let point of pointers) {
    point.addEventListener('click', function() {
        switch(point.id) {
            case "hobbygameT":
                tileTrigger(tiles[0]);
                break;
            case "hobbyytT":
                tileTrigger(tiles[1]);
                break;
            case "hobbyartT":
                tileTrigger(tiles[2]);
                break;
        }
    })
}

function tileTrigger(pointerID) {
    let non_active_1, non_active_2, desc, active, dna_1, dna_2;
    switch(tiles.indexOf(pointerID)) {
        case 0:
            if(gameT != true) {
                active = $('#' + pointerID);
                non_active_1 = $('#' + tiles[1]);
                non_active_2 = $('#' + tiles[2]);
                desc = $('#' + tileD[0]);
                dna_1 = $('#' + tileD[1]);
                dna_2 = $('#' + tileD[2]);
                gameT = true;
                ytT = false;
                artT = false;
            } else {
                resetHobby();
            }
            break;
        case 1:
            if(ytT != true) {
                active = $('#' + pointerID);
                non_active_1 = $('#' + tiles[0]);
                non_active_2 = $('#' + tiles[2]);
                desc = $('#' + tileD[1]);
                dna_1 = $('#' + tileD[0]);
                dna_2 = $('#' + tileD[2]);
                gameT = false;
                ytT = true;
                artT = false;
            } else {
                resetHobby();
            }
            break;
        case 2:
            if(artT != true) {
                active = $('#' + pointerID);
                non_active_1 = $('#' + tiles[1]);
                non_active_2 = $('#' + tiles[0]);
                desc = desc = $('#' + tileD[2]);
                dna_1 = $('#' + tileD[1]);
                dna_2 = $('#' + tileD[0]);
                gameT = false;
                ytT = false;
                artT = true;
            } else {
                resetHobby();
            }
            break;
    }
    active.removeClass('hobby-icon-not-selected');
    active.removeClass('hobby-icon');
    active.toggleClass('hobby-icon-selected');
    dna_1.addClass('hidden');
    dna_2.addClass('hidden');
    non_active_1.addClass('hobby-icon-not-selected');
    non_active_2.addClass('hobby-icon-not-selected');
    non_active_1.removeClass('hobby-icon-selected');
    non_active_2.removeClass('hobby-icon-selected');
    desc.toggleClass('hidden');
}

function resetHobby() {
    gameT = false;
    ytT = false;
    artT = false;
    game.removeClass();
    game.addClass('hobby-icon');
    yt.removeClass();
    yt.addClass('hobby-icon');
    art.removeClass();
    art.addClass('hobby-icon');
    gamedesc.addClass('hidden');
    ytdesc.addClass('hidden');
    artdesc.addClass('hidden');
}