/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybignumber;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.util.ArrayList;
/**
 *
 * @author ThienChi
 */
public class Mybignumber implements StringCal{          
    private String s1,s2;                               

    public Mybignumber() {
        s1 = "0";
        s2 = "0";
    }
    
    public Mybignumber(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
        
    public ArrayList<String> sum() {                               // hàm sum dùng để tính tổng chuỗi s1 và s2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");   
        ArrayList<String> strArr = new ArrayList<>();    
        String str, finalResult = "";                             
        int len1 = getS1().length();                         // lấy độ dài của chuỗi s1;
        int len2 = getS2().length();                         // lấy độ dài của chuỗi s2;
        int maxlen = (len1 > len2) ? len1 : len2;       // so sánh 2 chuỗi để tìm ra max length;
        int nho = 0;                                    // biến dùng để lưu số nhớ;
        int s;                                          // biến dùng để cộng 2 kí tự trong chuỗi;
        int index1;                                     // biến dùng để lấy vị trí kí tự trong chuỗi s1;
	int index2;                                     // biến dùng để lấy vị trí kí tự trong chuỗi s2;
	char c1;                                        // biến dùng để lấy kí tự tại vị trí indexs1 chuỗi s1;
        char c2;                                        // biến dùng để lấy kí tự tại ví trí indexs2 chuỗi s2;		
	int count = 0;	

  	for(int i = 0; i < maxlen; i++) {               // vòng lặp chạy từ 0 đến max length ;
            index1 = len1 - i - 1;                      // vì length s1 chạy từ 1 mà i chạy từ 0 nên phải trừ cho 1 thì ta sẽ
            index2 = len2 - i - 1;                      // lấy được vị trí cuối cùng của chuỗi s1;
	    str = "";
            if(index1 >= 0) {
                c1 = getS1().charAt(index1);                 // lấy kí tự ở vị trí indexs1 trong chuỗi s1;
            }else {
                c1 = '0';                               // vị trí bé hơn 0 thì kí tự ở đó sẽ là 0;
	    }		
	    if(index2 >= 0) {
                c2 = getS2().charAt(index2);
	    }else {
                c2 = '0';
	    }	
            s = c1 - '0' + c2 - '0' + nho;              // cộng 2 số nguyên vừa chuyển đổi được với biến nhớ nếu có;
		  
            finalResult = (s % 10) + finalResult;       // gán finalResult bằng phần dư chia cho 10 của s+finalResult
            str+=("Step " + ++count + ": " + c1 + " + " + c2);
            if(nho > 0)
                str+=(" + " + nho);
                                                        // gán vào bên trái biến finalResult;
            nho = s / 10;                               // biến nhớ sẽ lấy phần nguyên chia cho 10;
            
            
            
            if (i == maxlen - 1 && nho > 0){          // đến lúc này nếu biến nhớ lớn hơn 0 thì cộng vào phía trước 
                finalResult = nho + finalResult;  
                str+=(" = " + s + "\tremember: 0\tresult: " + finalResult + "\tTime: " + dtf.format(LocalDateTime.now()));
            }
            else
                str+=(" = " + (s % 10) + "\tremember: " + nho + "\tresult: " + finalResult + "\tTime: " + dtf.format(LocalDateTime.now()));
            strArr.add(str);
        } 
        strArr.add(0,finalResult);
	return strArr;                             
    }

    /**
     * @return the s1
     */
    public String getS1() {
        return s1;
    }

    /**
     * @param s1 the s1 to set
     */
    public void setS1(String s1) {
        this.s1 = s1;
    }

    /**
     * @return the s2
     */
    public String getS2() {
        return s2;
    }

    /**
     * @param s2 the s2 to set
     */
    public void setS2(String s2) {
        this.s2 = s2;
    }
}
