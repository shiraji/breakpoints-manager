package com.github.shiraji.breakpointsmanager.model

data class BreakpointState(var entities: MutableMap<BreakpointsSetInfo, MutableList<BreakpointEntity>> = mutableMapOf())
