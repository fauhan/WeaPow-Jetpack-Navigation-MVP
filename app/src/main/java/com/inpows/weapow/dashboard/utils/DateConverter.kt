package com.inpows.weapow.dashboard.utils

import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    companion object {
        const val DATE_FORMAT_1 = "dd MMM yyyy"
        const val DATE_FORMAT_2 = "HH:mm"
    }

    fun convertLongToDate(time: Long, timezone: String): String {
        return try {
            val date = Date(time* 1000)
            val format = SimpleDateFormat(DATE_FORMAT_1, Locale.getDefault())
            format.timeZone = TimeZone.getTimeZone(timezone)
            format.format(date)
        } catch (e:Exception){
            "-";
        }
    }

    fun convertLongToTime(time: Long, timezone: String): String {
        return try {
            val date = Date(time* 1000)
            val format = SimpleDateFormat(DATE_FORMAT_2, Locale.getDefault())
            format.timeZone = TimeZone.getDefault()
            format.format(date)
        } catch (e:Exception){
            "-";
        }
    }

}