package com.ali.robokalamapp

import retrofit2.http.GET

interface QuoteApi {
    @GET("today")
    suspend fun getQuote(): List<Quote>
}
