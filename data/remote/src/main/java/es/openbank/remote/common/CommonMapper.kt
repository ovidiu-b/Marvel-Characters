package es.openbank.remote.common

import es.openbank.model.common.ThumbnailBO
import es.openbank.remote.common.dto.ThumbnailDTO

fun ThumbnailDTO.toBO() = ThumbnailBO(
    path = path,
    extension = extension
)