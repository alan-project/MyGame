package net.alanproject.domain.util

import android.os.Build
import timber.log.Timber
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Parameters(
    val page: Int = 0,
    val period: String? = null,
    val genres: String? = null,
    val ordering: String? = "-added",
    val platforms: String? = null,
    val isFromMain: Boolean = false,


)

object RequestParameters {
        //Period
        val TRENDING_PERIOD: String = dateParsing(past = true, ONE_WEEK)
        val RANK_PERIOD: String = dateParsing(past = true, SIX_MONTH)
        val UPCOMING_PERIOD: String = dateParsing(past = false, ONE_MONTH)
        val RELEASE_PERIOD: String = dateParsing(past = true, ONE_MONTH)
        val GENRES_PERIOD: String = dateParsing(past = true, SIX_MONTH)

        //Genres
        val ACTION: String = "2,3,4,5"
        val STRATEGY: String = "10,14"
        val PUZZLE: String = "7,11,28,17"
        val RACING: String = "1,15"

        //Platforms
        val PC: String = "4,5,6"
        val CONSOLE: String = "187,18,16,15,27,19,17,1,186,14,80,83,7,8,9,13,10,11"
        val MOBILE: String = "3,21"
        val XBOX: String = "1,14,80,186"
        val PS: String = "187,18,16,15,27,19,17"
        val NINTENDO: String = "83,7,8,9,13,10,11"


        val DEFAULT_PARAMS: Parameters = Parameters(
            page =1,
            period = null,
            genres = null,
            ordering = "-added",
            isFromMain = false
        )

        val TRENDING_PARAMS: Parameters = Parameters(
            page =1,
            period = TRENDING_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true,
        )

        val RELEASE_PARAMS: Parameters = Parameters(
            page =1,
            period = RELEASE_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true,
        )

        val UPCOMING_PARAMS: Parameters = Parameters(
            page =0,
            period = UPCOMING_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true,
        )

        val RANK_PARAMS: Parameters = Parameters(
            page =1,
            period = RANK_PERIOD,
            genres = null,
            ordering = null,
            isFromMain = true
        )

        val ACTION_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            genres = ACTION,
            ordering = null,
            isFromMain = true,
        )
        val STRATEGY_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            genres = STRATEGY,
            ordering = null,
            isFromMain = true,
        )
        val PUZZLE_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            genres = PUZZLE,
            ordering = null,
            isFromMain = true,
        )
        val RACING_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            genres = RACING,
            ordering = null,
            isFromMain = true,
        )

        //Platforms
        val PC_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            ordering = null,
            platforms = PC,
            isFromMain = true,
        )
        val CONSOLE_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            ordering = null,
            platforms = CONSOLE,
            isFromMain = true,
        )
        val PS_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            ordering = null,
            platforms = PS,
            isFromMain = true,
        )
        val XBOX_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            ordering = null,
            platforms = XBOX,
            isFromMain = true,
        )
        val NINTENDO_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            ordering = null,
            platforms = NINTENDO,
            isFromMain = true
        )
        val MOBILE_PARAMS: Parameters = Parameters(
            page =1,
            period = GENRES_PERIOD,
            ordering = null,
            platforms = MOBILE,
            isFromMain = true,
        )
    }



fun dateParsing(past: Boolean, period: Long): String {

    val today = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.now()
    } else {
        TODO("VERSION.SDK_INT < O")
    }

    Timber.d("1) currentTime:  $today")

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    Timber.d("2) currentTime:  ${today.format(formatter)}")

    return if (past) {
        "${today.minusDays(period)},$today"
    } else {
        "${today.plusDays(1)},${today.plusDays(period)}"
    }
}

const val PAGE_SIZE = 20
const val HORIZONTAL_GAME_NUMBER = 5
const val ONE_WEEK = 7L
const val ONE_MONTH = 30L
const val TWO_MONTH = 60L
const val THREE_MONTH = 90L
const val SIX_MONTH = 180L
const val ONE_YEAR = 365L