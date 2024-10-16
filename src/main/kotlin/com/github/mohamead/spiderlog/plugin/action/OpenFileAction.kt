package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.util.LogTracer
import com.github.mohamead.spiderlog.plugin.util.clearContent
import com.github.mohamead.spiderlog.plugin.util.getToolWindowPanel
import com.github.mohamead.spiderlog.plugin.util.openPath
import com.github.mohamead.spiderlog.plugin.util.validExtension
import com.intellij.openapi.actionSystem.AnActionEvent
import java.awt.EventQueue

internal class OpenFileAction : SpiderlogAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val extension = validExtension.joinToString("|")
        val filePath = openPath(e.project!!, "Open file", "Select a file (${extension})") ?: return
        val toolWindowPanel = getToolWindowPanel(e.project!!)
        toolWindowPanel.table.clearContent()
        EventQueue.invokeLater { LogTracer().display(toolWindowPanel, filePath.toFile()) }
    }

}
