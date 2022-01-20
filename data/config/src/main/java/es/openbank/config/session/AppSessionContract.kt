package es.openbank.config.session

interface AppSessionContract {
    fun setLastTimeCharactersFetched(timeStamp: Long)
    fun getLastTimeCharactersFetched(): Long

    fun setLastTimeComicsFetched(timeStamp: Long)
    fun getLastTimeComicsFetched(): Long

    fun setLastTimeSeriesFetched(timeStamp: Long)
    fun getLastTimeSeriesFetched(): Long

    fun getMaxCacheTime(): Long
}