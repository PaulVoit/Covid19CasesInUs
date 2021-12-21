package com.kotlinexample.covid19casesapp.rest

data class Finnhub(
    val state: String,
    val case: Int,
    val death: Int,
    val updated: String
)


