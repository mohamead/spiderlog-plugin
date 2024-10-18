package com.github.mohamead.spiderlog.plugin.ui

import com.github.mohamead.spiderlog.plugin.setting.SettingState
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionToolbar
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.ui.JBMenuItem
import com.intellij.openapi.ui.JBPopupMenu
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.ui.table.JBTable
import java.awt.BorderLayout
import java.awt.Font
import java.awt.datatransfer.StringSelection

internal abstract class BaseSpiderlogPanel : SimpleToolWindowPanel(false) {

    protected fun buildToolbar(defaultActionGroup: DefaultActionGroup): ActionToolbar {
        return ActionManager.getInstance()
            .createActionToolbar("Spiderlog Navigator Toolbar", defaultActionGroup, false)
            .apply {
                targetComponent = this@BaseSpiderlogPanel
            }
    }

    protected fun buildPanel(): SimpleToolWindowPanel {
        return SimpleToolWindowPanel(true, true).apply {
            layout = BorderLayout()
        }
    }

    protected fun buildTable(): JBTable {
        return JBTable().apply {
            font = buildFont()
            componentPopupMenu = buildPopupMenu(this)
            tableHeader.reorderingAllowed = false
            tableHeader.resizingAllowed = false
            inheritsPopupMenu = true
            setShowGrid(false)
            setDefaultEditor(Object::class.java, null)
        }
    }

    protected fun buildFont(): Font {
        val state = SettingState().getInstance().state
        return Font(state.fontName, state.fontStyle.index, state.fontSize)
    }

    private fun buildPopupMenu(table: JBTable): JBPopupMenu {
        return JBPopupMenu().apply {
            val copyMenuItem = JBMenuItem("Copy", AllIcons.Actions.Copy).apply {
                this.addActionListener {
                    val selectedRows = table.selectedRows
                    val selectedColumns = table.selectedColumns
                    if (selectedRows.isNotEmpty() && selectedColumns.isNotEmpty()) {
                        var textToCopy = ""
                        for (row in selectedRows) {
                            textToCopy += table.getValueAt(row, 0).toString() + "\n"
                        }
                        CopyPasteManager.getInstance().setContents(StringSelection(textToCopy.trim().trimIndent()))
                    }
                }
            }
            this.add(copyMenuItem)
        }
    }

}