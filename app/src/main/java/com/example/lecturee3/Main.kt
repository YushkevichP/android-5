package com.example.lecturee3


fun main() {
    val user = User().apply {
        name = "kskksks"
        age = 2
    }


}

data class User(var name: String = "", var age: Int = 0)


//---------------
//data class Wrapper(val i: Int) {
//    operator fun inc(): Wrapper {
//        return copy(i+1)
//    }
//}


//---------------
//interface Messenger< out T : Message> {
//    fun getValue():T
//
//}
//
//open class Message(val text: String)
//
//open class EmailMessage(text: String) : Message(text)
//
//class TestMessage(text: String) : EmailMessage(text)
//
//fun changeMessengerToEmail(smth: Messenger<EmailMessage>){
//    val messenger:Messenger<Message> = smth
//}
//---------------

//---------------
//fun check(user: User) {
//    when (user) {
//        is User.Student -> println(user.marks + user.surname);
//        is User.Teacher -> println(user.courses +user.name)
//    }
//}
//
//
//sealed class User {
//
//    abstract val name: String
//    abstract val surname: String
//    abstract val age: Int
//
//    data class Student(
//        override val name: String,
//        override val surname: String,
//        override val age: Int,
//        val marks: List<Int>
//    ) : User()
//
//    data class Teacher(
//        override val name: String,
//        override val surname: String,
//        override val age: Int,
//        val courses: List<String>
//    ) : User()
//
//}
//---------------
//data class User(
//    val name: String,
//    val surname: String,
//    val age: Int,
//    val type: UserType
//)
//
//enum class UserType {
//    STUDENT, TEACHER
//}