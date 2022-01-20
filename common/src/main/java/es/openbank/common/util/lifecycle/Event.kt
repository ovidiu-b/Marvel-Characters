package es.openbank.common.util.lifecycle

open class Event<out T>(private val content: T) {
    private var hasBeenHandled = false

    fun getValueIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}