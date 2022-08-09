package eu.deadbread.eventures.entities

import kotlin.math.roundToInt

internal const val METERS_IN_KILOMETER = 1000
internal const val YARDS_IN_METER = 0.9144
internal const val METERS_IN_YARD = 1.09361

sealed class Distance {

    abstract val meters: Int
    abstract val yards: Int

    data class Meters(override val meters: Int) : Distance() {
        override val yards: Int = meters.meters2yards()
    }

    data class Kilometers(val kilometers: Float) : Distance() {
        constructor(kilometers: Int) : this(kilometers.toFloat())

        override val meters: Int = (kilometers * METERS_IN_KILOMETER).roundToInt()
        override val yards: Int = meters.meters2yards()
    }

    data class Yards(override val yards: Int) : Distance() {
        override val meters: Int = yards.yards2meters()
    }

    protected fun Int.meters2yards(): Int {
        return (YARDS_IN_METER * this).roundToInt()
    }

    protected fun Int.yards2meters(): Int {
        return (METERS_IN_YARD * this).roundToInt()
    }
}