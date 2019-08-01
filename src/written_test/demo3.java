package written_test;

/**
 * @author yudong
 * @create 2019-07-31 9:31
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 两个队列模拟一个堆栈，队列是先进先出的，堆栈是先进后出的
 * 思路：队列a和b
 * 入栈：a队列为空，b为空，将“a,b,c,d,e”先放入a中，a进栈为“a,b,c,d,e”
 * 出栈：将a队列依次加入ArrayList集合c中，以倒序的方法，将c中的集合取出，放入b中，再将b队列出列
 */
public class demo3 {
    public static void main(String[] args) {
        Queue<String> a = new LinkedList<>();
        Queue<String> b = new LinkedList<>();
        List<String> c = new ArrayList<>();

        a.offer("a");
        a.offer("b");
        a.offer("c");
        a.offer("d");
        a.offer("e");
        System.out.print("进栈：");
        for (String s : a) {
            c.add(s);
            System.out.print(s);
        }

        for (int i = c.size() - 1; i >= 0; i--) {
            b.offer(c.get(i));
        }

        System.out.println();
        System.out.print("出栈：");
        for (String s : b) {
            System.out.print(s);
        }
    }
}
