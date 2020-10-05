package com.example.devshunter

fun main() {
    diskon(10, 25000)
}

fun diskon(jumlahBarang: Int, hargaSatuan: Int) {
    val result = jumlahBarang*hargaSatuan
    when {
        result >= 60000 -> {
            println("Anda Mendapatkan potongan harga sebesar 35%")
            println("Total Belanja: $result")
            var potonganHarga = result - (result*0.35)
            if (potonganHarga > 50000) {
                potonganHarga = 50000.0
                println("potongan harga: $potonganHarga")
                print("Total blanja setelah didiskon = ${result - potonganHarga} ")
            } else {
                potonganHarga = result - potonganHarga
                println("potongan harga: $potonganHarga")
                println("Total belanja setelah diskon = ${result-potonganHarga}")
            }
        }
        else -> {
            println("Total Belanjaan $result")
            println("Anda tidak mendapatkan Diskon")
        }
    }
}