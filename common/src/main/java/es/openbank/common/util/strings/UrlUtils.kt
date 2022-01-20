package es.openbank.common.util.strings

fun String.sanitizeHttp() = replace("http", "https")