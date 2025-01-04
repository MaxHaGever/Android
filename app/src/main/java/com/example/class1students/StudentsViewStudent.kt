package com.example.class1students

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentsViewStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_view_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name") ?: "Unknown"
        val id = intent.getStringExtra("id") ?: "Unknown"
        val isChecked = intent.getBooleanExtra("isChecked", false)

        findViewById<TextView>(R.id.studentsview_name).text = name
        findViewById<TextView>(R.id.studentsview_id).text = id
        findViewById<CheckBox>(R.id.checkBox2).isChecked = isChecked
    }
}