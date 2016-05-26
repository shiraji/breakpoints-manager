package com.github.shiraji.breakpointsmanager.model

data class BreakpointsState(var entities: MutableMap<String, List<BreakpointsEntity>> = mutableMapOf())
