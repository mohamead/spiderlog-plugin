package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.github.mohamead.spiderlog.plugin.util.LogTracer
import com.github.mohamead.spiderlog.plugin.util.clearContent
import com.github.mohamead.spiderlog.plugin.util.openPath
import com.github.mohamead.spiderlog.plugin.util.validExtension
import com.intellij.openapi.actionSystem.AnActionEvent
import java.awt.EventQueue
import javax.swing.Icon

internal class OpenFileAction(val spiderlogPanel: SpiderlogPanel, override val icon: Icon?) : SpiderlogAction(icon) {

    override fun actionPerformed(e: AnActionEvent) {
        val extension = validExtension.joinToString("|")
        val filePath = openPath(e.project!!, "Open file", "Select a file (${extension})") ?: return
        spiderlogPanel.table.clearContent()
        EventQueue.invokeLater { LogTracer().display(spiderlogPanel, filePath.toFile()) }
    }

}
