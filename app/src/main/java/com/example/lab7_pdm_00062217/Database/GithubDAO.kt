package com.example.lab7_pdm_00062217.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GithubDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GithubRepo)

    @Query("SELECT * FROM repos")
    fun getAllREpos():LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()
}