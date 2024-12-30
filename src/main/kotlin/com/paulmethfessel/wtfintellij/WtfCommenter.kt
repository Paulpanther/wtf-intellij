package com.paulmethfessel.wtfintellij

import com.intellij.lang.Commenter

class WtfCommenter : Commenter {
  override fun getLineCommentPrefix() = "//"
  override fun getBlockCommentPrefix() = null
  override fun getBlockCommentSuffix() = null
  override fun getCommentedBlockCommentPrefix() = null
  override fun getCommentedBlockCommentSuffix() = null
}