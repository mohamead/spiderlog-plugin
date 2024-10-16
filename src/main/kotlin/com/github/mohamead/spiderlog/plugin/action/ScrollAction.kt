package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.enum.Direction
import com.github.mohamead.spiderlog.plugin.util.getToolWindowPanel
import com.intellij.openapi.project.Project

internal abstract class ScrollAction : SpiderlogAction() {

    protected fun scrollTo(project: Project, direction: Direction) {
        val table = getToolWindowPanel(project).table
        val rowIndex = when (direction) {
            Direction.END -> table.rowCount - 1
            Direction.TOP -> 0
        }
        if (table.rowCount == 0 || rowIndex > table.rowCount) return
        table.changeSelection(rowIndex, 0, false, false)
    }

}
