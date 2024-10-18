package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.enum.Direction
import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import javax.swing.Icon

internal abstract class ScrollAction(open val spiderlogPanel: SpiderlogPanel, override val icon: Icon?) : SpiderlogAction(icon) {

    protected fun scrollTo(direction: Direction) {
        val table = spiderlogPanel.table
        val rowIndex = when (direction) {
            Direction.END -> table.rowCount - 1
            Direction.TOP -> 0
        }
        if (table.rowCount == 0 || rowIndex > table.rowCount) return
        table.changeSelection(rowIndex, 0, false, false)
    }

}
