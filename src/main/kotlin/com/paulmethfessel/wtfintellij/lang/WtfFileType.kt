package com.paulmethfessel.wtfintellij.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import com.paulmethfessel.wtfintellij.ui.MyIcons

class WtfFileType private constructor() : LanguageFileType(WtfLang.instance) {
  override fun getName() = "WTF"
  override fun getDescription() = "WTF language file"
  override fun getDefaultExtension() = "wtf"
  override fun getIcon() = MyIcons.lang

  companion object {
    val instance = WtfFileType()
  }
}