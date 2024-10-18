package com.github.mohamead.spiderlog.plugin.ui

import com.github.mohamead.spiderlog.plugin.action.ClearAction
import com.github.mohamead.spiderlog.plugin.action.ForceRefreshAction
import com.github.mohamead.spiderlog.plugin.action.OpenFileAction
import com.github.mohamead.spiderlog.plugin.action.ScrollToEndAction
import com.github.mohamead.spiderlog.plugin.action.ScrollToTopAction
import com.intellij.icons.AllIcons.Actions.AddFile
import com.intellij.icons.AllIcons.Actions.ForceRefresh
import com.intellij.icons.AllIcons.RunConfigurations.Scroll_down
import com.intellij.icons.AllIcons.RunConfigurations.Scroll_up
import com.intellij.icons.AllIcons.Vcs.Remove
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.table.JBTable
import javax.swing.JProgressBar

internal class SpiderlogPanel : BaseSpiderlogPanel() {

    internal val table: JBTable
    internal val progressBar: JProgressBar

    init {
        val defaultActionGroup = DefaultActionGroup().apply {
            add(OpenFileAction(this@SpiderlogPanel, "Open File", AddFile))
            add(ForceRefreshAction(this@SpiderlogPanel, "Force Refresh", ForceRefresh))
            add(ScrollToTopAction(this@SpiderlogPanel, "Scroll to Top", Scroll_up))
            add(ScrollToEndAction(this@SpiderlogPanel, "Scroll to End", Scroll_down))
            add(ClearAction(this@SpiderlogPanel, "Clear", Remove))
        }
        this.toolbar = buildToolbar(defaultActionGroup).component
        this.table = buildTable()
        this.progressBar = JProgressBar()
        val panel = buildPanel().apply {
            add(progressBar)
            add(JBScrollPane(table))
        }
        this.add(panel)
    }

    internal fun updateUi() {
        table.font = buildFont()
        table.updateUI()
    }

}
