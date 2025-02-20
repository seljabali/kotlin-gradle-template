package org.eljabali.sami

import kotlinx.datetime.*
import java.time.DayOfWeek.*

object SystemTimeZoneDateTimes {
    val now: LocalDateTime get() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val today: LocalDateTime get() = now.atStartOfDay()
    val yesterday: LocalDateTime get() = today.minusDays(1)
    val tomorrow: LocalDateTime get() = today.plusDays(1)

    val lastMonday: LocalDateTime get() = today.getLast(MONDAY)
    val lastTuesday: LocalDateTime get() = today.getLast(DayOfWeek.TUESDAY)
    val lastWednesday: LocalDateTime get() = today.getLast(DayOfWeek.WEDNESDAY)
    val lastThursday: LocalDateTime get() = today.getLast(DayOfWeek.THURSDAY)
    val lastFriday: LocalDateTime get() = today.getLast(DayOfWeek.FRIDAY)
    val lastSaturday: LocalDateTime get() = today.getLast(DayOfWeek.SATURDAY)
    val lastSunday: LocalDateTime get() = today.getLast(DayOfWeek.SUNDAY)

    val nextMonday: LocalDateTime get() = today.getNext(DayOfWeek.MONDAY)
    val nextTuesday: LocalDateTime get() = today.getNext(DayOfWeek.TUESDAY)
    val nextWednesday: LocalDateTime get() = today.getNext(DayOfWeek.WEDNESDAY)
    val nextThursday: LocalDateTime get() = today.getNext(DayOfWeek.THURSDAY)
    val nextFriday: LocalDateTime get() = today.getNext(DayOfWeek.FRIDAY)
    val nextSaturday: LocalDateTime get() = today.getNext(DayOfWeek.SATURDAY)
    val nextSunday: LocalDateTime get() = today.getNext(DayOfWeek.SUNDAY)

    val firstDayOfThisYear: LocalDateTime get() = LocalDateTime(
        year = today.year,
        monthNumber = 1,
        dayOfMonth = 1,
        hour = 0,
        minute = 0,
        second = 0,
        nanosecond = 0
    )
    val lastDayOfThisYear: LocalDateTime get() = LocalDateTime(
        year = today.year,
        monthNumber = 12,
        dayOfMonth = 31,
        hour = 0,
        minute = 0,
        second = 0,
        nanosecond = 0
    )
}