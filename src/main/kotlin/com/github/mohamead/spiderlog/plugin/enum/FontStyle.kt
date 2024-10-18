package com.github.mohamead.spiderlog.plugin.enum

internal enum class FontStyle(val index: Int) {
    PLAIN(0),
    BOLD(1),
    ITALIC(2);

    companion object {

        internal fun findByIndex(index: Int): FontStyle {
            return entries.firstOrNull { it.index == index }
                ?: throw NoSuchElementException("FontStyle with index '$index' not found.")
        }

    }
}
