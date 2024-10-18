package com.github.mohamead.spiderlog.plugin.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.project.DumbAware
import javax.swing.Icon

internal abstract class SpiderlogAction(toolTip: String? = "", icon: Icon? = null) :
    AnAction(toolTip, null, icon), DumbAware {

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

}