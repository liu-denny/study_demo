package exercise_demo;

/**
 * @author yudong
 * @create 2019-07-26 10:52
 */
public class exercise_3 extends exercise_3_1 implements exercise_3_2 {
    @Override
    public void method2() {
        System.out.println("this is two method");
    }

    public static void main(String[] args) {
        exercise_3_2 exercise_3_2 = new exercise_3();
        exercise_3_2.method1();
        exercise_3_2.method2();
    }
}
