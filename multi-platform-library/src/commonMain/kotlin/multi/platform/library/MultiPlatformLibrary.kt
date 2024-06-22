package multi.platform.library

object Singleton {
    fun stringFunction(): String {
        return "Hello"
    }
}

class SampleClass(var stringField: String, var intField: Int, val doubleField: Double) {
    fun addNumbers() : Double {
        return intField + doubleField
    }
}

enum class SampleEnum(val rawValue: Int) {
    a(1),
    b(2),
    c(3)
}
