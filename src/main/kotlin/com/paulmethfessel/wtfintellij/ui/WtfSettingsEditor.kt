package com.paulmethfessel.wtfintellij.ui

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel
import com.paulmethfessel.wtfintellij.run.WtfRunConfiguration
import javax.swing.JComponent

class WtfSettingsEditor : SettingsEditor<WtfRunConfiguration>() {
  private var compiler = ""
  private var file = ""

  private val panel = panel {
    val descriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("wtf")

    row {
      textFieldWithBrowseButton(
        "Select cargo.toml of Wtf compiler",
        fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("toml")
      )
        .label("Wtf compiler")
        .bindText(::compiler)
    }
    row {
      textFieldWithBrowseButton(
        "Select Wtf File",
        fileChooserDescriptor = descriptor
      )
        .label("File")
        .bindText(::file)
    }
  }

  override fun resetEditorFrom(s: WtfRunConfiguration) {
    compiler = s.options.compiler ?: ""
    file = s.options.file ?: ""

    panel.reset()
  }

  override fun applyEditorTo(s: WtfRunConfiguration) {
    panel.apply()

    s.options.compiler = compiler
    s.options.file = file
  }

  override fun createEditor(): JComponent {
    return panel
  }
}