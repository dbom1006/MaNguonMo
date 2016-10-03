package bll;

import java.util.ArrayList;
import java.util.List;

public class StringHandling {
	private double result;
	public String input;
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	List<Double> so=new ArrayList<Double>();
    List<Character> dau=new ArrayList<Character>();
    String number;
    public StringHandling(String input){
    	this.input = input;
    	this.number="";
    	this.result = 0;
    	this.stringHead();
    	this.stringContent();
    	this.Tinh();
    }
    
	public boolean laDau(char c) {
        return (c=='+' || c=='-' || c=='*'||c=='/'||c=='^');
    }
	public boolean err;
	
	public void stringHead(){
		int i=0;
		if(input.charAt(i)=='-'){
            i++;
            number+='-';
            while(i< input.length() && !laDau(input.charAt(i)) ) {
                number+=input.charAt(i);
                i++;
            }
            if(!number.equals("")){
                so.add(Double.parseDouble(number));
                number = "";
            }
        }
	}
    
	public void stringContent(){
		int i=0;
		while (i < input.length()) {
            if (laDau(input.charAt(i))) {
                if (laDau(input.charAt(i + 1))) {
                    // Xử lý nếu có các dấu liên tiếp
                    if (input.charAt(i) == '+' && input.charAt(i + 1) != '*' && input.charAt(i + 1) != '/')
                        dau.add(input.charAt(++i));


                    // Xử lý --
                    else if (input.charAt(i) == '-' && input.charAt(i + 1) == '-') {
                        int dem = 0;
                        try {
                            while (i < input.length() && input.charAt(i) == '-') {
                                dem++;
                                i++;
                            }
                            if (!laDau(input.charAt(i)))
                                if (dem % 2 == 0) dau.add('+');
                                else dau.add('-');
                            else if (input.charAt(i) == '+') i++;

                            if (!number.equals("")) {
                                so.add(Double.parseDouble(number));
                                number = "";
                            }
                        } catch (Exception e) {
                            err = true;
                            number = "Error: Nhập dấu!";
                        }
                    }
                    // Sau dấu */ là cộng trừ
                    else if (input.charAt(i) == '*' || input.charAt(i) == '/' ) {
                        if (input.charAt(i + 1) == '-') {
                            dau.add(input.charAt(i));
                            i = i + 2;
                            if (!number.equals("")) {
                                double tam = Double.parseDouble(number) * -1;
                                so.add(tam);
                                number = "";
                            }

                        } else if (input.charAt(i + 1) == '+') {
                            dau.add(input.charAt(i));
                            i = i + 2;
                            if (!number.equals("")) {
                                so.add(Double.parseDouble(number));
                                number = "";
                  
                            }

                        }
                    }
                    //xu lý dấu mũ
                    else if (input.charAt(i) == '^') {
                        try {
                            if (input.charAt(i + 1) == '-' ) {
                                dau.add(input.charAt(i));
                                if (!number.equals("")) {
                                    double tam = 1 / Double.parseDouble(number);
                                    so.add(tam);
                                    number = "";
                                }
                                i = i + 2;
                            } else if (input.charAt(i + 1) == '+' ) {
                                dau.add(input.charAt(i));
                                if (!number.equals("")) {
                                    double tam = Double.parseDouble(number);
                                    so.add(tam);
                                    number = "";
                                }
                                i = i + 2;
                            } else {
                                err = true;
                                number =  "Error: Nhập dấu!";
                            }
                        }catch (Exception e) {
                            err = true;
                            number= "Error: Nhập dấu mũ!";
                        }

                    } 
                    
                    //xu lý dấu căn
                    else if (input.charAt(i) == '\u221A') {
                        try {
                        	dau.add(input.charAt(i++));
                            
                            if (laDau(input.charAt(i))) {
                                err = true;
                                number =  "Error: Nhập dấu!";
                            } 
                            if (!number.equals("")) {
                                so.add(Double.parseDouble(number));
                                number = "";
                                so.add(Double.parseDouble(number));
                            }
                            	
                        }catch (Exception e) {
                            err = true;
                            number= "Error: Nhập dấu căn!";
                        }

                    } else {
                        err = true;
                        number= "Eror: Nhập dấu!";
                    }

              
                } else {
                    dau.add(input.charAt(i++));
             
                    if (!number.equals("")) {
                        so.add(Double.parseDouble(number));
                        number = "";
                    }
                }
            } else {
                number += input.charAt(i);
                i++;
            }
            	
        }
		if (!number.equals("")) {
            so.add(Double.parseDouble(number));
            number = "";
        }
		
	}
	
	//Tinh toan 
	public void Tinh(){
		
		if(dau.size()>=so.size()){
            err = true;
           
        }
		int i;
        //Chạy vòng for để tính các dấu nhân với nhau (3*3*3*3*3*3)

        for(i=0;i<dau.size();i++)
        {
            if(dau.get(i)=='*'){
                double ans=so.get(i)*so.get(i+1);
                so.set(i,0.0);
                so.set(i+1,ans);
                dau.set(i,i>0?dau.get(i-1):'+');

            }
            if(dau.get(i)=='/'){
                if(so.get(i+1)==0) {
                    err=true;
                   // return "Infinity!";
                }
                double ans=so.get(i)/so.get(i+1);
                so.set(i,0.0);
                so.set(i+1,ans);
                dau.set(i,i>0?dau.get(i-1):'+');
            }
            try {
                if (dau.get(i) == '^') {
                    double ans = Math.pow(so.get(i), so.get(i + 1));
                    so.set(i, 0.0);
                    so.set(i + 1, ans);
                    dau.set(i, i > 0 ? dau.get(i - 1) : '+');
                }
                if (dau.get(i) == '\u221A') {
                    double ans = Math.sqrt(so.get(i));
                    so.set(i, 0.0);
                    so.set(i+1, ans);
                    dau.set(i, '+');
                }
                
            }
            catch (Exception e){
                err=true;
                //return "Error: Lỗi số mũ!";
            }
        }

        //Chạy vòng for để tính các dấu + -
        for(i=0;i<dau.size();i++)
        {
            if(dau.get(i)=='+'){

                double ans=so.get(i)+so.get(i+1);
                so.set(i,0.0);
                so.set(i+1,ans);
            }
            if(dau.get(i)=='-'){
                double ans=so.get(i)-so.get(i+1);
                so.set(i,0.0);
                so.set(i+1,ans);

            }
        }
        this.setResult(so.size()>0?so.get(so.size()-1):0);
        
        
	}

}
