package com.example.lab7_pdm_00062217

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.lab7_pdm_00062217.Database.GithubRepo
import com.example.lab7_pdm_00062217.ViewModels.GithubRepoViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubRepoViewmodel::class.java)
        bt_button.setOnClickListener {
            val name = id_edit_text.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()) {
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.getAll().observe(this, Observer { repos ->
            for (repo in repos) {
                Log.d("Lista de repos", repo.name)
            }
        })
    }
}
