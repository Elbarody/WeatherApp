package com.elbarody.data.remote.helper

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formatTime(dateTime: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val dateTimeObj = LocalDateTime.parse(dateTime, formatter)
    return dateTimeObj.format(DateTimeFormatter.ofPattern("HH:mm"))
}
