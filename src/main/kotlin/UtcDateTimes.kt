package org.eljabali.sami

import kotlinx.datetime.*

object UtcDateTimes {
    val now: LocalDateTime get() = Clock.System.now().toLocalDateTime(TimeZone.UTC)
    val today: LocalDateTime get() = now.atStartOfDay()
    val yesterday: LocalDateTime get() = today.minusDays(1, TimeZone.UTC)
    val tomorrow: LocalDateTime get() = today.plusDays(1, TimeZone.UTC)

    val lastMonday: LocalDateTime get() = today.getLast(DayOfWeek.MONDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val lastTuesday: LocalDateTime get() = today.getLast(DayOfWeek.TUESDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val lastWednesday: LocalDateTime get() = today.getLast(DayOfWeek.WEDNESDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val lastThursday: LocalDateTime get() = today.getLast(DayOfWeek.THURSDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val lastFriday: LocalDateTime get() = today.getLast(DayOfWeek.FRIDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val lastSaturday: LocalDateTime get() = today.getLast(DayOfWeek.SATURDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val lastSunday: LocalDateTime get() = today.getLast(DayOfWeek.SUNDAY, countingInThisDay = false, timeZone = TimeZone.UTC)

    val nextMonday: LocalDateTime get() = today.getNext(DayOfWeek.MONDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val nextTuesday: LocalDateTime get() = today.getNext(DayOfWeek.TUESDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val nextWednesday: LocalDateTime get() = today.getNext(DayOfWeek.WEDNESDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val nextThursday: LocalDateTime get() = today.getNext(DayOfWeek.THURSDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val nextFriday: LocalDateTime get() = today.getNext(DayOfWeek.FRIDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val nextSaturday: LocalDateTime get() = today.getNext(DayOfWeek.SATURDAY, countingInThisDay = false, timeZone = TimeZone.UTC)
    val nextSunday: LocalDateTime get() = today.getNext(DayOfWeek.SUNDAY, countingInThisDay = false, timeZone = TimeZone.UTC)

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