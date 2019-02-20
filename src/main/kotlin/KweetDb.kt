import java.util.*

class KweetDb(private val store: MutableList<Kweet> = mutableListOf()) {
    fun all(): List<Kweet> = store

    fun getById(kweetId: Int)
        = store.firstOrNull { it.id == kweetId }

    fun add(handle: String, text: String, timestamp: Date = Date()): Kweet {
        val maxId = store.maxBy { it.id }?.id
        val kweet = Kweet(
            id = (maxId ?: 0) + 1,
            handle = handle,
            text = text,
            timestamp = timestamp
        )
        store += kweet
        return kweet
    }
}