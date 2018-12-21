import java.util.ArrayList;

/**
 * Tác giả: Nguyễn Thiện chí.
 * DesCription.
 * IStrCalculator chứa hàm tính tổng 2 chuỗi số và hàm xuất ra màn hình các bước tính.
 */
public interface IStrCalculator {
    
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
