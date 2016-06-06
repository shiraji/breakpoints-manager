package com.github.shiraji.breakpointsmanager.model

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros
import com.intellij.openapi.project.Project


@State(name = "BreakpointsManagerConfigForWorkspace", storages = arrayOf(Storage(StoragePathMacros.WORKSPACE_FILE)))
class BreakpointsManagerConfigForWorkspace() : BreakpointsManagerConfig() {
    companion object {
        fun getInstance(project: Project) = ServiceManager.getService(project, BreakpointsManagerConfigForWorkspace::class.java)
    }
}