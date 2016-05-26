package com.github.shiraji.breakpointsmanager.view

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory

class BreakpointsToolWindow : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val contentManager = toolWindow.contentManager
        val breakpointsExplorer = BreakpointsExplorer(project)
        val content = contentManager.factory.createContent(breakpointsExplorer, null, false)
        contentManager.addContent(content)
        Disposer.register(project, breakpointsExplorer)
    }
}