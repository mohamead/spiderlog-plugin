package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.util.open
import com.github.mohamead.spiderlog.plugin.util.validExtension
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

internal class OpenWithAction : SpiderlogAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project!!
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return
        open(project, virtualFile.toNioPath().toFile())
    }

    override fun update(e: AnActionEvent) {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
        val isLogFile = (virtualFile != null && !virtualFile.isDirectory &&
                virtualFile.extension != null && validExtension.contains(virtualFile.extension))
        e.presentation.isEnabledAndVisible = isLogFile
    }

}
