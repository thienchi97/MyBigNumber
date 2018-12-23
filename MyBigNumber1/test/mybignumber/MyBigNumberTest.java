/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybignumber;

import org.junit.Test;
import static org.junit.Assert.*;
import mybignumber.NumberException;
import mybignumber.IReceiver;
import mybignumber.MyBigNumber;

/**
 *
 * @author ThienChi
 */
public class MyBigNumberTest implements IReceiver {

    public MyBigNumberTest() {
    }

    /**
     * Test of sum method, of class MyBigNumber.
     */
    @Test
    public void testSum1() {
            System.out.println("sum :");
            String str1 = "20";
            String str2 = "10";
            String expResult = "30";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
    
    }

    @Test
    public void testSum2() {
        
            System.out.println("sum :");
            String str1 = "99";
            String str2 = "99";
            String expResult = "198";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
       
    }

    @Test
    public void testSum3() {
 
            System.out.println("sum :");
            String str1 = "999";
            String str2 = "99";
            String expResult = "1098";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
      
    }

    @Test
    public void testSum4() {
        
            System.out.println("sum :");
            String str1 = "10";
            String str2 = "999";
            String expResult = "1009";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        
        
        
    }

    @Test
    public void testSum5() {
            System.out.println("sum :");
            String str1 = "21";
            String str2 = "11";
            String expResult = "31";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
   
    }

    @Override
    public void send(String msg) {
    }

}
