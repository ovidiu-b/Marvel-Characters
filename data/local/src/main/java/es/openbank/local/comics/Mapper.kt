package es.openbank.local.comics

import es.openbank.local.comics.dbo.ComicDBO
import es.openbank.local.common.toBO
import es.openbank.local.common.toDBO
import es.openbank.model.comicGrid.ComicBO

fun List<ComicBO>.toDBO(): List<ComicDBO> {
    return map { it.toDBO() }
}

fun List<ComicDBO>.toBO(): List<ComicBO> {
    return map { it.toBO() }
}

fun ComicBO.toDBO() = ComicDBO(
    id,
    title,
    thumbnail.toDBO()
)

fun ComicDBO.toBO() = ComicBO(
    comicId,
    title,
    thumbnail.toBO()
)