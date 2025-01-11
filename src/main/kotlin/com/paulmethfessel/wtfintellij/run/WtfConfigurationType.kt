package com.paulmethfessel.wtfintellij.run

import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.icons.AllIcons

class WtfConfigurationType : ConfigurationTypeBase(id, "Wtf", "Wtf run configuration type", AllIcons.Nodes.Console) {
  companion object {
    const val id = "WtfRunConfiguration"
  }

  init {
    addFactory(WtfConfigurationFactory(this))
  }
}