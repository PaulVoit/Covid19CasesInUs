package com.kotlinexample.covid19casesapp.rest

import com.kotlinexample.covid19casesapp.rest.Finnhub
import io.reactivex.Observable
import retrofit2.http.GET

interface FinnhubApi {
    @GET("covid19/us?token=ACCESS_TOKEN")
    fun getCovidCases(): Observable<List<Finnhub>>
}