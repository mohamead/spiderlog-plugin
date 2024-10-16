package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.util.clearContent
import com.github.mohamead.spiderlog.plugin.util.getToolWindowPanel
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.table.DefaultTableModel

internal class ClearAction : SpiderlogAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val table = getToolWindowPanel(e.project!!).table
        table.clearContent()
        if (table.model is DefaultTableModel) {
            val model = table.model as DefaultTableModel
            model.setColumnIdentifiers(arrayOf())
        }
    }

}
