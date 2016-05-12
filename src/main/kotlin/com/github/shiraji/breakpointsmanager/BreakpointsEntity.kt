package com.github.shiraji.breakpointsmanager

import com.intellij.util.xmlb.annotations.MapAnnotation
import com.intellij.util.xmlb.annotations.Tag

@Tag("breakpoint-info")
@MapAnnotation(surroundWithTag = false,
        surroundKeyWithTag = false,
        surroundValueWithTag = false,
        keyAttributeName = "name")
data class BreakpointsEntity(var typeId: String = "",
                             var fileUrl: String = "",
                             var line: Int = 0,
                             var condition: String? = null,
                             var isTemporary: Boolean = false,
                             var isEnabled: Boolean = false,
                             var isLogMessage: Boolean = false,
                             var logExpression: String? = null)