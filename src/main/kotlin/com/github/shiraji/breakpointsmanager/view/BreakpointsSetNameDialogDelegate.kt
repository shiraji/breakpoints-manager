package com.github.shiraji.breakpointsmanager.view

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.ui.DialogWrapper

class BreakpointsSetNameDialogDelegate(val dialog: BreakpointsSetNameDialog, val alreadyExistsNames: Array<String>) {
    fun initDialog() {
        dialog.apply {
            setTitle("Breakpoints Manager")
            addOkAction()
            setOkOperation {
                val name = dialog.nameTextField.text
                if (!name.isNullOrBlank()) {
                    if (alreadyExistsNames.contains(name)) {
                        Notifications.Bus.notify(Notification("com.github.shiraji.breakpointsmanager",
                                "Not unique name",
                                "Cannot save breakpoints set with : $name. It already exists",
                                NotificationType.ERROR))
                    } else {
                        dialogWrapper.close(DialogWrapper.OK_EXIT_CODE, false)
                    }
                }
            }
            addCancelAction()
        }
    }
}