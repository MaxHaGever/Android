package com.example.class1students.model

class Model private constructor(){

    val students: MutableList<Student> = ArrayList()

    companion object{
        val shared = Model()
    }

    init {
        for (i in 0..20){
            val student = Student(
                name = "Name $i",
                id = "$i",
                avatarURL = "",
                isChecked = false
            )
            students.add(student)
        }
    }

}