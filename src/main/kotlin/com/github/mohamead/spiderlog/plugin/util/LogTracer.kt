package com.github.mohamead.spiderlog.plugin.util

import com.github.mohamead.spiderlog.plugin.ui.SpiderlogPanel
import java.beans.PropertyChangeEvent
import java.io.File
import javax.swing.SwingWorker
import javax.swing.table.DefaultTableModel

internal class LogTracer {

    internal fun display(spiderlogPanel: SpiderlogPanel, file: File) {
        val model = DefaultTableModel()
        spiderlogPanel.table.model = model
        val worker = LogWorker(file, model)
        worker.addPropertyChangeListener { e: PropertyChangeEvent ->
            val state: SwingWorker.StateValue = e.newValue as SwingWorker.StateValue
            spiderlogPanel.progressBar.isIndeterminate = state == SwingWorker.StateValue.STARTED
        }
        worker.execute()
    }

}
