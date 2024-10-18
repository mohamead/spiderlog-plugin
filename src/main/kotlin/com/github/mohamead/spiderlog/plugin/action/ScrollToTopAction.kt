package com.github.mohamead.spiderlog.plugin.action

import com.github.mohamead.spiderlog.plugin.enum.Direction
import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.Icon

internal class ScrollToTopAction(spiderlogPanel: SpiderlogPanel, toolTip: String, icon: Icon) :
    ScrollAction(spiderlogPanel, toolTip, icon) {

    override fun actionPerformed(e: AnActionEvent) = scrollTo(Direction.TOP)

}
