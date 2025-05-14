package com.ali.robokalamapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PortfolioDao {

    @Insert
    suspend fun insertPortfolio(portfolio: Portfolio)

    @Query("SELECT * FROM Portfolio")
    suspend fun getAllPortfolios(): List<Portfolio>

}

