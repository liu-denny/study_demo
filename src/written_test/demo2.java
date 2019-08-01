package written_test;

/**
 * @author yudong
 * @create 2019-07-30 12:26
 */

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 用1、2、2、3、4、5这六个数字，用java写一个程序，打印出所有不同的排列，如：512234、412345等，要求："4"不能在第三位，"3"与"5"不能相连
 * 未解决
 */
public class demo2 {
    String[] str = {"1", "2", "2", "3", "4", "5"};
    int n = str.length;
    boolean[] visited = new boolean[n];
    String result = "";
    TreeSet<String> ts = new TreeSet<>();
    int[][] a = new int[n][n];

    private void searchMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
        a[3][5] = 0;
        a[5][3] = 0;
        for (int i = 0; i < n; i++) {
            search(i);
        }
        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.indexOf("4") != 2) {
                System.out.println(s);
            }
        }
    }

    private void search(int startIndex) {
        visited[startIndex] = true;
        result = result + str[startIndex];
        if (result.length() == n) {
            ts.add(result);
        }
        for (int j = 0; j < n; j++) {
            if (a[startIndex][j] == 1 && visited[j] == false) {
                search(j);
            } else {
                continue;
            }
        }

        result = result.substring(0, result.length() - 1);
        visited[startIndex] = false;
    }

    public static void main(String[] args) {
        new demo2().searchMap();
    }
}
