package com.github.shiraji.breakpointsmanager.model

import com.intellij.util.xmlb.annotations.MapAnnotation
import com.intellij.util.xmlb.annotations.Tag
import java.util.*

@Tag("breakpoints-set-info")
@MapAnnotation(surroundWithTag = false,
        surroundKeyWithTag = false,
        surroundValueWithTag = false,
        keyAttributeName = "name")
data class BreakpointsSetInfo(var id: String = UUID.randomUUID().toString(), var name: String = "")