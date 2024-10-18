package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.github.mohamead.spiderlog.plugin.util.clearContent
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.Icon

internal class ClearAction(spiderlogPanel: SpiderlogPanel, toolTip: String, icon: Icon?) :
    TableAction(spiderlogPanel, toolTip, icon) {

    override fun actionPerformed(e: AnActionEvent) {
        spiderlogPanel.table.clearContent()
    }

}
