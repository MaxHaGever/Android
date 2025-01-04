package com.example.class1students.model

class Model private constructor(){

    val students: MutableList<Student> = ArrayList()

    companion object{
        val shared = Model()
    }

    init {
        val student1 = Student(
            name = "Max Spector",
            id = "1",
            avatarURL = "",
            isChecked = false
        )
        val student2 = Student(
            name = "Roni Spector",
            id = "2",
            avatarURL = "",
            isChecked = false
        )
        val student3 = Student(
            name = "Yuri Spector",
            id = "3",
            avatarURL = "",
            isChecked = false
        )
        students.addAll(listOf(student1, student2, student3))
    }

}