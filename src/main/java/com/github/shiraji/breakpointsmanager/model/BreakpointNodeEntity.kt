package com.github.shiraji.breakpointsmanager.model

import java.io.File

class BreakpointNodeEntity(val entity: BreakpointEntity) {
    override fun toString(): String {
        return "Line ${entity.line} in ${entity.fileUrl.substringAfterLast(File.separator)}"
    }
}