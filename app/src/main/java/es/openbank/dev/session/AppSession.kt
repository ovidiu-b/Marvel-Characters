package es.openbank.dev.session

import android.content.SharedPreferences
import es.openbank.config.session.AppSessionContract

class AppSession(private val sharedPreferences: SharedPreferences): AppSessionContract {

    companion object {
        private const val LAST_TIME_CHARACTERS_FETCHED = "LAST_TIME_CHARACTERS_FETCHED"
        private const val LAST_TIME_COMICS_FETCHED = "LAST_TIME_CHARACTERS_FETCHED"
        private const val LAST_TIME_SERIES_FETCHED = "LAST_TIME_CHARACTERS_FETCHED"
    }

    override fun setLastTimeCharactersFetched(timeStamp: Long) {
        with(sharedPreferences.edit()) {
            putLong(LAST_TIME_CHARACTERS_FETCHED, timeStamp)
            commit()
        }
    }

    override fun getLastTimeCharactersFetched(): Long {
        return sharedPreferences.getLong(LAST_TIME_CHARACTERS_FETCHED, 0L)
    }

    override fun setLastTimeComicsFetched(timeStamp: Long) {
        with(sharedPreferences.edit()) {
            putLong(LAST_TIME_COMICS_FETCHED, timeStamp)
            commit()
        }
    }

    override fun getLastTimeComicsFetched(): Long {
        return sharedPreferences.getLong(LAST_TIME_COMICS_FETCHED, 0L)
    }

    override fun setLastTimeSeriesFetched(timeStamp: Long) {
        with(sharedPreferences.edit()) {
            putLong(LAST_TIME_SERIES_FETCHED, timeStamp)
            commit()
        }
    }

    override fun getLastTimeSeriesFetched(): Long {
        return sharedPreferences.getLong(LAST_TIME_SERIES_FETCHED, 0L)
    }

    override fun getMaxCacheTime(): Long = 1L * 3600L * 1000L   // 1 hour in milliseconds

}