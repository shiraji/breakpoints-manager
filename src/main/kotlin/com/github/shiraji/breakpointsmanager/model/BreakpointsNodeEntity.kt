package com.github.shiraji.breakpointsmanager.model

import java.io.File

class BreakpointsNodeEntity(val entity: BreakpointsEntity) {
    override fun toString(): String {
        return "Line ${entity.line} in ${entity.fileUrl.substringAfterLast(File.separator)}"
    }
}