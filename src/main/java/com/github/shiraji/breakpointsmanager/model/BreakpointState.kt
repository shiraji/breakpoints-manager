package com.github.shiraji.breakpointsmanager.model

data class BreakpointState(var entities: MutableMap<String, MutableList<BreakpointEntity>> = mutableMapOf())
