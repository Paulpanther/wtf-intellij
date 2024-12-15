package com.paulmethfessel.wtfintellij.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.paulmethfessel.wtfintellij.lang.WtfFileType
import com.paulmethfessel.wtfintellij.lang.WtfLang

class WtfFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, WtfLang.instance) {
  override fun getFileType() = WtfFileType.instance
  override fun toString() = "WTF file"
}