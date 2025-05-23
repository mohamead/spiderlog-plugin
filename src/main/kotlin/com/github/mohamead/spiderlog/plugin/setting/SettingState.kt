package com.github.mohamead.spiderlog.plugin.setting

import com.github.mohamead.spiderlog.plugin.enum.FontName
import com.github.mohamead.spiderlog.plugin.enum.FontStyle
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.github.mohamead.spiderlog.settings.SettingsState",
    storages = [Storage("spiderlog.xml")]
)
internal class SettingState : PersistentStateComponent<SettingState> {

    var fontName: String = FontName.JETBRAINS_MONO.value
    var fontStyle: FontStyle = FontStyle.PLAIN
    var fontSize = 13

    fun getInstance(): SettingState {
        return ApplicationManager.getApplication().getService(SettingState::class.java)!!
    }

    override fun getState(): SettingState {
        return this
    }

    override fun loadState(state: SettingState) {
        XmlSerializerUtil.copyBean(state, this)
    }

}
