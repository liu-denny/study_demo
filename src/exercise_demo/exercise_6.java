package exercise_demo;

/**
 * 冒泡排序、选择排序
 * @author yudong
 * @create 2019-08-13 14:54
 */
public class exercise_6 {
    public static void main(String[] args) {
        Integer arrays[] = {2, 3, 4, 511, 66, 777, 444, 555, 9999};
        exercise_6 ex = new exercise_6();
//        maopao(arrays);
//        ex.select(arrays);
//        ex.insert(arrays);
        Integer arrays1[] = {1, 4, 5, 67, 2, 7, 8, 6, 9,44};
        Integer arrays2[] = ex.quickSort(arrays1,0,arrays.length);
        for(int k=0;k<arrays2.length;k++){
            if(k == arrays2.length-1){
                System.out.println(arrays2[k]);
            }else {
                System.out.print(arrays2[k] + ",");
            }
        }
    }

    //冒泡排序
    public void maopao(Integer[] arrays){
            //临时变量
            int temp;
            //是否发生置换
            int isChange;

            for(int i=0;i<arrays.length-1;i++){
                isChange = 0;
                for(int j=0;j<arrays.length-1-i;j++){
                    if(arrays[j]>arrays[j+1]){
                        temp = arrays[j];
                        arrays[j] = arrays[j+1];
                        arrays[j+1] = temp;
                        isChange = 1;
                    }
                }
                if(isChange == 0){
                    break;
                }
            }
            for(int i=0;i<arrays.length-1;i++){
                System.out.print(arrays[i] + ",");
            }
        }

    //选择排序
    public void select(Integer[] arrays){
        //临时变量
        int temp;
        //当前最大值的下标
        int pos;
        for(int i=0;i<arrays.length-1;i++) {
            pos = 0;
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[pos]) {
                    pos = j;
                }
            }
            temp = arrays[pos];
            arrays[pos] = arrays[arrays.length-1-i];
            arrays[arrays.length-1-i] = temp;
        }
        for(int i=0;i<arrays.length-1;i++){
            System.out.print(arrays[i] + ",");
        }
    }

    //插入排序
    public void insert(Integer[] arrays){
        //临时变量
        int temp;

        for(int i=1;i<arrays.length;i++){
            temp = arrays[i];

            while(i>=1 && arrays[i-1]>temp){
                arrays[i] = arrays[i-1];
                i--;
            }
            arrays[i] = temp;
        }
        System.out.print("插入排序：");
        for(int i=0;i<arrays.length-1;i++){
            System.out.print(arrays[i] + ",");
        }
    }

    //快速排序
    public Integer[] quickSort(Integer[] arrays, int L, int R) {

        int i = L;
        int j = R;
        int pivot = arrays[(L+R)/2];
        while (i<=j){
            while (pivot>arrays[i]){i++;}
            while (pivot<arrays[j]){j--;}

            if(i<=j){
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
                i++;
                j--;
            }
        }
        if (L < j){ quickSort(arrays, L, j);}

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {quickSort(arrays, i, R);}
        return arrays;
    }
}
