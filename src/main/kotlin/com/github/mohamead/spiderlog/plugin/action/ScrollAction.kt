package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.enum.Direction
import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import javax.swing.Icon

internal abstract class ScrollAction(spiderlogPanel: SpiderlogPanel, toolTip: String, icon: Icon?) :
    TableAction(spiderlogPanel, toolTip, icon) {

    protected fun scrollTo(direction: Direction) {
        val table = spiderlogPanel.table
        val rowIndex = when (direction) {
            Direction.END -> table.rowCount - 1
            Direction.TOP -> 0
        }
        table.changeSelection(rowIndex, 0, false, false)
    }

}
