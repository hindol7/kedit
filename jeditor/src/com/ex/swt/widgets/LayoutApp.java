package com.ex.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LayoutApp {
	Display display = new Display();
	
	public static void main(String[] args) {
		LayoutApp app = new LayoutApp();
		app.show();
	}
	
	private void show() {
		Shell shell = initShell(display);
		
		makeScreen(shell);
		
		while ( !shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	private void makeScreen(Shell shell) {
		Label label = new Label(shell, SWT.BORDER);
		label.setText("This is a label.");
		label.setToolTipText("This is the tooltip of this label.");
		
		Button button = new Button(shell, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Called!");
			}
		});
		
		button.pack();
		label.pack();
	}
	
	public Shell initShell(Display display) {
		this.display = display;
		Shell shell = new Shell();
		
		shell.setLayout(new FillLayout());
		shell.setSize(1000, 700);
		shell.open();
		
		return shell;
	}

}
