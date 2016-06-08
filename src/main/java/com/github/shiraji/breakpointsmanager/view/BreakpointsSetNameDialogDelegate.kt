package com.github.shiraji.breakpointsmanager.view

import com.intellij.openapi.ui.DialogWrapper

class BreakpointsSetNameDialogDelegate(val dialog: BreakpointsSetNameDialog) {
    fun initDialog() {
        dialog.apply {
            setTitle("Breakpoints Manager")
            addOkAction()
            setOkOperation {
                val name = dialog.nameTextField.text
                if (!name.isNullOrBlank()) {
                    dialogWrapper.close(DialogWrapper.OK_EXIT_CODE, false)
                }
            }
            addCancelAction()
        }
    }
}