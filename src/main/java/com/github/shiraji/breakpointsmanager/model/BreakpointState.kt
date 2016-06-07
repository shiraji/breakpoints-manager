package com.github.shiraji.breakpointsmanager.model

data class BreakpointState(var entities: MutableMap<String, List<BreakpointEntity>> = mutableMapOf())
