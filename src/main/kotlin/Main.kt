fun main() {
println(agoToText(60*24))
}

fun agoToText(numberOfSeconds: Int): String = when (numberOfSeconds) {
    in 0..60 -> "только что"
    in 61..<60 * 60 -> toTextTimeUnitsMinutes(numberOfSeconds)
    in 60 * 60..<24 * 60 * 60 -> toTextTimeUnitsHours(numberOfSeconds)
    in 24 * 60 * 60..<2 * 24 * 60 * 60 -> "вчера"
    in 2 * 24 * 60 * 60..<3 * 24 * 60 * 60 -> "позавчера"
    else -> "давно"
}

fun toTextTimeUnitsMinutes(numberOfSeconds: Int): String {
    val minutes = numberOfSeconds / 60
    val minutesRemains = minutes % 10
    return when {
        minutes in 10..20 -> "$minutes минут назад"
        minutesRemains == 1 && minutes != 11 -> "$minutes минуту назад"
        minutesRemains in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun toTextTimeUnitsHours(numberOfSeconds: Int): String = when(numberOfSeconds / 60 / 60) {
    1, 21 -> "${numberOfSeconds / 60 / 60} час назад"
    in 2..4, in 22..23 -> "${numberOfSeconds / 60 / 60} часа назад"
    else -> "${numberOfSeconds / 60 / 60} часов назад"
}


