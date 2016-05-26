package com.github.shiraji.breakpointsmanager.model

import com.intellij.lang.Language
import com.intellij.util.xmlb.annotations.MapAnnotation
import com.intellij.util.xmlb.annotations.Tag
import com.intellij.xdebugger.evaluation.EvaluationMode
import com.intellij.xdebugger.impl.breakpoints.XExpressionImpl


@Tag("breakpoint-expression")
@MapAnnotation(surroundWithTag = false,
        surroundKeyWithTag = false,
        surroundValueWithTag = false,
        keyAttributeName = "name")
data class BreakpointsLogExpression(var expression: String = "",
                                    var languageId: String? = null,
                                    var customInfo: String? = null,
                                    var mode: EvaluationMode = EvaluationMode.EXPRESSION) {
    fun toXExpression() = XExpressionImpl(expression, Language.findLanguageByID(languageId), customInfo, mode)
}