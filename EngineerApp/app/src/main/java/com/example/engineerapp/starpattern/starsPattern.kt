package com.example.engineerapp.starpattern

fun main() {
    stars(6)
    println()
    starsSecond(6)
    println()
    starsThird(6)
    println()
    starsFourth(6)
    println()
    }

fun stars(num: Int) {
    for (i in 1..num) {
        for (j in 1..i) {
            print('*')
        }
        println()
    }
}

fun starsSecond(num: Int) {
    for (i in num downTo 1) {
        for (j in 1..i) {
            print('*')
        }
        println()
    }
}

fun starsThird(num: Int) {
    for (i in 1..num) {
        for (j in i..num) {
            print(' ')
        }
        for (k in 1..i) {
            print("*")
        }
        println()
    }
}

fun starsFourth(num: Int) {
    for (i in 1..num) {
        for (j in 1..i) {
            print(' ')
        }
        for (k in num downTo i) {
            print('*')
        }
        println()
    }
}