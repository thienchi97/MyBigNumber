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
class MyBigNumber implements StringCal{          
    private StringBuilder s1,s2;                               
    
    public MyBigNumber() {
        s1 = new StringBuilder("0");
        s2 = new StringBuilder("0");
    }
    
    public MyBigNumber(String s1, String s2) {
        this.s1 = new StringBuilder(s1);
        this.s2 = new StringBuilder(s2);
    }
    
    /**
     * Hàm sum trả về giá trị tổng 2 số tương ứng với 2 tham số dưới dạng chuỗi
     * Xuất ra màn hình các bước tính tổng 
     * @param s1 chuỗi số thứ 1 chỉ bao gồm các ký số từ '0' đến '9'
     * @param s2 chuỗi số thứ 2 chỉ bao gồm các ký số từ '0' đến '9'
     * @return chuỗi số thể hiện giá trị tổng của s1 và s2
     */
    @Override
    public String sum(String s1, String s2) {       
        
        // kiểm tra tính hợp lệ: return exception nếu có tham số rỗng
        if (s1.equals("") || s2.equals(""))
            throw new NumberFormatException("Ban nhap so sai roi");
        
        // kiểm tra tính hợp lệ của tham số s1
        for (char c: s1.toCharArray()) {
            if(c - '0' < 0 || c - '0' > 9)
                throw new NumberFormatException("Ban nhap so sai roi");
        }
        
        // kiểm tra tính hợp lệ của tham số s2
        for (char c: s2.toCharArray()) {
            if(c - '0' < 0 || c - '0' > 9)
                throw new NumberFormatException("Ban nhap so sai roi");
        }
        
        // gán giá trị tham số vào 2 thuộc tính s1 s2
        setS1(s1);
        setS2(s2);
        
        // xóa các ký số '0' dư ở đầu chuỗi số s1
        while (getS1().startsWith("0") && getS1().length() > 1){
            this.s1.deleteCharAt(0);
        }
        
        // xóa các ký số '0' dư ở đầu chuỗi số s1
        while (getS2().startsWith("0") && getS2().length() > 1){
            this.s2.deleteCharAt(0);
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm"); // class định dạng DateTime   
        ArrayList<String> strArr = new ArrayList<>(); // mỗi phần tử chứa chuỗi biểu diễn 1 bước tính tổng
        String str; // tổng hợp chuỗi biểu diễn qua từng bước tính
        String finalResult = ""; // chuỗi kết quả trả về của hàm
        int len1 = getS1().length(); // độ dài của chuỗi s1
        int len2 = getS2().length();  // độ dài của chuỗi s2
        int maxlen = (len1 > len2) ? len1 : len2; // độ dài lớn nhất của 2 chuỗi
        int remember = 0; // giá trị nhớ
        int s; // tổng từng cặp kí số trong chuỗi
        int index1; // vị trí kí tự trong chuỗi s1
	int index2; // vị trí kí tự trong chuỗi s2
	char value1; // kí số tại index1
        char value2; // kí số tại index2	

        strArr.add(getS1() + " + " + getS2() + " = ?");
  	for(int i = 0; i < maxlen; i++) {
            index1 = len1 - i - 1; // index1 duyệt từ phải sang trái chuỗi s1
            index2 = len2 - i - 1; // index2 duyệt từ phải sang trái chuỗi s2
	    str = "";
            if(index1 >= 0) { // value1 lưu kí số tại index1, bằng '0' nếu index vượt ngoài hàng của số
                value1 = getS1().charAt(index1); 
            }else {
                value1 = '0';
	    }		
	    if(index2 >= 0) { // value2 lưu kí số tại index2, bằng '0' nếu index vượt ngoài hàng của số
                value2 = getS2().charAt(index2);
	    }else {
                value2 = '0';
	    }	
            s = value1 - '0' + value2 - '0' + remember; // tính tổng 2 giá trị số và biến nhớ
		  
            finalResult = (s % 10) + finalResult; // gộp phần Ghi của tổng s vào đầu chuỗi finalResult
            str += "Buoc " + (i+1) // gán giá trị diễn giải bước tính
                    + ": Lay " + value1 + " + " + value2
                    + ((remember > 0)? " Them " + remember + " " : "\t ");
                                                        
            remember = s / 10; // gán giá trị Nhớ của tổng s vào biến nhớ;
            
            if (i == maxlen - 1){ // Phân biệt cách diễn giải của bước cuối cùng (không cần tách giá trị nhớ) 
                finalResult = (remember > 0)? remember + finalResult : finalResult;  
                str+= "Duoc " + s + ((s/10 > 0)? " " : "\t ") + "Ghi " + s + "\t\t(" + dtf.format(LocalDateTime.now()) + ")";
            }
            else
                str+= "Duoc " + s + ((s/10 > 0)? " " : "\t ") + "Ghi " + (s % 10) + "  Nho " + remember + "\t(" + dtf.format(LocalDateTime.now()) + ")";
            
            strArr.add(str); // thêm chuỗi diễn giải vào mảng
        } 
        show(strArr);
	return finalResult;
    }
    
    /**
     * Hàm xuất các bước tính ra màn hình
     * @param msg chứa các phần tử là chuỗi diễn giải mỗi bước tính
     */
    @Override
    public void show(ArrayList<String> msg){
        for(String x : msg){
            System.out.println(x);
        }
    }

    /**
     * @return chuỗi s1
     */
    public String getS1() {
        return s1.toString();
    }

    /**
     * @param s1 chuỗi s1 cần gán
     */
    public void setS1(String s1) {
        this.s1 = new StringBuilder(s1);
    }

    /**
     * @return chuỗi s2
     */
    public String getS2() {
        return s2.toString();
    }

    /**
     * @param s2 chuỗi s2 cần gán
     */
    public void setS2(String s2) {
        this.s2 = new StringBuilder(s2);
    }
    
    
    public static void main(String[] args) {
        MyBigNumber myBigNumber = new MyBigNumber();
        String result = myBigNumber.sum(args[0],args[1]);
        System.out.println(myBigNumber.getS1() + " + " + myBigNumber.getS2() + " = " + result);
    }
}
    
