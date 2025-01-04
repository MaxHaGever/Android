package com.example.class1students

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.class1students.model.Model


class EditStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cancelButton: Button = findViewById(R.id.edit_student_button_cancel)
        cancelButton.setOnClickListener {
            val recyclerViewIntent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(recyclerViewIntent)
            finish()
        }

        val nameEditText: EditText = findViewById(R.id.edit_student_input_name)
        val idEditText: EditText = findViewById(R.id.edit_student_input_id)
        val checkbox: CheckBox = findViewById(R.id.edit_student_checkbox)

        val name = intent.getStringExtra("name") ?: ""
        val id = intent.getStringExtra("id") ?: ""
        val isChecked = intent.getBooleanExtra("isChecked", false)

        nameEditText.setText(name)
        idEditText.setText(id)
        checkbox.isChecked = isChecked

        val deleteButton: Button = findViewById(R.id.edit_student_button_delete)
        deleteButton.setOnClickListener {
            val id = intent.getStringExtra("id") ?: return@setOnClickListener

            val studentList = Model.shared.students
            val studentToRemove = studentList.find { it.id == id }
            if (studentToRemove != null) {
                studentList.remove(studentToRemove)
            }

            val recyclerViewIntent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(recyclerViewIntent)
            finish()
        }

        val saveButton: Button = findViewById(R.id.edit_student_button_save)
        saveButton.setOnClickListener {
            val nameEditText: EditText = findViewById(R.id.edit_student_input_name)
            val idEditText: EditText = findViewById(R.id.edit_student_input_id)
            val checkbox: CheckBox = findViewById(R.id.edit_student_checkbox)

            val oldId = intent.getStringExtra("id") ?: return@setOnClickListener
            val newName = nameEditText.text.toString()
            val newId = idEditText.text.toString()
            val isChecked = checkbox.isChecked

            val studentList = Model.shared.students
            val studentToUpdate = studentList.find { it.id == oldId }
            if (studentToUpdate != null) {
                studentToUpdate.name = newName
                studentToUpdate.id = newId
                studentToUpdate.isChecked = isChecked
            }

            val recyclerViewIntent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(recyclerViewIntent)
            finish()
        }


    }
}