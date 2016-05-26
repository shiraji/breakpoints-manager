package com.github.shiraji.breakpointsmanager.model

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project

@State(name = "BreakpointManagerConfig", storages = arrayOf(Storage("breakpointManagerConfig.xml")))
class BreakpointsManagerConfig() : PersistentStateComponent<BreakpointsState> {
    var myState: BreakpointsState? = BreakpointsState()

    companion object {
        fun getInstance(project: Project) = ServiceManager.getService(project, BreakpointsManagerConfig::class.java)
    }

    override fun loadState(state: BreakpointsState) {
        myState = state
    }

    override fun getState(): BreakpointsState? {
        return myState
    }
}