import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import bll.CalculatorError;
import bll.CalculatorString;

public class XuLy {
	private static StringSelection stClipboard;
	private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	private static void CopyToClipboard(String s){
		stClipboard=new StringSelection(s);
		clipboard.setContents(stClipboard, stClipboard);
	}
	//Hàm gọi từ Main.java
	public static String Tinh(String s){
		CalculatorString CS=new CalculatorString();
		String result=CS.Convert(s);
		//Bắc
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
			result=CalculatorError.ERROR_SYNTAX;
		}
		result=result.toUpperCase();
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
			result=CalculatorError.ERROR_SYNTAX;
		}
		// TODO Auto-generated method stub
		CopyToClipboard(result);
		return result;
	}
	
	//PHẠM XUÂN BẮC
	
}
