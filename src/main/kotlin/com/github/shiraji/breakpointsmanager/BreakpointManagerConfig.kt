package com.github.shiraji.breakpointsmanager

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project

@State(name = "BreakpointManagerConfig", storages = arrayOf(Storage("breakpointManagerConfig.xml")))
class BreakpointManagerConfig() : PersistentStateComponent<BreakpointManagerConfig.State> {
    var myState: BreakpointManagerConfig.State? = BreakpointManagerConfig.State()

    companion object {
        fun getInstance(project: Project) = ServiceManager.getService(project, BreakpointManagerConfig::class.java)
    }

    override fun loadState(state: BreakpointManagerConfig.State) {
        myState = state
    }

    override fun getState(): BreakpointManagerConfig.State? {
        return myState
    }

    data class State(var entities: MutableMap<String, List<BreakpointsEntity>> = mutableMapOf())
}