package com.github.mohamead.spiderlog.plugin

import com.github.mohamead.spiderlog.plugin.icons.SpiderlogIcons
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class SpiderlogIconsTest {

    @Test
    fun toolWindowIconTest() {
        val icon = SpiderlogIcons.spiderToolWindowIcon
        assertAll(
            { assertNotNull(icon) }
        )
    }

}