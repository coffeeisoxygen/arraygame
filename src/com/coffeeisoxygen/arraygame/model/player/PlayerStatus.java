package com.coffeeisoxygen.arraygame.model.player;

public enum PlayerStatus {
    FELL, // kondisi player keluar dari map
    EXHAUSTED, // kondisi player kehabisan energi
    MISSING, // kondisi player tersesat karena masuk ke obstacle
    WIN, // kondisi player menang
    LOSE, // kondisi player kalah
    ALIVE, // kondisi player masih hidup
    DEAD // kondisi player mati induk dari kondisi Fall, Exhausted, Missing

}
