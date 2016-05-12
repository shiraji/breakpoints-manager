package com.github.shiraji.breakpointsmanager

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.xdebugger.XDebuggerManager
import com.intellij.xdebugger.breakpoints.XBreakpointProperties
import com.intellij.xdebugger.breakpoints.XLineBreakpoint
import com.intellij.xdebugger.breakpoints.XLineBreakpointType
import com.intellij.xdebugger.impl.XDebuggerManagerImpl
import com.intellij.xdebugger.impl.breakpoints.XBreakpointUtil

class BreakpointsManagerAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent?) {
        val project = e?.getData(CommonDataKeys.PROJECT) ?: return
        val manager = XDebuggerManager.getInstance(project) as XDebuggerManagerImpl
        val config = BreakpointManagerConfig.getInstance(project)
        if (manager.breakpointManager.allBreakpoints.size == 1) {
            ApplicationManager.getApplication().runWriteAction {
                config.state?.entities?.get("breakpoint")!!.forEach {
                    val type = XBreakpointUtil.findType(it.typeId) as XLineBreakpointType<XBreakpointProperties<Any>>?
                    val breakpoint = manager.breakpointManager.addLineBreakpoint(
                            type,
                            it.fileUrl,
                            it.line,
                            type?.createBreakpointProperties(VirtualFileManager.getInstance().findFileByUrl(it.fileUrl)!!, it.line))
                    breakpoint.condition = it.condition
                    breakpoint.isTemporary = it.isTemporary
                    breakpoint.isEnabled = it.isEnabled
                    breakpoint.isLogMessage = it.isLogMessage
                    breakpoint.logExpression = it.logExpression
                }
            }
        } else {
            config.state?.entities?.clear()
            val list = mutableListOf<BreakpointsEntity>()
            manager.breakpointManager.allBreakpoints.forEachIndexed { i, it ->
                if (it is XLineBreakpoint<*>) {
                    @Suppress("UNCHECKED_CAST")
                    val type = (it as XLineBreakpoint<XBreakpointProperties<Any>>).type

                    val entity = BreakpointsEntity(
                            fileUrl = it.fileUrl,
                            typeId = type.id,
                            line = it.line,
                            condition = it.condition,
                            isTemporary = it.isTemporary,
                            isEnabled = it.isEnabled,
                            isLogMessage = it.isLogMessage,
                            logExpression = it.logExpression)
                    list.add(entity)
                }
            }

            config.state?.entities?.put("breakpoint", list)
        }
    }
}