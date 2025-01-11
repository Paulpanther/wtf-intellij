package com.paulmethfessel.wtfintellij.run

import com.intellij.execution.configurations.RunConfigurationOptions
import com.paulmethfessel.wtfintellij.util.getValue
import com.paulmethfessel.wtfintellij.util.setValue

class WtfRunConfigurationOptions : RunConfigurationOptions() {
  var file by string("").provideDelegate(this, "file")
  var compiler by string("").provideDelegate(this, "compiler")
}