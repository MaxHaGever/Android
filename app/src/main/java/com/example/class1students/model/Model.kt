package com.example.class1students.model

class Model private constructor(){

    val students: MutableList<Student> = ArrayList()

    companion object{
        val shared = Model()
    }

    init {
        val student1 = Student(
            name = "Alice Johnson",
            id = "101",
            avatarURL = "",
            isChecked = false
        )
        val student2 = Student(
            name = "Bob Smith",
            id = "102",
            avatarURL = "",
            isChecked = false
        )
        val student3 = Student(
            name = "Charlie Brown",
            id = "103",
            avatarURL = "",
            isChecked = false
        )
        students.addAll(listOf(student1, student2, student3))
    }

}