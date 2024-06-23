package multi.platform.library

import kotlin.random.Random
import kotlin.random.nextInt
import kotlinx.coroutines.delay
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import io.ktor.client.HttpClient
//import io.ktor.client.call.body
//import io.ktor.client.request.get
//import kotlin.coroutines.cancellation.CancellationException
//import io.ktor.client.engine.cio.CIO

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

class SampleAsync {
    suspend fun performSuspend(duration: Long, value: String): String {
        delay(duration)  // Suspends the coroutine
        return value
    }
}

//class URLFetcher {
//    suspend fun fetchUrl(url: String): String {
//        return withContext(Dispatchers.IO) {
//            val client = HttpClient(CIO)
//            try {
//                val response = client.get(url)
//                response.bodyAsText()
//            } finally {
//                client.close()
//            }
//        }
//    }
//}

enum class SampleEnum(val rawValue: Int) {
    a(1),
    b(2),
    c(3)
}

// sample borrowed from: https://github.com/android/kotlin-multiplatform-samples/blob/main/DiceRoller/shared/src/commonMain/kotlin/com/google/samples/apps/diceroller/DiceSettings.kt

data class DiceSettings(
    val diceCount: Int,
    val sideCount: Int,
    val uniqueRollsOnly: Boolean,
)

class DiceRoller {
    @Throws(IllegalArgumentException::class)
    fun rollDice(settings: DiceSettings): List<Int> {
        require(settings.diceCount >= 1) {
            "Must throw a positive number of dice (tried to roll ${settings.diceCount})"
        }
        require(settings.sideCount >= 3) {
            "Dice must have at least 3 sides (tried to roll ${settings.sideCount}-sided dice)"
        }

        return if (!settings.uniqueRollsOnly) {
            // Just roll the given number of dice and return results
            List(settings.diceCount) { Random.nextInt(1..settings.sideCount) }
        } else {
            require(settings.diceCount <= settings.sideCount) {
                "Can't roll ${settings.diceCount} unique values with ${settings.sideCount}-side dice"
            }

            buildList {
                // Create set of available numbers
                val availableNumbers = (1..settings.sideCount).toMutableSet()
                // Draw numbers from set
                repeat(settings.diceCount) {
                    val next = availableNumbers.random().also { availableNumbers.remove(it) }
                    add(next)
                }
            }
        }
    }
}