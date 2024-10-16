package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.util.LogTracer
import com.github.mohamead.spiderlog.plugin.util.clearContent
import com.github.mohamead.spiderlog.plugin.util.getToolWindow
import com.github.mohamead.spiderlog.plugin.util.getToolWindowPanel
import com.github.mohamead.spiderlog.plugin.util.validExtension
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import java.awt.EventQueue

internal class OpenWithAction : SpiderlogAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project!!
        getToolWindow(project).show()
        val toolWindowPanel = getToolWindowPanel(project)
        toolWindowPanel.table.clearContent()

        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return
        EventQueue.invokeLater { LogTracer().display(toolWindowPanel, virtualFile.toNioPath().toFile()) }
    }

    override fun update(e: AnActionEvent) {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
        val isLogFile = (virtualFile != null && !virtualFile.isDirectory &&
                virtualFile.extension != null && validExtension.contains(virtualFile.extension))
        e.presentation.isEnabledAndVisible = isLogFile
    }

}
