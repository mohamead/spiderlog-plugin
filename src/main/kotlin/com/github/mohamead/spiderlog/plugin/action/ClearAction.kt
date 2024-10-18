package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.github.mohamead.spiderlog.plugin.util.clearContent
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.Icon
import javax.swing.table.DefaultTableModel

internal class ClearAction(val spiderlogPanel: SpiderlogPanel, override val icon: Icon?) : SpiderlogAction(icon) {

    override fun actionPerformed(e: AnActionEvent) {
        spiderlogPanel.table.apply {
            clearContent()
            if (model is DefaultTableModel) {
                (model as DefaultTableModel).setColumnIdentifiers(arrayOf())
            }
        }
    }

}
