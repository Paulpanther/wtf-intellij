package com.paulmethfessel.wtfintellij.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.paulmethfessel.wtfintellij.ui.WtfSettingsEditor


class WtfRunConfiguration(project: Project, factory: WtfConfigurationFactory, name: String) :
  RunConfigurationBase<WtfRunConfigurationOptions>(project, factory, name) {

  override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
    return object : CommandLineState(environment) {
      override fun startProcess(): ProcessHandler {
        val commandLine =
          GeneralCommandLine(
            "cargo",
            "run",
            "--manifest-path",
            options.compiler,
            "--bin",
            "wtf-compiler",
            "run",
            options.file
          )
        val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
        ProcessTerminatedListener.attach(processHandler)
        return processHandler
      }
    }
  }

  override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
    return WtfSettingsEditor()
  }

  public override fun getOptions() = super.getOptions() as WtfRunConfigurationOptions
}