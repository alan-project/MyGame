package net.alanproject.domain.util

import androidx.annotation.LongDef
import androidx.annotation.StringDef
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

@Retention(AnnotationRetention.SOURCE)
@LongDef(
    DateUnit.ONE_MONTH,
    DateUnit.THREE_MONTH,
    DateUnit.SIX_MONTH,
    DateUnit.ONE_YEAR
)

annotation class DateUnit{
    companion object{
        const val ONE_WEEK = (7*24*60*60*1000L)
        const val ONE_MONTH = ONE_WEEK*4
        const val THREE_MONTH = ONE_MONTH*3
        const val SIX_MONTH = ONE_MONTH*6
        const val ONE_YEAR = 365L
    }
}

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    Genre.ACTION,
    Genre.STRATEGY,
    Genre.PUZZLE,
    Genre.RACING
)

annotation class Genre {
    companion object {
        const val ACTION: String = "2,3,4,5"
        const val STRATEGY: String = "10,14"
        const val PUZZLE: String = "7,11,28,17"
        const val RACING: String = "1,15"
    }
}

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    Platform.PC,
    Platform.CONSOLE,
    Platform.MOBILE,
    Platform.XBOX,
    Platform.PS,
    Platform.NINTENDO
)

annotation class Platform {
    companion object {
        const val PC: String = "4,5,6"
        const val CONSOLE: String = "187,18,16,15,27,19,17,1,186,14,80,83,7,8,9,13,10,11"
        const val MOBILE: String = "3,21"
        const val XBOX: String = "1,14,80,186"
        const val PS: String = "187,18,16,15,27,19,17"
        const val NINTENDO: String = "83,7,8,9,13,10,11"
    }
}


private val sdf: SimpleDateFormat by lazy {
    SimpleDateFormat("yyyy-MM-dd")
}


fun Long.agoDate(
    curTime: Long = System.currentTimeMillis()
): String {
    val past = sdf.format(Date(curTime - this))
    val today = sdf.format(Date(curTime))
    Timber.d("past:$past, today:$today")
    return "$past,$today"
}

fun Long.afterDate(
    curTime: Long = System.currentTimeMillis()
): String {
    val today = sdf.format(Date(curTime))
    val future = sdf.format(Date(curTime + this))
    return "$today,$future"
}
