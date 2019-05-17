package com.example.lab7_pdm_00062217.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.lab7_pdm_00062217.Database.GithubRepo
import com.example.lab7_pdm_00062217.Database.RoomDB
import com.example.lab7_pdm_00062217.Repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewmodel(app: Application):AndroidViewModel(app) {
    private val repository :GithubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }

    fun insert(repo:GithubRepo)=viewModelScope.launch (Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}