package com.github.shiraji.breakpointsmanager.model

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project


@State(name = "BreakpointsManagerConfigForWorkspace", storages = arrayOf(Storage(StoragePathMacros.WORKSPACE_FILE)))
class BreakpointsManagerConfigForWorkspace() : PersistentStateComponent<BreakpointsState> {
    var myState: BreakpointsState? = BreakpointsState()

    companion object {
        fun getInstance(project: Project) = ServiceManager.getService(project, BreakpointsManagerConfigForWorkspace::class.java)
    }

    override fun loadState(state: BreakpointsState) {
        myState = state
    }

    override fun getState(): BreakpointsState? {
        return myState
    }
}