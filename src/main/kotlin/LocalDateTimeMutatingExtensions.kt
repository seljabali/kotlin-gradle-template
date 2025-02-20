package org.eljabali.sami

import kotlinx.datetime.*

fun LocalDateTime.atStartOfDay(): LocalDateTime = LocalDateTime(
    year = this.year,
    monthNumber = this.monthNumber,
    dayOfMonth = this.dayOfMonth,
    hour = 0,
    minute = 0,
    second = 0,
    nanosecond = 0
)

fun LocalDateTime.atEndOfDay(): LocalDateTime = LocalDateTime(
    year = this.year,
    monthNumber = this.monthNumber,
    dayOfMonth = this.dayOfMonth,
    hour = 23,
    minute = 59,
    second = 59,
    nanosecond = Int.MAX_VALUE
)

fun LocalDateTime.withLocalTime(localTime: LocalTime): LocalDateTime  = LocalDateTime(
    year = this.year,
    monthNumber = this.monthNumber,
    dayOfMonth = this.dayOfMonth,
    hour = localTime.hour,
    minute = localTime.minute,
    second = localTime.second,
    nanosecond = localTime.nanosecond
)

fun LocalDateTime.minusDays(days: Int, timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDateTime =
    this.toInstant(timeZone)
    .plus(days * -1, DateTimeUnit.DAY, timeZone)
    .toLocalDateTime(timeZone)

fun LocalDateTime.plusDays(days: Int, timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDateTime =
    this.toInstant(timeZone)
    .plus(days, DateTimeUnit.DAY, timeZone)
    .toLocalDateTime(timeZone)

fun LocalDateTime.getLast(
    dayOfWeek: DayOfWeek,
    countingInThisDay: Boolean = false,
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDateTime {
    if (countingInThisDay && this.dayOfWeek == dayOfWeek) {
        return this
    }
    var mostRecentDay = this
    if (mostRecentDay.dayOfWeek == dayOfWeek) {
        mostRecentDay = mostRecentDay.minusDays(1, timeZone)
    }
    while (mostRecentDay.dayOfWeek != dayOfWeek) {
        mostRecentDay = mostRecentDay.minusDays(1, timeZone)
    }
    return mostRecentDay
}

fun LocalDateTime.getNext(
    dayOfWeek: DayOfWeek,
    countingInThisDay: Boolean = false,
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDateTime {
    if (countingInThisDay && this.dayOfWeek == dayOfWeek) {
        return this
    }
    var nextLocalDate = this
    if (nextLocalDate.dayOfWeek == dayOfWeek) {
        nextLocalDate = nextLocalDate.plusDays(1, timeZone)
    }
    while (nextLocalDate.dayOfWeek != dayOfWeek) {
        nextLocalDate = nextLocalDate.plusDays(1, timeZone)
    }
    return nextLocalDate
}