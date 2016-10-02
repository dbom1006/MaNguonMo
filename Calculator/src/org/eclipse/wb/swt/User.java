package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class User {

	protected Shell shlQunLUser;
	private Text txtCauLenh;
	private List listResult;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User window = new User();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlQunLUser.open();
		shlQunLUser.layout();
		while (!shlQunLUser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlQunLUser = new Shell();
		shlQunLUser.setSize(499, 354);
		shlQunLUser.setText("Qu\u1EA3n l\u00FD User");
		shlQunLUser.setLayout(new FormLayout());
		
		txtCauLenh = new Text(shlQunLUser, SWT.BORDER);
		txtCauLenh.setText("C\u00E2u l\u1EC7nh");
		FormData fd_txtCauLenh = new FormData();
		fd_txtCauLenh.left = new FormAttachment(0, 10);
		fd_txtCauLenh.right = new FormAttachment(100, -154);
		txtCauLenh.setLayoutData(fd_txtCauLenh);
		
		Button btn_thucthi = new Button(shlQunLUser, SWT.NONE);
		btn_thucthi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RunCommand.RunCommand(txtCauLenh.getText());
			}
		});
		FormData fd_btn_thucthi = new FormData();
		fd_btn_thucthi.right = new FormAttachment(100, -10);
		fd_btn_thucthi.left = new FormAttachment(txtCauLenh, 6);
		fd_btn_thucthi.top = new FormAttachment(txtCauLenh, -2, SWT.TOP);
		btn_thucthi.setLayoutData(fd_btn_thucthi);
		btn_thucthi.setText("Th\u1EF1c Thi");
		
		listResult = new List(shlQunLUser, SWT.BORDER);
		fd_txtCauLenh.bottom = new FormAttachment(listResult, -6);
		FormData fd_listResult = new FormData();
		fd_listResult.left = new FormAttachment(0, 10);
		fd_listResult.bottom = new FormAttachment(100, -10);
		fd_listResult.top = new FormAttachment(0, 37);
		listResult.setLayoutData(fd_listResult);
		
		Button btnDanhSch = new Button(shlQunLUser, SWT.NONE);
		fd_listResult.right = new FormAttachment(btnDanhSch, -6);
		btnDanhSch.setText("S\u1EEDa");
		FormData fd_btnDanhSch = new FormData();
		fd_btnDanhSch.left = new FormAttachment(btn_thucthi, 0, SWT.LEFT);
		fd_btnDanhSch.right = new FormAttachment(100, -10);
		btnDanhSch.setLayoutData(fd_btnDanhSch);
		
		Button btnThm = new Button(shlQunLUser, SWT.NONE);
		fd_btnDanhSch.top = new FormAttachment(btnThm, 6);
		btnThm.setText("Th\u00EAm");
		FormData fd_btnThm = new FormData();
		fd_btnThm.left = new FormAttachment(listResult, 6);
		fd_btnThm.right = new FormAttachment(btn_thucthi, 0, SWT.RIGHT);
		btnThm.setLayoutData(fd_btnThm);
		
		Button button_1 = new Button(shlQunLUser, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listResult.setItems(RunCommand.ListUser());
			}
		});
		fd_btnThm.top = new FormAttachment(button_1, 6);
		button_1.setText("Danh s\u00E1ch");
		FormData fd_button_1 = new FormData();
		fd_button_1.top = new FormAttachment(btn_thucthi, 6);
		fd_button_1.left = new FormAttachment(btn_thucthi, 0, SWT.LEFT);
		fd_button_1.right = new FormAttachment(100, -10);
		button_1.setLayoutData(fd_button_1);
		
		Button btnXa = new Button(shlQunLUser, SWT.NONE);
		btnXa.setText("X\u00F3a");
		FormData fd_btnXa = new FormData();
		fd_btnXa.left = new FormAttachment(btn_thucthi, 0, SWT.LEFT);
		fd_btnXa.top = new FormAttachment(btnDanhSch, 6);
		fd_btnXa.right = new FormAttachment(btn_thucthi, 0, SWT.RIGHT);
		btnXa.setLayoutData(fd_btnXa);

	}
	
	public List getListResult() {
		return listResult;
	}
}
