package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.github.mohamead.spiderlog.plugin.util.LogTracer
import com.intellij.openapi.actionSystem.AnActionEvent
import java.awt.EventQueue
import java.io.File
import javax.swing.Icon
import javax.swing.table.DefaultTableModel

internal class ForceRefreshAction(val spiderlogPanel: SpiderlogPanel, override val icon: Icon?) : SpiderlogAction(icon) {

    override fun actionPerformed(e: AnActionEvent) {
        val model = spiderlogPanel.table.model ?: return
        val defaultTableModel = model as DefaultTableModel
        val filePath = defaultTableModel.getColumnName(0) ?: return
        val file = File(filePath)
        EventQueue.invokeLater { LogTracer().display(spiderlogPanel, file) }
    }

}
