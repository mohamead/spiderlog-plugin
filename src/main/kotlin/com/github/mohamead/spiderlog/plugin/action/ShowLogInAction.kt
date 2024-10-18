package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.util.open
import com.intellij.ide.actions.RevealFileAction
import com.intellij.idea.LoggerFactory
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.PathManager
import java.io.File

internal class ShowLogInAction : SpiderlogAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project!!
        val ideaFile = if (RevealFileAction.isSupported()) {
            LoggerFactory.getLogFilePath().toString()
        } else {
            PathManager.getLogPath() + File.separator + "idea.log"
        }
        open(project, File(ideaFile))
    }

}