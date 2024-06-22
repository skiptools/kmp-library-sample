package com.example.library

object Singleton {
    fun stringFunction(): String {
        return "Hello"
    }
}

class SampleClass(var stringField: String, var intField: Int, val doubleField: Double) {
    fun addFields() : Double {
        return intField + doubleField
    }
}

