package com.example.class1students

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentHostCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // TODO: 1 Add student button
        // TODO: 2 Navigate to add studnet
        //TODO: 3 Create AddStudentLayout
        //Todo: 4 Save student


        val addStudentButton: Button = findViewById(R.id.main_activity_add_student_button)
        addStudentButton.setOnClickListener {
            val intent = Intent(this,AddStudentActivity::class.java)
            startActivity(intent)
        }
    }
}