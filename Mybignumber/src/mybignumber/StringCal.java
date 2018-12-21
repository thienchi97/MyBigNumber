/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybignumber;

import java.util.ArrayList;

/**
 *
 * @author ThienChi
 */
public interface StringCal {
    
    /**
     * Hàm sum trả về giá trị tổng 2 số tương ứng với 2 tham số dưới dạng chuỗi
     * @param s1 chuỗi số thứ 1
     * @param s2 chuỗi số thứ 2
     * @return chuỗi số thể hiện giá trị tổng của s1 và s2
     */
    public String sum(String s1, String s2);
    
    /**
     * Hàm xuất các bước tính ra màn hình
     * @param msg chứa các phần tử là chuỗi diễn giải mỗi bước tính
     */
    public void show(ArrayList<String> msg);
}

