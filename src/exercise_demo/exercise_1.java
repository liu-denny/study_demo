package exercise_demo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author yudong
 * @create 2019-07-23 20:04
 */

public class exercise_1 {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 1, 4, 2, 5, 4, 5, 8, 7, 8, 77, 88, 5, 4, 9, 6, 2, 4, 1, 5};
//        int[] num = new int[124];
//        for (int i = 0; i < arr.length; i++) {
//            num[arr[i]]++;
//        }
//        for (int j = 0; j < num.length; j++) {
//            if (num[j] != 0) {
//                System.out.println(j + "出现了" + num[j] + "次");
//            }
//        }
        String s ="6-17";
        List<String> ageList = Arrays.asList(s.split("-"));
        System.out.println(ageList.get(1));
    }
}
