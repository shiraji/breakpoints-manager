package com.github.shiraji.breakpointsmanager.model

data class BreakpointsSetNode(val name: String, var isShared: Boolean) {
    override fun toString(): String {
        if (isShared) {
            return "[Shared] $name"
        } else {
            return name
        }
    }
}