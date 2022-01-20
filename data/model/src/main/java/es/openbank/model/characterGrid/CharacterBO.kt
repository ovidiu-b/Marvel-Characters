package es.openbank.model.characterGrid

import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.ThumbnailBO

data class CharacterBO (
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailBO,
    val comics: List<ComicBO>? = null
)