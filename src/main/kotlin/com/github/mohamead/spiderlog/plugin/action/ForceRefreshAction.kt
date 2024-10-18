package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.github.mohamead.spiderlog.plugin.util.LogTracer
import com.intellij.openapi.actionSystem.AnActionEvent
import java.awt.EventQueue
import java.io.File
import javax.swing.Icon

internal class ForceRefreshAction(spiderlogPanel: SpiderlogPanel, toolTip: String, icon: Icon?) :
    TableAction(spiderlogPanel, toolTip, icon) {

    override fun actionPerformed(e: AnActionEvent) {
        val filePath = spiderlogPanel.table.model.getColumnName(0)
        val file = File(filePath)
        EventQueue.invokeLater { LogTracer().display(spiderlogPanel, file) }
    }

}
