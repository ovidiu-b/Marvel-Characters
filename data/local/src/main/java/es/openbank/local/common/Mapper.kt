package es.openbank.local.common

import es.openbank.local.common.dbo.ThumbnailDBO
import es.openbank.model.common.ThumbnailBO

fun ThumbnailBO.toDBO() = ThumbnailDBO(
    path,
    extension
)

fun ThumbnailDBO.toBO() = ThumbnailBO(
    path,
    extension
)