package clone_demo;

/**
 * @author yudong
 * @create 2019-07-18 10:55
 */
public class test {
    public static void main(String[] args) {
        //复制
//        People1 people1 = new People1("people",18);
//        People1 people11 = people1;
//
//        System.out.println(people1);
//        System.out.println(people11);
//        System.out.println(people1 == people11);
        //clone
        People2 people2 = new People2("people",18);
        People2 people22 = null;
        try {
            people22 = (People2) people2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

//        System.out.println(people2);
//        System.out.println(people22);
//        System.out.println(people2 == people22);

        System.out.println(people2.getName() == people22.getName());

        people22.setName("xiaoming");
        System.out.println(people2.getName());
        System.out.println(people22.getName());
    }
}
