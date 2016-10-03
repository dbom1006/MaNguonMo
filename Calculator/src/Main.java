//Thái Trung Đức
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.wb.swt.SWTResourceManager;

public class Main {

	protected Shell shlCalculator;
	private Text txt_dulieu;
	private Button btn_1;
	private Button btn_0;
	private Button btn_xoakytu;
	private Button btn_xoahet;
	private Button btn_3;
	private Button btn_4;
	private Button btn_9;
	private Button btn_tru;
	private Button btn_2;
	private Button btn_cong;
	private Button btn_chia;
	private Button btn_7;
	private Button btn_8;
	private Button btn_xoa;
	private Button btn_6;
	private Button btn_bang;
	private Button btn_cham;
	private Button btn_nhan;
	private Button btn_5;
	private Button btn_mu;
	private Label lbl_luutru;
	private Listener listener;
	private Button btn_can;
	private Button btnSin;
	private Button btnCos;
	private Button btnTan;
	private Button btn_mo;
	private Button btn_dong;
	private Button btnBin;
	private Button btnHex;
	private Button btn_pi;
	private boolean daTinh=false;
	private boolean loiTinh=false;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
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
		shlCalculator.open();
		shlCalculator.layout();
		while (!shlCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlCalculator = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shlCalculator.setImage(SWTResourceManager.getImage("D:\\Study\\Open Source\\Calculator\\img\\Calculator.ico"));
		shlCalculator.setText("Calculator");
		shlCalculator.setSize(395, 398);
		shlCalculator.setMaximized(false);
		shlCalculator.setMinimumSize(351, 368);
		shlCalculator.setLayout(new FormLayout());
		
		Composite output = new Composite(shlCalculator, SWT.NONE);
		output.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		lbl_luutru = new Label(output, SWT.NONE);
		lbl_luutru.setLocation(0, 8);
		lbl_luutru.setSize(371, 32);
		lbl_luutru.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_luutru.setFont(SWTResourceManager.getFont("Microsoft JhengHei UI Light", 16, SWT.NORMAL));
		lbl_luutru.setAlignment(SWT.RIGHT);
		
		txt_dulieu = new Text(output, SWT.RIGHT);
		txt_dulieu.setLocation(0, 42);
		txt_dulieu.setSize(371, 32);
		txt_dulieu.setFont(SWTResourceManager.getFont("Segoe UI Semilight", 16, SWT.BOLD));
		
		Composite input = new Composite(shlCalculator, SWT.NONE);
		FormData fd_input = new FormData();
		fd_input.top = new FormAttachment(0, 94);
		fd_input.bottom = new FormAttachment(100, -10);
		fd_input.left = new FormAttachment(0, 10);
		fd_input.right = new FormAttachment(100, -8);
		input.setLayoutData(fd_input);
		FormData fd_output = new FormData();
		fd_output.bottom = new FormAttachment(input, -6);
		fd_output.top = new FormAttachment(0, 10);
		fd_output.left = new FormAttachment(input, 0, SWT.LEFT);
		fd_output.right = new FormAttachment(0, 381);
		output.setLayoutData(fd_output);
		btn_xoahet = new Button(input, SWT.NONE);
		btn_xoahet.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_xoahet.setText("C");
		btn_xoahet.setBounds(0, 0, 75, 45);
		btn_xoa = new Button(input, SWT.NONE);
		btn_xoa.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_xoa.setBounds(74, 0, 75, 45);
		btn_xoa.setText("CE");
		
		btn_xoakytu = new Button(input, SWT.NONE);
		btn_xoakytu.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_xoakytu.setBounds(148, 0, 75, 45);
		btn_xoakytu.setText("DEL");
		
		btn_cong = new Button(input, SWT.NONE);
		btn_cong.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_cong.setBounds(222, 44, 75, 45);
		btn_cong.setText("+");
		
		btn_7 = new Button(input, SWT.NONE);
		btn_7.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_7.setText("7");
		btn_7.setBounds(0, 88, 75, 45);
		
		btn_8 = new Button(input, SWT.NONE);
		btn_8.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_8.setSelection(true);
		btn_8.setText("8");
		btn_8.setBounds(74, 88, 75, 45);
		
		btn_9 = new Button(input, SWT.NONE);
		btn_9.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_9.setText("9");
		btn_9.setBounds(148, 88, 75, 45);
		
		btn_tru = new Button(input, SWT.NONE);
		btn_tru.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_tru.setText("-");
		btn_tru.setBounds(222, 88, 75, 45);
		
		btn_4 = new Button(input, SWT.NONE);
		btn_4.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_4.setText("4");
		btn_4.setBounds(0, 132, 75, 45);
		
		btn_5 = new Button(input, SWT.NONE);
		btn_5.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_5.setText("5");
		btn_5.setBounds(74, 132, 75, 45);
		
		btn_6 = new Button(input, SWT.NONE);
		btn_6.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_6.setText("6");
		btn_6.setBounds(148, 132, 75, 45);
		
		btn_nhan = new Button(input, SWT.NONE);
		btn_nhan.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_nhan.setText("*");
		btn_nhan.setBounds(222, 132, 75, 45);
		
		btn_1 = new Button(input, SWT.NONE);
		btn_1.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_1.setText("1");
		btn_1.setBounds(0, 176, 75, 45);
		
		btn_2 = new Button(input, SWT.NONE);
		btn_2.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_2.setText("2");
		btn_2.setBounds(74, 176, 75, 45);
		
		btn_3 = new Button(input, SWT.NONE);
		btn_3.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_3.setText("3");
		btn_3.setBounds(148, 176, 75, 45);
		
		btn_chia = new Button(input, SWT.NONE);
		btn_chia.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_chia.setText("/");
		btn_chia.setBounds(222, 176, 75, 45);
		
		btn_cham = new Button(input, SWT.NONE);
		btn_cham.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_cham.setText(".");
		btn_cham.setBounds(0, 220, 75, 45);
		
		btn_0 = new Button(input, SWT.NONE);
		btn_0.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_0.setText("0");
		btn_0.setBounds(74, 220, 75, 45);
		
		btn_bang = new Button(input, SWT.NONE);
		btn_bang.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.BOLD));
		btn_bang.setText("=");
		btn_bang.setBounds(222, 220, 149, 45);
		
		btn_mu = new Button(input, SWT.NONE);
		btn_mu.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_mu.setText("^");
		btn_mu.setBounds(296, 132, 75, 45);
		
		btn_can = new Button(input, SWT.NONE);
		btn_can.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_can.setText("\u221A");
		btn_can.setBounds(296, 176, 75, 45);
		
		btnSin = new Button(input, SWT.NONE);
		btnSin.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btnSin.setText("sin");
		btnSin.setBounds(0, 44, 75, 45);
		
		btnCos = new Button(input, SWT.NONE);
		btnCos.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btnCos.setText("cos");
		btnCos.setBounds(74, 44, 75, 45);
		
		btnTan = new Button(input, SWT.NONE);
		btnTan.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btnTan.setText("tan");
		btnTan.setBounds(148, 44, 75, 45);
		
		btn_mo = new Button(input, SWT.NONE);
		btn_mo.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_mo.setText("(");
		btn_mo.setBounds(222, 0, 75, 45);
		
		btn_dong = new Button(input, SWT.NONE);
		btn_dong.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btn_dong.setText(")");
		btn_dong.setBounds(296, 0, 75, 45);
		
		btnBin = new Button(input, SWT.NONE);
		btnBin.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btnBin.setText("BIN");
		btnBin.setBounds(296, 44, 75, 45);
		
		btnHex = new Button(input, SWT.NONE);
		btnHex.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		btnHex.setText("HEX");
		btnHex.setBounds(296, 88, 75, 45);
		
		btn_pi = new Button(input, SWT.NONE);
		btn_pi.setBounds(148, 220, 75, 45);
		btn_pi.setText("\u03C0");
		btn_pi.setFont(SWTResourceManager.getFont("Microsoft JhengHei Light", 11, SWT.NORMAL));
		
		listener = new Listener() {
		    public void handleEvent(Event event) {
		    	Widget wid=event.widget;
		    	String s,t=txt_dulieu.getText();
		    	if(loiTinh) t="";
		    	if(daTinh) s="";
		    	else s=t;
				if(wid==btn_1) txt_dulieu.setText(s+"1");
				if(wid==btn_2) txt_dulieu.setText(s+"2");
				if(wid==btn_3) txt_dulieu.setText(s+"3");
				if(wid==btn_4) txt_dulieu.setText(s+"4");
				if(wid==btn_5) txt_dulieu.setText(s+"5");
				if(wid==btn_6) txt_dulieu.setText(s+"6");
				if(wid==btn_7) txt_dulieu.setText(s+"7");
				if(wid==btn_8) txt_dulieu.setText(s+"8");
				if(wid==btn_9) txt_dulieu.setText(s+"9");
				if(wid==btn_0) txt_dulieu.setText(s+"0");
				if(wid==btn_cham) txt_dulieu.setText(s+".");
				if(wid==btn_mu) txt_dulieu.setText(s+"^");
				if(wid==btn_can) txt_dulieu.setText(s+"\u221A");
				if(wid==btn_cong) txt_dulieu.setText(t+"+");
				if(wid==btn_tru) txt_dulieu.setText(t+"-");
				if(wid==btn_nhan) txt_dulieu.setText(t+"*");
				if(wid==btn_chia) txt_dulieu.setText(t+"/");
				if(wid==btn_mo) txt_dulieu.setText(s+"(");
				if(wid==btn_dong) txt_dulieu.setText(s+")");
				if(wid==btnCos) txt_dulieu.setText(s+"cos");
				if(wid==btnSin) txt_dulieu.setText(s+"sin");
				if(wid==btnTan) txt_dulieu.setText(s+"tan");
				if(wid==btn_pi) txt_dulieu.setText(s+"\u03C0");
				if(wid==btn_xoakytu) if(!s.equals("")) txt_dulieu.setText(s.substring(0,s.length()-1));
				if(wid==btn_xoa) txt_dulieu.setText("");
				if(wid==btn_xoahet){ txt_dulieu.setText(""); lbl_luutru.setText(""); }
				daTinh=false;
				loiTinh=false;
				if(wid==btn_bang){
					daTinh=true;
					String result=XuLy.Tinh(t);
					lbl_luutru.setText(t); 
					txt_dulieu.setText(result); 
					if(result.contains("Lỗi!")) loiTinh=true;
				}
				if(wid==btnHex) {
					daTinh=true;
					String result=XuLy.Tinh(t);
					lbl_luutru.setText(result); 
					result=XuLy.ToHex(result);
					txt_dulieu.setText(result);
					if(result.contains("Lỗi!")) loiTinh=true;
				}
				if(wid==btnBin){ 
					daTinh=true;
					String result=XuLy.Tinh(t);
					lbl_luutru.setText(result);
					result=XuLy.ToBin(result);
					txt_dulieu.setText(result);
					if(result.contains("Lỗi!")) loiTinh=true;
				}
		    }
		};
		btn_0.addListener(SWT.Selection, listener);
		btn_1.addListener(SWT.Selection, listener);
		btn_2.addListener(SWT.Selection, listener);
		btn_3.addListener(SWT.Selection, listener);
		btn_4.addListener(SWT.Selection, listener);
		btn_5.addListener(SWT.Selection, listener);
		btn_6.addListener(SWT.Selection, listener);
		btn_7.addListener(SWT.Selection, listener);
		btn_8.addListener(SWT.Selection, listener);
		btn_9.addListener(SWT.Selection, listener);
		btn_cham.addListener(SWT.Selection, listener);
		btn_mu.addListener(SWT.Selection, listener);
		btn_can.addListener(SWT.Selection, listener);
		btn_cong.addListener(SWT.Selection, listener);
		btn_tru.addListener(SWT.Selection, listener);
		btn_nhan.addListener(SWT.Selection, listener);
		btn_chia.addListener(SWT.Selection, listener);
		btn_xoakytu.addListener(SWT.Selection, listener);
		btn_xoa.addListener(SWT.Selection, listener);
		btn_xoahet.addListener(SWT.Selection, listener);
		btn_bang.addListener(SWT.Selection, listener);
		btnBin.addListener(SWT.Selection, listener);
		btnHex.addListener(SWT.Selection, listener);
		btnTan.addListener(SWT.Selection, listener);
		btnSin.addListener(SWT.Selection, listener);
		btnCos.addListener(SWT.Selection, listener);
		btn_dong.addListener(SWT.Selection, listener);
		btn_mo.addListener(SWT.Selection, listener);
		btn_pi.addListener(SWT.Selection, listener);
	}
	public Button getBtn_1() {
		return btn_1;
	}
	public Button getBtn_0() {
		return btn_0;
	}
	public Button getBtn_xoakytu() {
		return btn_xoakytu;
	}
	public Button getBtn_xoahet() {
		return btn_xoahet;
	}
	public Button getBtn_3() {
		return btn_3;
	}
	public Button getBtn_4() {
		return btn_4;
	}
	public Button getBtn_9() {
		return btn_9;
	}
	public Button getBtn_tru() {
		return btn_tru;
	}
	public Button getBtn_2() {
		return btn_2;
	}
	public Button getBtn_cong() {
		return btn_cong;
	}
	public Button getBtn_chia() {
		return btn_chia;
	}
	public Button getBtn_7() {
		return btn_7;
	}
	public Button getBtn_8() {
		return btn_8;
	}
	public Button getBtn_xoa() {
		return btn_xoa;
	}
	public Button getBtn_6() {
		return btn_6;
	}
	public Button getBtn_bang() {
		return btn_bang;
	}
	public Button getBtn_cham() {
		return btn_cham;
	}
	public Button getBtn_nhan() {
		return btn_nhan;
	}
	public Button getBtn_5() {
		return btn_5;
	}
	public Button getBtn_mu() {
		return btn_mu;
	}
	public Label getLbl_luutru() {
		return lbl_luutru;
	}
	
	public class CalButton extends Button{

		public CalButton(Composite parent, int style) {
			super(parent, style);
			this.addListener(SWT.Selection,new Listener() {
			    public void handleEvent(Event event) {
			    	Widget wid=event.widget;
			    	String s,t=txt_dulieu.getText();
			    	if(loiTinh) t="";
			    	if(daTinh) s="";
			    	else s=t;
					if(wid==btn_1) txt_dulieu.setText(s+"1");
					if(wid==btn_2) txt_dulieu.setText(s+"2");
					if(wid==btn_3) txt_dulieu.setText(s+"3");
					if(wid==btn_4) txt_dulieu.setText(s+"4");
					if(wid==btn_5) txt_dulieu.setText(s+"5");
					if(wid==btn_6) txt_dulieu.setText(s+"6");
					if(wid==btn_7) txt_dulieu.setText(s+"7");
					if(wid==btn_8) txt_dulieu.setText(s+"8");
					if(wid==btn_9) txt_dulieu.setText(s+"9");
					if(wid==btn_0) txt_dulieu.setText(s+"0");
					if(wid==btn_cham) txt_dulieu.setText(s+".");
					if(wid==btn_mu) txt_dulieu.setText(s+"^");
					if(wid==btn_can) txt_dulieu.setText(s+"\u221A");
					if(wid==btn_cong) txt_dulieu.setText(t+"+");
					if(wid==btn_tru) txt_dulieu.setText(t+"-");
					if(wid==btn_nhan) txt_dulieu.setText(t+"*");
					if(wid==btn_chia) txt_dulieu.setText(t+"/");
					if(wid==btn_mo) txt_dulieu.setText(s+"(");
					if(wid==btn_dong) txt_dulieu.setText(s+")");
					if(wid==btnCos) txt_dulieu.setText(s+"cos");
					if(wid==btnSin) txt_dulieu.setText(s+"sin");
					if(wid==btnTan) txt_dulieu.setText(s+"tan");
					if(wid==btn_pi) txt_dulieu.setText(s+"\u03C0");
					if(wid==btn_xoakytu) if(!s.equals("")) txt_dulieu.setText(s.substring(0,s.length()-1));
					if(wid==btn_xoa) txt_dulieu.setText("");
					if(wid==btn_xoahet){ txt_dulieu.setText(""); lbl_luutru.setText(""); }
					daTinh=false;
					loiTinh=false;
					if(wid==btn_bang){
						daTinh=true;
						String result=XuLy.Tinh(t);
						lbl_luutru.setText(t); 
						txt_dulieu.setText(result); 
						if(result.contains("Lỗi!")) loiTinh=true;
					}
					if(wid==btnHex) {
						daTinh=true;
						String result=XuLy.Tinh(t);
						lbl_luutru.setText(result); 
						result=XuLy.ToHex(result);
						txt_dulieu.setText(result);
						if(result.contains("Lỗi!")) loiTinh=true;
					}
					if(wid==btnBin){ 
						daTinh=true;
						String result=XuLy.Tinh(t);
						lbl_luutru.setText(result);
						result=XuLy.ToBin(result);
						txt_dulieu.setText(result);
						if(result.contains("Lỗi!")) loiTinh=true;
					}
			    }
			});
		}
		
	}
}
