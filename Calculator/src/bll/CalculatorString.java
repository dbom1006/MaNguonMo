package bll;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CalculatorString {
	private static String Pi = "\u03C0";
	private static String NumPi = "3.14159265358979";
	private static String Can = "\u221A";
	private static NumberFormat NF=new DecimalFormat("#.###########");
	private CalculatorError Error = new CalculatorError();

	private static boolean isCan(char s) {
		return s == '\u221A';
	}
	
	private static boolean hasCSCT(String s) {
		return s.contains("sin") || s.contains("cos") || s.contains("tan") || s.contains(Can);
	}
	
	private static boolean laDau(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || isCan(c));
	}

	private static boolean laSo(char c) {
		return c >= '0' && c <= '9';
	}
	
	private static String NFConvert(double value){
		String result=NF.format(value);
		if(result.equals("-0")) result="0";
		return result;
	}
	public String Convert(String s) {
		if (Error.isError())
			return Error.getError();
		else
			Error = new CalculatorError();
		String result = s;
		try {
			result = XuLyPi(result);
			result = XuLyNgoac(result);
			result = TinhToan(result);
		} catch (Exception e) {
			Error.setError(true, "Lỗi! Không xác định");
		}
		if (Error.isError())
			return Error.getError();
		return result;
	}

	private String XuLyPi(String s) {
		while (s.contains(Pi)) {
			int i = s.indexOf(Pi);
			if (i > 0 && laSo(s.charAt(i - 1))) {
				s = s.replaceFirst(Pi, "*" + NumPi);
			} else
				s = s.replaceFirst(Pi, NumPi);
		}
		return s;
	}
	private String TinhToan(String s) {
		s=XuLyCSCT(s);
		if (Error.isError())
			return Error.getError();
		double result = 0;
		List<Double> so = new ArrayList<Double>();
		List<Character> dau = new ArrayList<Character>();
		String number = "";
		int i = 0;
		if (s.charAt(i) == '-') {
			i++;
			number += '-';
			while (i < s.length() && !laDau(s.charAt(i))) {
				number += s.charAt(i);
				i++;
			}
			if (!number.equals("")) {
				so.add(Double.parseDouble(number));
				number = "";
			}
		}
		while (i < s.length()) {
			if (laDau(s.charAt(i))) {
				if (laDau(s.charAt(i + 1))) {
					// Xử lý nếu có các dấu liên tiếp
					
					// Xử lý --
					if (s.charAt(i) == '-' && s.charAt(i + 1) == '-') {
						int dem = 0;
						while (i < s.length() && s.charAt(i) == '-') {
							dem++;
							i++;
						}
						if (!laDau(s.charAt(i)))
							if (dem % 2 == 0)
								dau.add('+');
							else
								dau.add('-');
						else if (s.charAt(i) == '+')
							i++;
						try {
							if (!number.equals("")) {
								so.add(Double.parseDouble(number));
								number = "";
							}
						} catch (Exception e) {
							Error.setError(true, CalculatorError.ERROR_EXPRESSION);
						}
					}
					else if(s.charAt(i) == '+' && s.charAt(i + 1) == '-'){
						dau.add(s.charAt(i));
						i = i + 2;
						System.out.println(number);
						if (!number.equals("")) {
							so.add(Double.parseDouble(number));
							number = "-";
						}
					}
					// Sau dấu *,/,- là cộng trừ
					else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
						if (s.charAt(i + 1) == '-') {
							dau.add(s.charAt(i));
							i = i + 2;
							if (!number.equals("")) {
								double tam = Double.parseDouble(number) * -1;
								so.add(tam);
								number = "";
							}
						} else if (s.charAt(i + 1) == '+') {
							dau.add(s.charAt(i));
							i = i + 2;
							if (!number.equals("")) {
								so.add(Double.parseDouble(number));
								number = "";
							}
						}
					}
					// xu lý dấu mũ
					else if (s.charAt(i) == '^') {
						try {
							if (s.charAt(i + 1) == '-') {
								dau.add(s.charAt(i));
								if (!number.equals("")) {
									double tam = 1 / Double.parseDouble(number);
									so.add(tam);
									number = "";
								}
								i = i + 2;
							} else if (s.charAt(i + 1) == '+') {
								dau.add(s.charAt(i));
								if (!number.equals("")) {
									double tam = Double.parseDouble(number);
									so.add(tam);
									number = "";
								}
								i = i + 2;
							} else {
								Error.setError(true, CalculatorError.ERROR_EXPRESSION);
								Error.getError();
							}
						} catch (Exception e) {
							Error.setError(true, CalculatorError.ERROR_EXPRESSION);
							Error.getError();
						}
					} else {
						Error.setError(true, CalculatorError.ERROR_SYNTAX);
						return Error.getError();
					}
				} else {
					dau.add(s.charAt(i++));
					if (!number.equals("")) {
						so.add(Double.parseDouble(number));
						number = "";
					}
				}
			} else {
				number += s.charAt(i);
				i++;
			}
		}
		if (!number.equals("")) {
			so.add(Double.parseDouble(number));
			number = "";
		}
		if (dau.size() >= so.size()) {
			Error.setError(true, CalculatorError.ERROR_EXPRESSION);
		}
		// Chạy vòng for để tính các dấu nhân với nhau (3*3*3*3*3*3)

		for (i = 0; i < dau.size(); i++) {
			if (dau.get(i) == '*') {
				double ans = so.get(i) * so.get(i + 1);
				so.set(i, 0.0);
				so.set(i + 1, ans);
				dau.set(i, i > 0 ? dau.get(i - 1) : '+');
			}
			if (dau.get(i) == '/') {
				if (so.get(i + 1) == 0) {
					Error.setError(true, CalculatorError.ERROR_DIVZERO);
				}
				double ans = so.get(i) / so.get(i + 1);
				so.set(i, 0.0);
				so.set(i + 1, ans);
				dau.set(i, i > 0 ? dau.get(i - 1) : '+');
			}
			try {
				if (dau.get(i) == '^') {
					double ans = Math.pow(so.get(i), so.get(i + 1));
					so.set(i, 0.0);
					so.set(i + 1, ans);
					dau.set(i, i > 0 ? dau.get(i - 1) : '+');
				}
			} catch (Exception e) {
				Error.setError(true, CalculatorError.ERROR_SYNTAX);
			}
		}
		// Chạy vòng for để tính các dấu + -
		for (i = 0; i < dau.size(); i++) {
			if (dau.get(i) == '+') {

				double ans = so.get(i) + so.get(i + 1);
				so.set(i, 0.0);
				so.set(i + 1, ans);
			}
			if (dau.get(i) == '-') {
				double ans = so.get(i) - so.get(i + 1);
				so.set(i, 0.0);
				so.set(i + 1, ans);
			}
		}
		result = so.size() > 0 ? so.get(so.size() - 1) : 0;
		return NFConvert(result);
	}

	private String XuLyCSCT(String s) {
		while(hasCSCT(s)) {
			String a="";
			if (s.indexOf("sin")!=-1) {
				for(int i=s.indexOf("sin")+3;i<s.length();i++)
					if(!laSo(s.charAt(i)) && s.charAt(i)!='.'){
						a=s.substring(s.indexOf("sin"), i);
						break;
					}
				if(a.equals("")) a=s.substring(s.indexOf("sin"), s.length());
				s = s.replaceFirst(a,NF.format(Math.sin(Double.parseDouble(a.replace("sin","")))));
			}
			else if (s.indexOf("cos")!=-1) {
				for(int i=s.indexOf("cos")+3;i<s.length();i++)
					if(!laSo(s.charAt(i)) && s.charAt(i)!='.'){
						a=s.substring(s.indexOf("cos"), i);
						break;
					}
				if(a.equals("")) a=s.substring(s.indexOf("cos"), s.length());
				s = s.replaceFirst(a,NFConvert(Math.cos(Double.parseDouble(a.replace("cos","")))));
			}
			else if (s.indexOf("tan")!=-1) {
				for(int i=s.indexOf("tan")+3;i<s.length();i++)
					if(!laSo(s.charAt(i)) && s.charAt(i)!='.'){
						a=s.substring(s.indexOf("tan"), i);
						break;
					}
				if(a.equals("")) a=s.substring(s.indexOf("tan"), s.length());
				s = s.replaceFirst(a,NFConvert(Math.tan(Double.parseDouble(a.replace("tan","")))));
			}
			else if (s.indexOf(Can)!=-1) {
				for(int i=s.indexOf(Can)+1;i<s.length();i++)
					if(!laSo(s.charAt(i)) && s.charAt(i)!='.'){
						a=s.substring(s.indexOf(Can), i);
						break;
					}
				if(a.equals("")) a=s.substring(s.indexOf(Can), s.length());
				String x=a.replace(Can,"");
				if(x.contains("-")){
					Error.setError(true,"Lỗi! Không thể căn số âm");
					return Error.getError();
				}
				s = s.replaceFirst(a,NFConvert(Math.sqrt(Double.parseDouble(x))));
				
			}
		}
		return s;
	}

	private String XuLyNgoac(String s) {
		if (Error.isError())
			return Error.getError();
		List<Pair> ngoac = new ArrayList<Pair>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				int j = i;
				int x = 1;
				try {
					while (x != 0 || s.charAt(j) != ')') {
						j++;
						if (s.charAt(j) == '(')
							x++;
						if (s.charAt(j) == ')')
							x--;
					}
					ngoac.add(new Pair(i, j));
				} catch (Exception e) {
					Error.setError(true, CalculatorError.ERROR_EXPRESSION);
				}
			}
		}
		if (ngoac.size() > 0) {
			int len = 0;
			for (int i = ngoac.size() - 1; i >= 0; i--) {
				String a = s.substring(ngoac.get(i).first, ngoac.get(i).second + 1 - len);
				len += a.length() - TinhToan(a.replace("(", "").replace(")", "")).length();
				s = s.replace(a, TinhToan(a.replace("(", "").replace(")", "")));
			}
		}
		return s;
	}
	

}
