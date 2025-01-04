package com.example.class1students

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.class1students.model.Model
import com.example.class1students.model.Student

class StudentsRecyclerViewActivity : AppCompatActivity() {
    var students: MutableList<Student>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TODO 1: Create Layout - done
        //TODO 2: Create Adapter - done
        //TODO 3: Create View Holder - 😀
        students = Model.shared.students
        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = StudentsRecyclerAdapter(students)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.add_student_button)
        addButton.setOnClickListener {
            // TODO: Navigate to the "Add New Student" activity
        }
    }

    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var nameTextView: TextView? = null
        var idTextView: TextView? = null
        var checkBox: CheckBox? = null
        var student: Student? = null

        init {
            nameTextView = itemView.findViewById(R.id.student_row_text_name)
            idTextView = itemView.findViewById(R.id.student_row_text_id)
            checkBox = itemView.findViewById(R.id.student_row_checkbox)

            checkBox?.apply {
                setOnClickListener { view ->
                    (tag as? Int)?.let { tag ->
                        student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                    }
                }
            }

            itemView.setOnClickListener{
                adapterPosition
            }

        }

        // Move bind function outside the init block
        fun bind(student: Student, position: Int) {
            this.student = student
            nameTextView?.text = student.name
            idTextView?.text = student.id

            checkBox?.apply {
                isChecked = student.isChecked
                tag = position
            }
        }
    }


    class StudentsRecyclerAdapter(private val students: List<Student>?): RecyclerView.Adapter<StudentViewHolder>(){

        override fun getItemCount(): Int = students?.size ?: 1

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val inflation = LayoutInflater.from(parent.context)
            val view = inflation.inflate(
                R.layout.student_list_row,
                parent,
                false
            )
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

            students?.get(position)?.let { holder.bind(it,position) }
            
        }

    }
}