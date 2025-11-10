class Key(val value: Int) {
    companion object {
        @JvmField
        val COMPARATOR: Comparator<Key> = compareBy<Key> { it.value }
    }
}

object Singleton {
    lateinit var provider: Provider
}

class Provider {
    fun provideService(): String {
        return "Service provided!"
    }
}