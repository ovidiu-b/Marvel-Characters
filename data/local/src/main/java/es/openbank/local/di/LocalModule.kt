package es.openbank.local.di

import android.content.Context
import dagger.Module
import dagger.Provides
import es.openbank.datasource.characters.CharactersLocalDataSource
import es.openbank.local.AppRoomDatabase
import es.openbank.local.characters.CharactersDAO
import es.openbank.local.characters.CharactersLocalDataSourceImpl
import es.openbank.local.comics.ComicsDAO
import es.openbank.local.series.SeriesDAO
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun appRoomDatabaseProvider(context: Context) = AppRoomDatabase.buildDatabase(context)

    @Provides
    fun charactersDaoProvider(database: AppRoomDatabase) = database.charactersDao()

    @Provides
    fun comicsDaoProvider(database: AppRoomDatabase) = database.comicsDao()

    @Provides
    fun seriesDaoProvider(database: AppRoomDatabase) = database.seriesDao()

    @Provides
    fun charactersLocalDataSourceProvider(
        charactersDao: CharactersDAO,
        comicsDao: ComicsDAO,
        seriesDao: SeriesDAO
    ) = CharactersLocalDataSourceImpl(charactersDao, comicsDao, seriesDao) as CharactersLocalDataSource

}