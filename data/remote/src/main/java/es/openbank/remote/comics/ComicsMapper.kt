package es.openbank.remote.comics

import es.openbank.model.comicGrid.ComicBO
import es.openbank.remote.comics.dto.ComicDTO
import es.openbank.remote.comics.dto.ComicResponseDTO
import es.openbank.remote.common.toBO

fun ComicResponseDTO.toBO(): List<ComicBO> {
    return data.results.map {
        it.toBO()
    }
}

fun ComicDTO.toBO() = ComicBO(id, title, thumbnail.toBO())