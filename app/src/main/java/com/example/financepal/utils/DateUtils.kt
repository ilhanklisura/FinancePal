package com.example.financepal.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {

    fun formatDate(date: Long): String {
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return sdf.format(Date(date))
    }

    fun formatTime(time: Long): String {
        val sdf = SimpleDateFormat(Constants.TIME_FORMAT, Locale.getDefault())
        return sdf.format(Date(time))
    }

    fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat(Constants.TIMESTAMP_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun parseDate(dateString: String): Long? {
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return try {
            val date = sdf.parse(dateString)
            date?.time
        } catch (e: Exception) {
            null
        }
    }

    fun parseTimestamp(timestampString: String): Long? {
        val sdf = SimpleDateFormat(Constants.TIMESTAMP_FORMAT, Locale.getDefault())
        return try {
            val date = sdf.parse(timestampString)
            date?.time
        } catch (e: Exception) {
            null
        }
    }
}