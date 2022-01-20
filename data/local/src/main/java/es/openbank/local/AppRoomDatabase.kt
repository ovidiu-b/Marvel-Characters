package es.openbank.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.openbank.local.characters.CharactersDAO
import es.openbank.local.characters.dbo.CharacterDBO
import es.openbank.local.comics.ComicsDAO
import es.openbank.local.comics.dbo.ComicDBO
import es.openbank.local.references.manyToMany.charactersAndComics.CharacterComicJoinIds
import es.openbank.local.references.manyToMany.charactersAndSeries.CharacterSeriesJoinIds
import es.openbank.local.series.SeriesDAO
import es.openbank.local.series.dbo.SeriesDBO

@Database(entities = [
        CharacterDBO::class,
        ComicDBO::class,
        SeriesDBO::class,
        CharacterComicJoinIds::class,
        CharacterSeriesJoinIds::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun charactersDao(): CharactersDAO
    abstract fun comicsDao(): ComicsDAO
    abstract fun seriesDao(): SeriesDAO

    companion object {
        private const val DATABASE_NAME = "RoomDB.db"

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
    }

}