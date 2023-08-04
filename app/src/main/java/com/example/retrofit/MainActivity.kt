package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputQueue.Callback
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.model.User
import com.example.retrofit.repository.MainRepository
import com.example.retrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private val repository = MainRepository()
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.api_text_view)

        var userList: MutableList<User>

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Observe the LiveData for questions and update UI when data is available
        (viewModel as MainViewModel).getUserFromLiveData().observe(this, Observer { questions ->
            if (questions.isNotEmpty()) {
                userList = questions.toMutableList()
                textView.text = userList.toString()
            } else {
                Toast.makeText(
                    this,
                    "Error",
                    Toast.LENGTH_LONG
                ).show()
            }
        })




    }

}