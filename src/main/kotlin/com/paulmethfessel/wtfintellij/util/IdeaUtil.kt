package com.paulmethfessel.wtfintellij.util

import com.intellij.openapi.components.BaseState
import com.intellij.openapi.components.StoredProperty
import kotlin.reflect.KProperty

operator fun <T> StoredProperty<T>.setValue(
  parent: BaseState,
  property: KProperty<*>,
  s: T
) {
  setValue(parent, s)
}

operator fun <T> StoredProperty<T>.getValue(
  parent: BaseState,
  property: KProperty<*>
): T {
  return getValue(parent)
}