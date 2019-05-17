package com.example.lab7_pdm_00062217.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.lab7_pdm_00062217.Database.GithubDAO
import com.example.lab7_pdm_00062217.Database.GithubRepo

class GithubRepoRepository(private val repoDao:GithubDAO) {

    @WorkerThread
    suspend fun insert(repo:GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllREpos()

    fun nuke() = repoDao.nukeTable()
}