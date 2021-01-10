package com.example.devshunter


fun main() {
    reversePyramid(4)
}

fun reversePyramid(tinggi: Int) {
    for (a in tinggi downTo 1) {
        for (baris in 1..tinggi - a) {
            print("  ")
        }
        for (b in a until 2 * a) {
            print("* ")
        }
        for (b in 0 until a - 1) {
            print("* ")
        }
        println()
    }
}