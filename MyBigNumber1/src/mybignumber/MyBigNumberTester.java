/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybignumber;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author ThienChi
 */
public class MyBigNumberTester implements IReceiver {
    public static void main(String[] args) throws Exception{
        
        String s1,s2;

        BufferedReader reader; // Lớp đọc giá trị nhập vào
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t\t\t~ Cong 2 so ~");
        System.out.print("Nhap vao so a: ");
        s1 = reader.readLine();
        System.out.print("Nhap vao so b: ");
        s2 = reader.readLine();
        System.out.println("Loi giai");
        MyBigNumberTester test= new MyBigNumberTester();
        MyBigNumber myBigNumber = new MyBigNumber(test);
        String result = myBigNumber.sum(s1,s2);
        if (!result.equals("")) {
            System.out.println(s1 + " + " + s2 + " = " + result);
        }
    }

    @Override
    public void send(String msg) {
       System.out.print(msg);
    }
}
