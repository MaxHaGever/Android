package com.example.class1students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentsListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TODO 1: Set xml layout - done
        //TODO 2: Set instance of list view - done
        //TODO 3: Set adapter - done
        //TODO 4: Create rows layout - done
        //TODO 5: set dynamic data (MVP)
        //TODO 6: On click on checkbox

        val listView: ListView? = findViewById(R.id.student_list_view)
        listView?.adapter = StudentsAdapter()
    }

    class StudentsAdapter(): BaseAdapter() {
        override fun getCount(): Int = 10

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(position: Int, contentView: View?, parent: ViewGroup?): View {
            val inflator = LayoutInflater.from(parent?.context)
            val view = contentView ?: inflator.inflate(R.layout.student_list_row, parent, false)

            val nameTextView: TextView = view.findViewById(R.id.student_row_text_name)
            val idTextView: TextView = view.findViewById(R.id.student_row_text_id)
            val checkBox: CheckBox = view.findViewById(R.id.student_row_checkbox)

            nameTextView.text = "Max Spector"
            idTextView.text = "123456"

            return view
        }
    }

}