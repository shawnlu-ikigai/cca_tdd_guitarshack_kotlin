package com.guitarshack

fun main(args: Array<String>){
    val country = args[0]
    val orderTotal = args[1].toDouble()
    println(Shipping().calculateForOrder(country, orderTotal))
}