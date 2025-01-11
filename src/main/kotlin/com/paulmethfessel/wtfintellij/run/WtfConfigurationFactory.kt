package com.paulmethfessel.wtfintellij.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project

class WtfConfigurationFactory(type: WtfConfigurationType) : ConfigurationFactory(type) {
  override fun getId() = WtfConfigurationType.id

  override fun createTemplateConfiguration(project: Project): RunConfiguration {
    return WtfRunConfiguration(project, this, "Wtf")
  }

  override fun getOptionsClass() = WtfRunConfigurationOptions::class.java
}