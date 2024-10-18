package com.github.mohamead.spiderlog.plugin.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.project.DumbAware
import javax.swing.Icon

internal abstract class SpiderlogAction(open val icon: Icon? = null) : AnAction(icon), DumbAware {

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

}