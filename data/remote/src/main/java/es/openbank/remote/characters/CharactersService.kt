package es.openbank.remote.characters

import es.openbank.remote.characters.dto.CharactersResponseDTO
import es.openbank.remote.comics.dto.ComicResponseDTO
import es.openbank.remote.series.dto.SeriesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersService {

    @GET("v1/public/characters")
    suspend fun getCharacters(): CharactersResponseDTO

    @GET("v1/public/characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharactersResponseDTO

    @GET("v1/public/characters/{id}/comics")
    suspend fun getComics(@Path("id") id: Int): ComicResponseDTO

    @GET("v1/public/characters/{id}/series")
    suspend fun getSeries(@Path("id") id: Int): SeriesResponseDTO

}