package com.kotlin.democoroutines.model

interface IUser {
    val email:String
    val pass:String
    fun isDataValid():Int
}