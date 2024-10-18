package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.Icon

internal abstract class TableAction(open val spiderlogPanel: SpiderlogPanel, toolTip: String, icon: Icon?) :
    SpiderlogAction(toolTip, icon) {

    override fun update(e: AnActionEvent) {
        super.update(e)
        if (e.project == null) return
        e.presentation.isEnabled = !spiderlogPanel.table.isEmpty
    }

}
