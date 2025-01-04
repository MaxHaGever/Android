package com.example.class1students

import android.os.Bundle
import android.util.Log
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
import com.example.class1students.model.Model
import com.example.class1students.model.Student

class StudentsListViewActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null

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
        //TODO 5: set dynamic data (MVP) - done
        //TODO 6: On click on checkbox

        students = Model.shared.students
        val listView: ListView? = findViewById(R.id.student_list_view)
        listView?.adapter = StudentsAdapter()
    }

    inner class StudentsAdapter(): BaseAdapter() {
        override fun getCount(): Int = students?.size ?: 0

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(position: Int, contentView: View?, parent: ViewGroup?): View {
            val inflator = LayoutInflater.from(parent?.context)
            var view = contentView
            if (view == null) {
                view = inflator.inflate(R.layout.student_list_row, parent, false)
                Log.d("TAG", "Inflating position $position")

                val checkBox: CheckBox? = view?.findViewById(R.id.student_row_checkbox)
                checkBox?.setOnClickListener {
                    val tagPosition = it.tag as? Int
                    val student = tagPosition?.let { pos -> students?.get(pos) }
                    student?.isChecked = checkBox.isChecked
                }
            }


            val student = students?.get(position)
            val nameTextView: TextView? = view?.findViewById(R.id.student_row_text_name)
            val idTextView: TextView? = view?.findViewById(R.id.student_row_text_id)
            val checkBox: CheckBox? = view?.findViewById(R.id.student_row_checkbox)


            nameTextView?.text = student?.name ?: ""
            idTextView?.text = student?.id
            checkBox?.apply {
                isChecked = student?.isChecked ?: false
                tag = position
            }

            return view!!
        }

    }

}