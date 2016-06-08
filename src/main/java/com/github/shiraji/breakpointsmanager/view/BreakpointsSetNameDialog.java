package com.github.shiraji.breakpointsmanager.view;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogBuilder;

import javax.swing.*;

public class BreakpointsSetNameDialog extends DialogBuilder {
    JPanel contentPane;
    public JTextField nameTextField;

    private BreakpointsSetNameDialogDelegate delegate;

    public BreakpointsSetNameDialog(Project project) {
        super(project);
        delegate = new BreakpointsSetNameDialogDelegate(this);
        delegate.initDialog();
        setCenterPanel(contentPane);
    }
}
