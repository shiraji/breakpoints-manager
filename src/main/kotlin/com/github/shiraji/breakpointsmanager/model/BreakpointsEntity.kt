package com.github.shiraji.breakpointsmanager.model

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
                             var condition: BreakpointsLogExpression? = null,
                             var isTemporary: Boolean = false,
                             var isEnabled: Boolean = false,
                             var isLogMessage: Boolean = false,
                             var logExpression: BreakpointsLogExpression? = null) : Comparable<BreakpointsEntity> {
    override fun compareTo(other: BreakpointsEntity): Int {
        if (this.equals(other)) return 0
        if (!fileUrl.equals(other.fileUrl)) return fileUrl.compareTo(other.fileUrl)
        return line.compareTo(other.line)
    }

}