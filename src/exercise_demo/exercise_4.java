package exercise_demo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yudong
 * @create 2019-08-01 9:28
 */
public class exercise_4 {
    public static void main(String[] args) {
        Date date = new Date();
        Date date1 = new Date(date.getTime()-(30*86400000));
//        System.out.println(date.getTime());
//        System.out.println(30*86400000);
        System.out.println(date);
//        System.out.println(date1);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, - 30);
        System.out.println(c.getTime());

    }
}
