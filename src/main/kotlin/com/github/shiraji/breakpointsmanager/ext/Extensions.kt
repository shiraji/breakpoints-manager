package com.github.shiraji.breakpointsmanager.ext

import com.github.shiraji.breakpointsmanager.model.BreakpointsLogExpression
import com.intellij.xdebugger.XExpression

fun XExpression?.convertToEntity(): BreakpointsLogExpression? {
    this ?: return null

    return BreakpointsLogExpression().apply {
        val exp = this@convertToEntity
        languageId = exp.language?.id
        customInfo = exp.customInfo
        expression = exp.expression
        mode = exp.mode
    }
}
