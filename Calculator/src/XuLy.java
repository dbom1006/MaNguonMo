import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import bll.StringHandling;

public class XuLy {
	private static StringSelection stClipboard;
	private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private static String ERROR_DIVZERO="Lỗi! Không chia được cho 0";
	private static String ERROR_SYNTAX="Lỗi! Sai cú pháp";
	private static String ERROR_EXPRESSION="Lỗi! Biểu thức không đúng";
	
	private static void CopyToClipboard(String s){
		stClipboard=new StringSelection(s);
		clipboard.setContents(stClipboard, stClipboard);
	}
	
	private static boolean checkPi(String s){
		return s.equals("\u03C0");
	}
	//Hàm gọi từ Main.java
	public static String Tinh(String s){
		//Bắc
		StringHandling st = new StringHandling(s);
		String result=String.valueOf(st.getResult());
		if(checkPi(result)) result=String.valueOf(Math.PI);
		
		
		
		
		
		
		//Giả sử có lỗi
		//if(true) result=ERROR_DIVZERO;
		CopyToClipboard(result);
		return result;
	}

	public static String ToHex(String s) {
		String result=s;
		try {
			Long d;
			if(s.contains(".")) 
			{	
				double db=Double.parseDouble(s);
				d=Double.doubleToRawLongBits(db);
			}
			else{
				int db=Integer.parseInt(s);
				d=(long) db;
			}
			// TODO Auto-generated method stub
			result=Long.toHexString(d);
		} catch (Exception e) {
			result=ERROR_SYNTAX;
		}
		CopyToClipboard(result);
		return result;
	}

	public static String ToBin(String s) {
		String result=s;
		try{
			Long d;
			if(s.contains(".")) 
			{	
				double db=Double.parseDouble(s);
				d=Double.doubleToRawLongBits(db);
			}
			else{
				int db=Integer.parseInt(s);
				d=(long) db;
			}
			result=Long.toBinaryString(d);
		}catch(Exception e){
			result=ERROR_SYNTAX;
		}
		// TODO Auto-generated method stub
		CopyToClipboard(result);
		return result;
	}
	
	//PHẠM XUÂN BẮC
	
}
