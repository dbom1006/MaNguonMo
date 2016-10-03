package bll;

public class CalculatorError {
	public static String ERROR_DIVZERO="Lỗi! Không chia được cho 0";
	public static String ERROR_SYNTAX="Lỗi! Sai cú pháp";
	public static String ERROR_EXPRESSION="Lỗi! Biểu thức không đúng";
	private boolean isError;
	private String Error;
	public CalculatorError(){
		this.isError=false;
	}
	public boolean isError() {
		return isError;
	}
	public String getError(){
		return Error;
	}
	public void setError(boolean isError,String Error) {
		this.isError = isError;
		this.Error=Error;
	}
}
