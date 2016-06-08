package com.github.shiraji.breakpointsmanager.model

data class BreakpointsSetNode(var breakpointsSetInfo: BreakpointsSetInfo,
                              var isShared: Boolean = false) {

    override fun toString(): String {
        if (isShared) {
            return "[Shared] ${breakpointsSetInfo.name}"
        } else {
            return breakpointsSetInfo.name
        }
    }
}